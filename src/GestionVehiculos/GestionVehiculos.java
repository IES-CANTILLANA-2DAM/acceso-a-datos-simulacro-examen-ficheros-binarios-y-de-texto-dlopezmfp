package GestionVehiculos;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionVehiculos {
    public static void escribirVehiculos() {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        System.out.print("¿Cuántos vehiculos quieres introducir? ");
        int cantidad = teclado.nextInt();
        teclado.nextLine();

        for (int i = 0; i < cantidad; i++) {

            System.out.println("Marca del vehículo " + (i + 1) + " :");
            String marca = teclado.nextLine();
            System.out.print("Modelo del vehículo: " + (i + 1) + " :");
            String modelo = teclado.nextLine();
            System.out.print("Precio del vehículo " + (i + 1) + " :");
            double precio = Double.parseDouble(teclado.nextLine());
            vehiculos.add(new Vehiculo(marca, modelo, precio));
        }

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream("vehiculos.dat"))) {

            oos.writeObject(vehiculos);

            System.out.println("Vehiculos guardados correctamente.");

        } catch (IOException e) {
            System.out.println("Error al guardar los vehiculos: " + e.getMessage());
        }
    }

    public static void leerVehiculos(double limitePrecio) {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream("vehiculos.dat"))) {

            ArrayList<Vehiculo> vehiculos =
                    (ArrayList<Vehiculo>) ois.readObject();
            System.out.println("Los vehículos introducidos son: ");
            for (Vehiculo vehiculo : vehiculos) {
                if(vehiculo.getPrecio() >= limitePrecio){
                    System.out.println(vehiculo);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado productos.dat");
        } catch (IOException e) {
            System.out.println("Error al leer los productos: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("No se ha encontrado la clase Producto.");
        }
    }

    public static void main(String[] args) {
        escribirVehiculos();
        System.out.println("´Los vehiculos totales son: ");
        leerVehiculos(0);
        System.out.println("Los vehículos que valen más de 15000 euros son: ");
        leerVehiculos(15000);
    }

}

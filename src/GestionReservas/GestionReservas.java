package GestionReservas;

import java.io.*;
import java.util.Scanner;

public class GestionReservas {
    public static void escrituraReservas(){
        String cliente,nHabitacion,nNoches;
        int nReservas;
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca el número de reservas: ");
        nReservas = Integer.parseInt(sc.nextLine());
        try (FileWriter fw = new FileWriter("reservas.txt");
             PrintWriter pw = new PrintWriter(fw)) {
            for (int i = 0; i < nReservas; i++) {
                System.out.print("Introduzca el nombre de la reserva número " + (i + 1) + ":");
                cliente = sc.nextLine();
                System.out.print("Introduzca el numero de habitacion de la reserva nº" + (i + 1) + ":");
                nHabitacion = sc.nextLine();
                System.out.print("Introduzca el numero de noches de la reserva número " + (i + 1) + ":");
                nNoches = sc.nextLine();
                pw.println(cliente+";"+nHabitacion+";"+nNoches);
            }
        } catch (FileNotFoundException e) {
        System.out.println("No se ha encontrado texto.txt");
        } catch (IOException e) {
        System.out.println("Error al leer el fichero: " + e.getMessage());
        }
    }
    public static void lecturaReservas(){
        int nLineas =0,sumaNoches=0;
        String[] campos;
        try (FileReader fr = new FileReader("reservas.txt");
             BufferedReader br = new BufferedReader(fr)) {
            String linea;
            System.out.println("Las reservas son: ");
            while ((linea = br.readLine()) != null) {
                nLineas+=1;
                campos = linea.split(";");
                sumaNoches+= Integer.parseInt(campos[2]);
                System.out.println(linea);
            }
            System.out.println("El número de registros leídos es: "+nLineas);
            System.out.println("El número de noches acumuladas es: "+sumaNoches);

        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero persona.txt");
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
    }
    public static void main(String[] args){
        escrituraReservas();
        lecturaReservas();
    }
}
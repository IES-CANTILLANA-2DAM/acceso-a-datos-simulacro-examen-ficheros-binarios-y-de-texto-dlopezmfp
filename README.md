# SIULACRO EXAMEN 28_10
## ACLARACIONES DEL EXAMEN
* En este código se observa cómo divido el campo de texto que he leído en campos y selecciono el campo de número de noches con la función Split
``` java
while ((linea = br.readLine()) != null) {
                nLineas+=1;
                campos = linea.split(";");
                sumaNoches+= Integer.parseInt(campos[2]);
                System.out.println(linea);
            }
```
## PRUEBAS

![Imagen de prueba](/imagenes/prueba1_vehiculos.png)
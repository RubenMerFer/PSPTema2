package procesos.ejercicio1Multiple;

import ejemplos.ProcesosUtils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1Multiple {

    public static void main(String[] args) throws IOException {
//       // String ruta= ProcesosUtils.RUTA_CLASS;/*En clase*/
//        String ruta= ProcesosUtils.RUTA_CASA;/*En casa*/
//        //String nombreClase= "out/production/PSPTema2";
//        String nombreClase= "procesos.ejercicio1Multiple.HolaMundoMultiple";
//
//
//        String ficheroSalida="salidaInvocadorMultiple.txt";
//        String ficheroError= "errorInvocadorMultiple.txt";
//        Scanner entrada= new Scanner(System.in);
//        int numeroProcesos=0;
//        System.out.println("ESCRIBE UN NÚMERO TOTAL DE PROCESOS A EJECUTAR");
//        numeroProcesos= entrada.nextInt();
//
//
//        ProcessBuilder constructorProcesos = new ProcessBuilder("java", nombreClase,
//                String.valueOf(numeroProcesos));
//
//        constructorProcesos.directory(new File(ruta));
//        constructorProcesos.redirectOutput(ProcessBuilder.Redirect.appendTo(new File(ficheroSalida)));
//        constructorProcesos.redirectError(ProcessBuilder.Redirect.appendTo(new File(ficheroError)));
//
//        // Crear el Scanner para leer la salida estándar de los procesos hijos
//        Scanner entrada2 = new Scanner(System.in);
//
//        //Bucle
//        for (int cont=0; cont<numeroProcesos; cont++){
//            constructorProcesos.command("java", nombreClase, String.valueOf(cont));
//
//            Process hijo= constructorProcesos.start();
//            //Leemos y mostramos la salida estándar del proceso hijo en tiempo real
//             entrada2= new Scanner(hijo.getInputStream());
//
//            while (entrada2.hasNextLine()){
//                System.out.println(entrada2.nextLine());
//            }
//
//            //Cerramos el Scanner después de cada proceso hijo
//            entrada2.close();;
//        }
//
//        try {
//            //Process hijo= constructorProcesos.start();
//
//            //Esperamos a que hijo acabe
//            //hijo.waitFor();
//
//            System.out.println("PROCESO LANZADO");
//        } catch (Exception e) {
//            System.out.println("Ha habido un error: " + e);
//            throw new RuntimeException(e);
//        }
//
//        System.out.println("La parte del invocador ha terminado");

        //Versión Stelian

        File ruta = new File(ProcesosUtils.RUTA_CLASS);

        String nombreClase = "procesos.ejercicio1Multiple.HolaMundoMultiple";

        File salidaMultiple = new File("salidaMultiple.txt");

        File salidaError = new File("errorMultiple.txt");

        Scanner scanner = new Scanner(System.in);

        System.out.println("INTRODUCE EL NUMERO DE PROCESOS: ");

        int totalProcesos = scanner.nextInt();

        for (int cont = 0; cont <= totalProcesos; cont++) {

            ProcessBuilder constructorProcesos = new ProcessBuilder("java", nombreClase, String.valueOf(cont));

            constructorProcesos.redirectOutput(ProcessBuilder.Redirect.INHERIT); //SE COMENTA PARA EL APARTADO 2.5

            constructorProcesos.redirectError(ProcessBuilder.Redirect.INHERIT); //SE COMENTA PARA EL APARTADO 2.5

            constructorProcesos.inheritIO(); ////SE COMENTA PARA EL APARTADO 3 Y SE DESCOMNETA LO NECESARIO HASTA VOLVER AL EJERCICIO BASE

            constructorProcesos.directory(ruta);

//            constructorProcesos.redirectOutput(ProcessBuilder.Redirect.appendTo(salidaMultiple)); //SE COMENTA PARA EL APARTADO 2.4

//            constructorProcesos.redirectError(ProcessBuilder.Redirect.appendTo(salidaError)); //SE COMENTA PARA EL APARTADO 2.4

            try {

                Process hijo = constructorProcesos.start();


                hijo.waitFor(); // Apartado 2.2 ------ SE COMENTA PARA EL APARTADO 2.4

//                ProcesosUtils.imprimirSalidaHijo(hijo); // Apartado 2.4 ------ SE COMENTA PARA EL APARTADO 2.5

            } catch (IOException e) {

                throw new RuntimeException(e);

            } catch (InterruptedException e) { //SE COMENTA PARA EL APARTADO 2.4

                throw new RuntimeException(e);

            }
        }

        System.out.println("SE HA TERMINADO ADECUADAMENTE EL PROCESO");

    }



    }


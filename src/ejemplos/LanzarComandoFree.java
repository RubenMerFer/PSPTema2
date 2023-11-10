package ejemplos;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class LanzarComandoFree {
    public static void main(String[] args) {

        ProcessBuilder constructorProcesos = new ProcessBuilder();

//        String rutaCarpeta = "/home/alumno/Escritorio"; //En clase
         String rutaCarpeta= "C:\\Users\\admin\\Desktop"; //En casa
        String rutaSalida= "salidaFree.txt";
        constructorProcesos.directory(new File(rutaCarpeta));

        //"bash", "-c", "ping google.com"
        //constructorProcesos.command("free"); //En clase
        constructorProcesos.command("tasklist"); //En casa

        try{
            //Lanzar el hijo
            Process hijo=constructorProcesos.start();
            //Coger el String conectado a su salida y leerlo
            ProcesosUtils.imprimirSalidaHijo(hijo);


            hijo.waitFor();// Espera hasta que el hijo termine

            System.out.println("PROCESO LANZADO...");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


    }


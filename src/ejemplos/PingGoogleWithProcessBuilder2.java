package ejemplos;

import java.io.*;
//import  procesos.utils.ProcesosUtils;

public class PingGoogleWithProcessBuilder2 {
    public static void main(String[] args) {
        ProcessBuilder constructorProceso = new ProcessBuilder();

        //DE CLASE
//        constructorProceso.command("bash", "-c", "ping google.com");
        //

        //DE CASA
        constructorProceso.command("ping", "google.com");
        //

        String rutaSalida= "salidaPing.txt";

        try{
            constructorProceso.redirectOutput(ProcessBuilder.Redirect.appendTo(new File(rutaSalida)));
            Process hijo= constructorProceso.start();
            //ProcesosUtils.imprimirSalidaHijo(hijo);

            int exitValue = hijo.waitFor();

            System.out.println("EL PROCESO HIJO HA TERMINADO");
            if (exitValue == 0) {
                System.out.println("Ping exitoso: El host está disponible.");
            } else {
                System.out.println("Ping fallido: El host no está disponible.");
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

package ejemplos;

import java.io.*;

public class LanzarSalidaNetstat {
    public static void main(String[] args) {
        ProcessBuilder constructorProceso = new ProcessBuilder();

        //DE CLASE
//        constructorProceso.command("bash", "-c", "netstat");
        //

        //DE CASA
        constructorProceso.command("netstat");
        //

        String rutaSalida= "salidaNetstat.txt";

        try{
            constructorProceso.redirectOutput(ProcessBuilder.Redirect.appendTo(new File(rutaSalida)));
            Process hijo= constructorProceso.start();
            //ProcesosUtils.imprimirSalidaHijo(hijo);

            int exitValue =hijo.waitFor();

            System.out.println("EL PROCESO HIJO HA TERMINADO. VALOR SALIDA: " + ProcesosUtils.traducirCodigoSalida(exitValue));

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

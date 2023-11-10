package ejemplos;

import java.io.File;
import java.io.IOException;

public class LanzarComandoLS {
    public static void main(String[] args) {
/*
        ProcessBuilder constructorProcesos = new ProcessBuilder(); //En clase

        //String rutaCarpeta = "/home/alumno/Escritorio"; //En clase
        String rutaSalida= "salidaLs.txt";
        constructorProcesos.directory(new File(rutaCarpeta));
        //constructorProcesos.command("ls"); //En clase
        */ //DE CLASE
        //DE CASA
        String rutaCarpeta= "C:\\Users\\admin\\Desktop"; //En casa
        String rutaSalida= "salidaLs.txt";
        String comando = "cmd /c dir"; //En casa

        try{
            //DE CASA
            ProcessBuilder constructorProcesos= new ProcessBuilder("cmd", "/c", "dir");
            constructorProcesos.directory(new File(rutaCarpeta));
            //
            constructorProcesos.redirectOutput(ProcessBuilder.Redirect.appendTo(new File(rutaSalida)));
            constructorProcesos.start();

            System.out.println("PROCESO LANZADO...");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

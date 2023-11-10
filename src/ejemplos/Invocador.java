package ejemplos;



import java.io.File;
import java.io.IOException;

public class Invocador {

    public static void main(String[] args) {
        String ruta= ProcesosUtils.RUTA_CLASS;
      //  String nombreClase= "\"out/production/PSPTema2\"";
        String nombreClase= "ejemplos.CorreccionHolaProceso";
        String ficheroSalida="salidaInvocador.txt";
        String ficheroError= "errorInvocador.txt";

        int numeroArgumento=5;

        ProcessBuilder constructorProcesos = new ProcessBuilder("java", nombreClase,
                String.valueOf(numeroArgumento));

        constructorProcesos.directory(new File(ruta));
        constructorProcesos.redirectOutput(ProcessBuilder.Redirect.appendTo(new File(ficheroSalida)));
        constructorProcesos.redirectError(ProcessBuilder.Redirect.appendTo(new File(ficheroError)));

        try {
            constructorProcesos.start();
        } catch (IOException e) {
            System.out.println("Ha habido un error: " + e);
            throw new RuntimeException(e);
        }


        System.out.println("La parte del invocador ha terminado");
    }
}

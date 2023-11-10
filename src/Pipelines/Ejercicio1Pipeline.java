package Pipelines;

import ejemplos.ProcesosUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Ejercicio1Pipeline {

    public static void main(String[] args) {
        //Construyo los 3 ProcessBuilder, uno por comando

        //DE CLASE
//        ProcessBuilder listaProcesos= new ProcessBuilder("bash", "-c", "ps -e");
//        ProcessBuilder filtrado= new ProcessBuilder("bash", "-c", "grep firefox");
//        ProcessBuilder contarLineas= new ProcessBuilder("bash", "-c", "wc -l");

        //
/*
        //DE CASA
        ProcessBuilder listaProcesos= new ProcessBuilder("cmd", "/c", "tasklist");
        ProcessBuilder filtrado= new ProcessBuilder("cmd", "/c", "findstr chrome");
        ProcessBuilder contarLineas = new ProcessBuilder("cmd", "/c", "find /c /v \"chrome\"");

        //

        ProcessBuilder multiplicador = new ProcessBuilder("java", Multiplicador.class.getName());
        multiplicador.directory(new File(ProcesosUtils.RUTA_CLASS));
        multiplicador.redirectInput(ProcessBuilder.Redirect.PIPE);



        //contarLineas.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        try{

            System.out.println("antes de procesos");
            List<Process> hijosLanzados= ProcessBuilder.startPipeline(Arrays.asList(listaProcesos, filtrado, contarLineas, multiplicador));
            System.out.println("proceos");
            //Cojo el último proceso hijo
            Process ultimoHijo= hijosLanzados.get(hijosLanzados.size()-1);
            ProcesosUtils.imprimirSalidaHijo(ultimoHijo);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
*/

        // Construye los 3 ProcessBuilder, uno por comando

        //DE CLASE
        ProcessBuilder listaProcesos= new ProcessBuilder("bash", "-c", "ps -e");
        ProcessBuilder filtrado= new ProcessBuilder("bash", "-c", "grep firefox");
        ProcessBuilder contarLineas= new ProcessBuilder("bash", "-c", "wc -l");

        //

        // DE CASA
//        ProcessBuilder listaProcesos = new ProcessBuilder("cmd", "/c", "tasklist");
//        ProcessBuilder filtrado = new ProcessBuilder("cmd", "/c", "findstr chrome");
//        ProcessBuilder contarLineas = new ProcessBuilder("cmd", "/c", "find /c /v chrome");

        // Configura la entrada estándar del proceso multiplicador
        ProcessBuilder multiplicador = new ProcessBuilder("java", Multiplicador.class.getName());
        multiplicador.directory(new File(ProcesosUtils.RUTA_CLASS));
        multiplicador.redirectInput(ProcessBuilder.Redirect.PIPE);

        try {
            System.out.println("antes de procesos");

            List<Process> hijosLanzados = ProcessBuilder.startPipeline(Arrays.asList(listaProcesos, filtrado, contarLineas));
            System.out.println("procesos");

            // Cojo el último proceso hijo
            Process ultimoHijo = hijosLanzados.get(hijosLanzados.size() - 1);

            // Espera a que los procesos anteriores finalicen
            int exitCode= ultimoHijo.waitFor();


            // Ahora inicia el proceso multiplicador
            if (exitCode == 0) {
                System.out.println("PON UN NÚMERO Y SE MULTIPLICARÁ POR SÍ MISMO: ");
                Process multiplicadorProcess = multiplicador.start();
                multiplicadorProcess.waitFor();

                System.out.println("Proceso multiplicador finalizado.");
            }
            System.out.println("Proceso hijo terminado con código de salida: " + exitCode);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
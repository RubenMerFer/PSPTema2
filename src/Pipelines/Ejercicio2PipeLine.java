package Pipelines;

import ejemplos.ProcesosUtils;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ejercicio2PipeLine {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        System.out.println("NUMERO A PASAR POR LA PICADORA:");
        int numero = entrada.nextInt();
        //Construyo los 3 ProcessBuilder, uno por comando
        /*Para los de windows tasklist (sustituye al ps- e)*/

        ProcessBuilder inicial= new ProcessBuilder("java", Inicial.class.getName(), String.valueOf(numero));
        inicial.directory(new File(ProcesosUtils.RUTA_CLASS));

        ProcessBuilder multiplicador= new ProcessBuilder("java", Multiplicador.class.getName());
        multiplicador.directory(new File(ProcesosUtils.RUTA_CLASS));

        ProcessBuilder sumador= new ProcessBuilder("java", Sumador.class.getName());
        sumador.directory(new File(ProcesosUtils.RUTA_CLASS));
        sumador.redirectOutput(ProcessBuilder.Redirect.INHERIT);

        /*en windows: ProcessBuilder listaProcesos= new ProcessBuilder("cmd", "-c", "tasklist");
        * ProcessBuilder filtrado= new ProcessBuilder("cmd", "-c", "grep chromium");
         ProcessBuilder contarLineas= new ProcessBuilder("cmd", "-c", "wc -l");*/

        try {
            List<Process> procesos = ProcessBuilder.startPipeline(Arrays.asList(inicial, multiplicador, sumador));

            Process ultimoHijo = procesos.get(procesos.size()-1);
            System.out.println("LA SALIDA ES...");
            ProcesosUtils.imprimirSalidaHijo(ultimoHijo);

        } catch (Exception e){

        }

    }

}

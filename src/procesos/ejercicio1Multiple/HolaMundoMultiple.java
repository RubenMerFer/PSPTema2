package procesos.ejercicio1Multiple;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

import static ejemplos.ProcesosUtils.NOMBRE;
import static ejemplos.ProcesosUtils.obtenerHoraActual;

public class HolaMundoMultiple {

    public static void main(String[] args) throws InterruptedException {
        int numeroArgumento= Integer.parseInt(args[0]);

        if (numeroArgumento % 2 == 0){
            throw new RuntimeException("PROCESO DICE: ¡EL NÚMERO " + numeroArgumento + " ES UN NÚMERO PROHIBIDO!");
        } else {
            Thread.sleep(numeroArgumento * 1000); // Apartado 2.3
            System.out.println("MI AMO/A ES " + NOMBRE+". HE RECIBIDO EL NÚMERO " +numeroArgumento+ ", SON LAS " + obtenerHoraActual());
        }


    }







}

package ejemplos;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

public class ProcesosUtils {
    public static final String RUTA_CLASS = "out/production/PSPTema2";
    public static final String RUTA_CASA = "out/production/PSPTema2";

    /*Ejercicio ampliación procesos 1)*/
    public static final String NOMBRE = "Ruben";
    /**/
    public static void imprimirSalidaHijo(Process hijo) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(hijo.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

    public static String traducirCodigoSalida(int value) {
        return value == 0 ? "[ÉXITO]" : "[FALLO]";
    }

    /*Ejercicio ampliación procesos 1)*/
    public static String obtenerNombre() {

        return NOMBRE;
    }

    /***Obtiene la zona actual de la zona horaria de la zona horaria de Madrid (Europa)
     * @return
     */

    public static String obtenerHoraActual(){
        LocalTime horaActual= LocalDateTime.now(ZoneId.of("Europe/Madrid")).toLocalTime();
        return horaActual.toString();
    }
    /**/
}//Fin class





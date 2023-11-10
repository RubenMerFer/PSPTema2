package ejemplos;

import javax.imageio.IIOException;
import java.io.IOException;

public class LanzarProcesoExterno {

    public static void main(String[] args) {
        String ruta="/usr/lib/firefox/firefox.sh";

        ProcessBuilder constructorProcesos = new ProcessBuilder(ruta);
        constructorProcesos.command(ruta);
        try {
            Process hijo = constructorProcesos.start();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

}

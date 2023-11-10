package ejemplos;

import javax.imageio.IIOException;
import java.io.IOException;

public class LanzarProcesoExternoConWindows {

    public static void main(String[] args) {
        String ruta="C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";

        ProcessBuilder constructorProcesos = new ProcessBuilder(ruta);

        try {
            constructorProcesos.start();
        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }
}

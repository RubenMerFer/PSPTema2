package ejemplos;

import java.io.File;
import java.io.IOException;

public class CorreccionHolaProceso {

    public static void main(String[] args) {
        String argumento= args[0];

        Integer numero= 0;
        try{
            numero= Integer.parseInt(argumento);
        }catch (NumberFormatException e){
            System.out.println("ERROR AL PARSEAR EL ARGUMENTO");
            throw e;
        }
        System.out.println("HolaProceso-. EL NÚMERO ES: " + numero);

    }

}

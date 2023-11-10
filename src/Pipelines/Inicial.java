package Pipelines;

public class Inicial {

    public static void main(String[] args) {

        String numeroRecibido = args[0];

        try{
            Integer numero = Integer.parseInt(numeroRecibido);

            //Imprimimos en la salida estándar para que se pase al siguiente proceso
            System.out.println(numero);

        } catch (Exception e){
            System.out.println("NO ES UN NÚMERO: " + e);
        }

    }

}

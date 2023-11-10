package PSPTema3.interrupciones;

public class Padre {

    public static void main(String[] args) {
        System.out.println("BUENAS, SOY EL PADRE");

        //Creamos el hijo y mostramos el estado
        Hijo miHiloHijo= new Hijo();
        System.out.println("EL ESTADO DE MI HIJO ES " + miHiloHijo.getState() +". ¿VIVO? "
                + miHiloHijo.isAlive());

        //Arrancamos y mostramos el estado del hijo
        miHiloHijo.start();
        System.out.println("EL ESTADO DE MI HIJO DESPUÉS DE INICIAR ES " + miHiloHijo.getState());

        //Esperamos a que termine, y luego me despido
        try{
            miHiloHijo.join(5000);

            System.out.println("¿SIGUE DORMIDO? " + miHiloHijo.getState() +". ¿SIGUE VIVO? "
            + miHiloHijo.isAlive());
            miHiloHijo.interrupt();

        } catch (Exception e){
            System.out.println(e);
        }

        System.out.println("MI HIJO TERMINÓ YA");
    }
}

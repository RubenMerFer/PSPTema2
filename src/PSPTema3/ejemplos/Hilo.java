package PSPTema3.ejemplos;

public class Hilo implements Runnable {

    private final String nombre;
    public Hilo(String nombre){
        this.nombre=nombre;
    }

    //Método run

    @Override
    public void run() {
        System.out.println(String.format("%s: HOLA, SOY " +
                "EL HILO %s ", this.nombre, this.nombre));

        System.out.println(String.format("%s: HE " +
                "TERMINADO ", this.nombre));
    }
}

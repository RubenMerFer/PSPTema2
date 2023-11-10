package PSPTema3.ejemplos;

public class LanzaHilos {

    public static void main(String[] args) {

        //Creamos hilos pasándole una clase que implemente Runnable
        Thread hilo1= new Thread(new Hilo("H1"));
        Thread hilo2= new Thread(new Hilo("H2"));

        hilo1.start();
        hilo2.start();

        System.out.println("EL HILO PRINCIPAL HA TERMINADO");
    }

}

package PSPTema3.ejemplos;

public class LanzarThreads {

    public static void main(String[] args) {

        System.out.println("SOY EL HILO PRINCIPAL");
        HiloThread hiloConThread= new HiloThread();
        hiloConThread.start();

        System.out.println("PROCESO TERMINADO");
    }

}

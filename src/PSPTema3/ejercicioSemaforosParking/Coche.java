package PSPTema3.ejercicioSemaforosParking;

import java.util.concurrent.Semaphore;
import java.util.Random;

public class Coche extends Thread{

    //Variables
    private Semaphore semaforo;
    private int numeroCoche;

    private boolean expulsado;

    //Constructor
    public Coche(Semaphore semaforo, int numeroCoche) {
        this.semaforo = semaforo;
        this.numeroCoche= numeroCoche;
    }

    //Getters y setters
    public Semaphore getSemaforo() {
        return semaforo;
    }

    public void setSemaforo(Semaphore semaforo) {
        this.semaforo = semaforo;
    }

    public int getNumeroCoche() {
        return numeroCoche;
    }

    public void setNumeroCoche(int numeroCoche) {
        this.numeroCoche = numeroCoche;
    }

    public boolean isExpulsado() {
        return expulsado;
    }

    public void setExpulsado(boolean expulsado) {
        this.expulsado = expulsado;
    }
    //Método run
    @Override
    public void run() {

        while (true && !expulsado){
            Random random= new Random();
            int tiempoEspera= random.nextInt(4000)+1000;
            System.out.println("EL COCHE " + numeroCoche + " RECORRE LA CIUDAD " + tiempoEspera + " MS");

            try{
                Thread.sleep(tiempoEspera);
            }catch (InterruptedException e){
                System.out.println("EL COCHE " + numeroCoche + " HA SIDO DESPERTADO");
                expulsado = true; //El coche ha sido expulsado
                semaforo.release(); //Liberamos el semáforo
                System.out.println("EL COCHE " + numeroCoche + " HA SIDO DESPERTADO Y EXPULSADO");
            }

            System.out.println("EL COCHE " + numeroCoche + " VA A INTENTAR ENTRAR AL PARKING");

            //Obtenemos el número de coches en la cola
            int cochesEnCola= getSemaforo().getQueueLength(); /*El método getQueueLength() devuelve
                una estimación del número de subprocesos en espera de adquisición (definición API)*/

            //Obtenemos el número de plazas libres
            int plazasLibres = semaforo.availablePermits(); /*El método availablePermits devuelve el número
                actual de permisos disponibles en este semáforo (definición API)*/

            System.out.println("COCHES EN COLA: " + cochesEnCola);
            System.out.println("PLAZAS LIBRES: " + plazasLibres);

            if (cochesEnCola <= 5){
                System.out.println("ENTRAMOS AL PARKING...");

                try {
                    semaforo.acquire(); /*El método acquire() adquiere un permiso de este semáforo, bloqueándolo
                         hasta que haya uno disponible o se interrumpa el hilo (definición API)  */

                    System.out.println("EL COCHE " + numeroCoche + " HA ENTRADO AL PARKING");

                    //Simulamos el tiempo dentro del parking
                    int tiempoDentroDeParking= random.nextInt(4000) + 1000;
                    System.out.println("EL COCHE " + numeroCoche + " ESTÁ DENTRO DEL PARKING POR " + tiempoDentroDeParking + " MS");
                    Thread.sleep(tiempoDentroDeParking);

                    //salimos del parking y liberamos el semáforo
                    semaforo.release(); /*El método release() libera un permiso y lo devuelve al semáforo
                        (definición API)*/
                    System.out.println("EL COCHE " + numeroCoche + " HA SALIDO DEL PARKING");
                } catch (InterruptedException ex) {
                    System.out.println("EL COCHE " + numeroCoche + "FUE INTERRUMPIDO MIENTRAS ESPERABA EN EL PARKING");
                    throw new RuntimeException(ex);
                }

            }// Fin if (cochesEnCola <= 5)
            else {
                System.out.println("HAY MUCHA COLA EN EL PARKING, MEJOR DAMOS OTRA VUELTA");
            }

        }// Fin while
        System.out.println("EL COCHE " + numeroCoche + " HA SIDO EXPULSADO. FIN DE SU VIDA");
    }// Fin run
}

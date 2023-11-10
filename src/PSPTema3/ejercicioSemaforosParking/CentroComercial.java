package PSPTema3.ejercicioSemaforosParking;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.Scanner;

public class CentroComercial {

    private static final int numTotalCoches=23;
    private static final int numPlazasParking=2;

    public static void main(String[] args) {
        Semaphore semaforoEstacionamiento= new Semaphore(numPlazasParking, true);
//        int prioridadBase=1; //Prioridad mínima
//        int prioridadIncremento= 1; //Incremento de prioridad para cada coche
        List<Coche> coches= new ArrayList<>();

        for (int i=1; i<= numTotalCoches; i++){
            Coche coche= new Coche(semaforoEstacionamiento,i);

//            //Ajustamos la prioridad dentro del rango válido
//            coche.setPriority(prioridadBase);
//            prioridadBase += prioridadIncremento;

            //Asignamos la prioridad igual a su número de coche
            coche.setPriority(i);

            //Arrancamos el hilo
            coche.start();
            coches.add(coche);
        }//Fin for

        boolean cochesVivos= true;
        Scanner entrada= new Scanner(System.in);

        while (cochesVivos){
            System.out.println("ESCRIBE NÚMERO DE COCHE A MATAR");
            int numeroCocheAMatar= entrada.nextInt();

            for (Coche coche: coches){
                if (coche.getNumeroCoche() == numeroCocheAMatar){
                    coche.interrupt(); //Interrumpimos el hilo del coche
                    coche.setExpulsado(true); //Marcamos el coche como expulsado
                    coche.getSemaforo().release(); //Liberamos el semáforo
                }
            }//Fin for
            cochesVivos= false;

            for (Coche coche: coches){
                if (!coche.isExpulsado()){
                    cochesVivos= true;
                    break;
                }
            }// Fin for
        }// Fin while

        System.out.println("TODOS LOS COCHES HAN SIDO EXPULSADOS");
    }
}

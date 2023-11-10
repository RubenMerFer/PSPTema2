package PSPTema3.ejercicios;

import java.util.Scanner;

public class CoordinadorCarrera {

    public static void main(String[] args) throws InterruptedException {
        Scanner entrada= new Scanner(System.in);

        System.out.print("CORREDOR 1: ");
        String corredor1= entrada.nextLine();

        System.out.print("CORREDOR 2: ");
        String corredor2= entrada.nextLine();

        System.out.print("CORREDOR 3: ");
        String corredor3= entrada.nextLine();

        Corredor c1 = new Corredor(corredor1);
        Corredor c2 = new Corredor(corredor2);
        Corredor c3 = new Corredor(corredor3);

        c1.start();
        c2.start();
        c3.start();

        c1.join();
        c2.join();
        c3.join();

        System.out.println("FIN DEL LA CARRERA...");

        /*c1:3
        * c2:2
        * c3:1*/

        if (c1.getTiempoTotal() > c2.getTiempoTotal()){

            if (c1.getTiempoTotal() < c3.getTiempoTotal()){
                System.out.println("GANÓ " + corredor2 +", TIEMPO TOTAL: " + c2.getTiempoTotal());
            } else if (c2.getTiempoTotal() < c3.getTiempoTotal()){
                System.out.println("GANÓ " + corredor2 +", TIEMPO TOTAL: " + c2.getTiempoTotal());
            }else{ //c2 > c3
                System.out.println("GANÓ " + corredor3 +", TIEMPO TOTAL: " + c3.getTiempoTotal());
            }

        }//Fin if c1.getTiempoTotal() > c2.getTiempoTotal()
        else{ //if c1.getTiempoTotal() < c2.getTiempoTotal()

            if (c2.getTiempoTotal() < c3.getTiempoTotal()){
                System.out.println("GANÓ " + corredor1 +", TIEMPO TOTAL: " + c1.getTiempoTotal());
            } else if (c1.getTiempoTotal() < c3.getTiempoTotal()){
                System.out.println("GANÓ " + corredor1 +", TIEMPO TOTAL: " + c1.getTiempoTotal());
            } else{ // c1 > c3
                System.out.println("GANÓ " + corredor3 +", TIEMPO TOTAL: " + c3.getTiempoTotal());
            }
        }// fin if c1.getTiempoTotal() < c2.getTiempoTotal()



    }

}

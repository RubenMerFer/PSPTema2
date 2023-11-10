package PSPTema3.ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoordinadorCarreraSolucion {

    public static void main(String[] args) throws InterruptedException {
        Scanner entrada= new Scanner(System.in);
        List<Corredor> corredores = new ArrayList<>();

        for (int i=1; i<=3; i++){
            System.out.print("NOMBRE DEL CORREDOR " + i + ": ");
            String nombre = entrada.nextLine();

            Corredor corredor = new Corredor(nombre);
            corredores.add(corredor);




        }//Fin 1º for
        entrada.close();// Cerramos el Scanner

        for (Corredor corredor : corredores){
            corredor.start();
        }// Fin 2º for

        for (Corredor corredor : corredores){
            try{
                corredor.join();
            } catch (InterruptedException e){
                System.out.println(e);
            }
        }// Fin 3º for
        System.out.println("FIN DEL LA CARRERA...");

        Corredor ganador = corredores.get(0);
        for (Corredor corredor : corredores){
            if (corredor.getTiempoTotal() < ganador.getTiempoTotal()){
                ganador = corredor;
            }
        }
        System.out.println("GANÓ " + ganador.getNombre() +", TIEMPO TOTAL: " + ganador.getTiempoTotal());


    }

}

package Pipelines;

import java.util.Scanner;

public class Sumador {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
//        System.out.print("PON UN NÚMERO Y SE SUMARÁ POR SÍ MISMO: ");
        Integer numeroRecibido = entrada.nextInt();

        //Sumamos por el mismo
        numeroRecibido += numeroRecibido;

        System.out.println(numeroRecibido);
    }
}

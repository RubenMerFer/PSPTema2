package Pipelines;

import java.util.Scanner;

public class Multiplicador {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
//        System.out.print("PON UN NÚMERO Y SE MULTIPLICARÁ POR SÍ MISMO: ");
        Integer numeroRecibido = entrada.nextInt();

        //Multiplico por el mismo
        numeroRecibido *= numeroRecibido;

        System.out.println(numeroRecibido);

    }


}

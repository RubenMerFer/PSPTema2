package PSPTema3.ejemploCuentas;

import java.util.ArrayList;
import java.util.List;

public class ProcesadorPagos {
    private static final int NUM_TOTAL_GASTOS = 100000;
    private static final int NUM_CLIENTES = 10;

    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria();
        List<Cliente> clientes = new ArrayList<>();

        for (int numCliente=1; numCliente <= NUM_CLIENTES; numCliente++){
            /*Creamos un cliente nuevo, dandole el numero, la cantidad de
            gastos que tiene que hacer (NUM_TOTAL/NUM_CLIENTES) y la referencia
            a la cuenta bancaria*/
            Cliente nuevoCliente= new Cliente(NUM_TOTAL_GASTOS / NUM_CLIENTES, 0 , cuenta);
            nuevoCliente.setName(String.valueOf(numCliente));
            clientes.add(nuevoCliente);
        }// Fin for

        //Iteramos toda la lista lanzando todos los hilos
        for (Cliente cliente : clientes){
            cliente.start();
        }//Fin for

        //Esperamos su terminación
        for (Cliente cliente : clientes){
            try{
                cliente.join();
            }catch (Exception e){
                System.out.println("ERROR EXCEPCIÓN: " + e);
            }
        }//Fin for
        System.out.println("TERMINADO. LA CUENTA BANCARIA TIENE " + cuenta.getGastos() + " GASTOS");
    }
}

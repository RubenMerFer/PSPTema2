package PSPTema3.ejemploCuentas;

public class CuentaBancaria {

    private int gastos = 0;
    private final Object lock = new Object();

    public int getGastos(){
        return gastos;
    }

    public int incrementarGasto(){
        synchronized (lock){
            gastos++;
        }

        return gastos;
    }

}

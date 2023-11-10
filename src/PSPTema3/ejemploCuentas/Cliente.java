package PSPTema3.ejemploCuentas;

public class Cliente extends Thread{
    private int miParte= 0;
    private int gastosRealizados= 0;
    private CuentaBancaria cuenta;

    @Override
    public void run() {
        for (int numGasto= 0; numGasto<miParte; numGasto++){
            cuenta.incrementarGasto();
            gastosRealizados++;
        }
        System.out.println(String.format("HILO %s, EL TOTAL DE GASTOS REALIZADOS ES: %d", this.getName(), this.gastosRealizados));
    }// Fin run

    public Cliente(int miParte, int gastosRealizados, CuentaBancaria cuenta){
        super();
        this.miParte= miParte;
        this.gastosRealizados= gastosRealizados;
        this.cuenta= cuenta;
    }
}

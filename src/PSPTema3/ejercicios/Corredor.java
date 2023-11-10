package PSPTema3.ejercicios;

public class Corredor extends Thread{

    private  final String nombre;
    private int tiempoTotal;



    public Corredor(String nombre){
        this.nombre = nombre;
        this.tiempoTotal=0;
    }

    public int getTiempoTotal() {
        return tiempoTotal;
    }
    public String getNombre(){return nombre;}

    //Método run
    @Override
    public void run() {
        for (int i=0; i<4; i++){
            int numero = 3000 + + (int) ((Math.random()*1000));

            try {
                Thread.sleep(numero);

            } catch (InterruptedException e) {
                System.out.println("ERROR: " + e);
            }
            System.out.println("TERMINÓ " + nombre + " LA VUELTA " + (i+1) + " EN " + numero + " MILISEGUNDOS");
            tiempoTotal += numero;

        }//Fin for
        System.out.println("");
        System.out.println("******************");
        System.out.println("NOMBRE: " + nombre + "; TIEMPO TOTAL: " + tiempoTotal);
        System.out.println("******************");
        System.out.println("");
    }// Fin run
}

package PSPTema3.ejemploBuzonCartero;

import java.util.concurrent.ThreadLocalRandom;

public class DuenioCasa implements Runnable{

    //Variables
    private Buzon buzon;
    private String tabuladores= "\t\t\t\t";

    //Constructor
    public DuenioCasa(Buzon gestor) {
        super();
        this.buzon = gestor;
    }

    //Método run
    @Override
    public void run() {
        String receivedMessage="";
        do {
            mensajeReceiver("INTENTO COGER UNA CARTA");
            receivedMessage= buzon.recogerCorreo();

            mensajeReceiver("¡CARTA RECIBIDA! ES: " + receivedMessage);
            if(receivedMessage.equalsIgnoreCase("END")){
                mensajeReceiver("TOCA ELIMINAR...");
            }

            try{
                Thread.sleep(ThreadLocalRandom.current().nextInt(3000,8000));
            }catch (Exception e){
                Thread.currentThread().interrupt();
                System.out.println("ERROR EXCEPCIÓN: " + e);
            }
        }while (!receivedMessage.equalsIgnoreCase("END"));

        mensajeReceiver("- NO TENGO MÁS CARTAS QUE RECIBIR -");
    }//Fin run

    private void mensajeReceiver(String mensaje){
        System.out.println(System.currentTimeMillis() + "|" + tabuladores + "DUEÑO CASA: " + mensaje);
    }
}

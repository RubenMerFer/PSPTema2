package PSPTema3.ejemploBuzonCartero;

import java.util.concurrent.ThreadLocalRandom;

public class Cartero implements Runnable{

    //Variables
    private Buzon buzon;

    //Constructor
    public Cartero(Buzon data) {
        super();
        this.buzon = data;
    }//Fin constructor

    //Método run
    @Override
    public void run() {
        String cartas[]= {
                "QUERIDO AMIGO, TE ECHO DE MENOS",
                "HACIENDA. TIENE QUE PAGAR",
                "PUBLICIDAD ELECTORAL",
                "FACTURA DE LA LUZ",
                "END"
        };

        for (String carta : cartas){
            mensajeSender("QUIERO ENVIAR CARTA " + carta);

            buzon.ponerCarta(carta);

            try{
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2000));
            }catch (Exception e){
                Thread.currentThread().interrupt();
                System.out.println("ERROR EXCEPCIÓN: " + e);
            }
        }//Fin for

        mensajeSender("NO TENGO MÁS CARTAS PARA ENVIAR");
    }//Fin run

    private void mensajeSender(String mensaje){
        System.out.println(System.currentTimeMillis() + "| CARTERO: " + mensaje);
    }
}

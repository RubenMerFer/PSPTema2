package PSPTema3.ejemploBuzonCartero;

public class Buzon {
    private String contenidoBuzon;

    private boolean buzonVacio= true;

    public synchronized void ponerCarta(String cartaAPoner){
        while (!buzonVacio){
            try{
                mensajeBuzon("NO HAN COGIDO LA CARTA ANTERIOR, ESPERAMOS... BUZÓN VACÍO: " + buzonVacio);
                wait(1000);
            }catch (Exception e){
                Thread.currentThread().interrupt();
                System.out.println("ERROR EXCEPCIÓN: " + e);
            }
        }// Fin while
        this.contenidoBuzon= cartaAPoner;
        buzonVacio= false;
        mensajeBuzon("(SE DEJA EN LA PUERTA LA CARTA " + cartaAPoner + ")");
        notifyAll();
    }// Fin sincronización

    public synchronized String recogerCorreo(){
        while(buzonVacio){
            try{
                mensajeBuzon("NO HAY CARTAS, ESPERAMOS... BUZÓN VACÍO: " + buzonVacio);
                wait();
            }catch (Exception e){
                Thread.currentThread().interrupt();
                System.out.println("ERROR EXCEPCIÓN: " + e);
            }
        }//Fin while
        buzonVacio= true;

        notifyAll();
        return contenidoBuzon;
    }//Fin sincronización
    private void mensajeBuzon(String mensaje){
        System.out.println(System.currentTimeMillis() + "| BUZÓN: " + mensaje);
    }
}

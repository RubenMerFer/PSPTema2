package PSPTema3.interrupciones;

public class Hijo extends Thread{

    @Override
    public void run() {
        System.out.println("\t SOY EL HIJO. ME DUERMO...MI ESTADO ES AHORA MISMO: " + this.getState());

        //Me duermo y capturo la excepción cuando me interrumpen de mi sueño
        try{
            Thread.sleep(5000);
        } catch (Exception e){
            System.out.println("\t ME HAN DESPERTADO, MI ESTADO ES " + this.getState());
        }
        //Me despido
        System.out.println("\t ME DESPIDO, PADRE...");
    }// Fin run
}

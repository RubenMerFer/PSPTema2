package ejemplos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PingGoogleWithProcessBuilder {
    public static void main(String[] args) {
        String host = "google.com";

        ProcessBuilder processBuilder = new ProcessBuilder("ping", host);
        processBuilder.redirectErrorStream(true); // Redirigir la salida de error al flujo de entrada

        try {
            Process process = processBuilder.start();
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Ping exitoso: El host está disponible.");
            } else {
                System.out.println("Ping fallido: El host no está disponible.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package escribiendo;

import java.io.FileWriter;
import java.io.IOException;

public class EscribirFichero {
    public static void main (String[] args) throws IOException {

        Escribir_Fichero escribiendo= new Escribir_Fichero();

        escribiendo.escribir();


    }
}
class Escribir_Fichero{
    public void escribir() throws IOException {
        String frase="Prueba de escritura";

        FileWriter escritura= new FileWriter("C:/Users/vicente.cantero/Desktop/JAVA/ejercicio153.txt");

        //FileWriter escritura= new FileWriter("C:/Users/vicente.cantero/Desktop/JAVA/ejercicio153.txt", true);
        // sobreescribir

        for(int i=0; i<frase.length(); i++){
            escritura.write(frase.charAt(i));
        }
        escritura.close();
    }
}

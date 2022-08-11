package leyendo;

import java.io.FileReader;
import java.io.IOException;

public class AccesoFicheros {
    public static void main (String[] args){

        LeerFichero accediendo= new LeerFichero();

        accediendo.lee();


    }

}

class LeerFichero{
    public void lee(){

        try {
            FileReader entrada = new FileReader("C:/Users/vicente.cantero/Desktop/JAVA/ejercicio152.txt");

            int c= 0;
            while(c != -1){
                c=entrada.read();
                char letra=(char)c;
                System.out.print(letra);
            }
            entrada.close();
        }catch (IOException e){
            System.out.println("No se ha encontrado el archivo");
        }

    }
}


package com.bosonit.Log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileWriter;
import java.io.IOException;

@SpringBootApplication
public class LogApplication implements CommandLineRunner {


	private static Logger LOG= LoggerFactory.getLogger(com.bosonit.Log.LogApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LogApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Hola gente");
		LOG.info("Hola gente");
		LOG.warn("Advertencia");

	}


	public class EscribirFichero {
		public void main(String[] args) throws IOException {

			System.out.println("Hola gente");
			LOG.info("Hola gente");
			LOG.warn("Advertencia");

			Escribir_Fichero escribiendo = new Escribir_Fichero();

			escribiendo.escribir();


		}
	}

	class Escribir_Fichero {
		public void escribir() throws IOException {
		String frase= "Prueba escritura";

			FileWriter escritura = new FileWriter("C:/Users/vicente.cantero/Desktop/SPRING/Log/Log.txt", true);

			//FileWriter escritura= new FileWriter("C:/Users/vicente.cantero/Desktop/JAVA/ejercicio153.txt", true);
			// sobreescribir

			for (int i = 0; i < frase.length(); i++) {
				escritura.write(frase.charAt(i));
			}
			escritura.close();
		}
	}
}





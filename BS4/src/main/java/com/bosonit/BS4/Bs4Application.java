package com.bosonit.BS4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import javax.annotation.PostConstruct;

@SpringBootApplication
@ConfigurationPropertiesScan
public class Bs4Application {

	@Autowired
	private Valor valor;

	public static void main(String[] args) {
		SpringApplication.run(Bs4Application.class, args);
	}

	@PostConstruct
	private void postInit() {
		System.out.println("Propiedades de valor info...");
		System.out.println(valor);
	}
}

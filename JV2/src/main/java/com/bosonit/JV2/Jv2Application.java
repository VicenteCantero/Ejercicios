package com.bosonit.JV2;

import com.bosonit.JV2.Persona.Domain.Persona;
import com.bosonit.JV2.Persona.infrastructure.repository.PersonaRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class Jv2Application {


	public static void main(String[] args) {
		SpringApplication.run(Jv2Application.class, args);

/*
		Persona persona =new Persona(
		1,
		"String usuario",
		 "password",
		 "Lolo",
		 "surname",
		 "company_email",
		 "personal_email",
		 "city",
		 true,
		 null,
		 "imagen_url",
		 null
		);


		System.out.println(persona.getName());
		System.out.println(persona);*/
	}

}
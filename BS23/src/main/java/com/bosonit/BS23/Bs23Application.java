package com.bosonit.BS23;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Bs23Application {

	public static void main(String[] args) {
		SpringApplication.run(Bs23Application.class, args);
	}


	@Bean
	@Qualifier(value = "bean1")
	PersonaService damebean1(){

		PersonaService personaService = new PersonaServiceImpl();
		personaService.setNombre("bean1");
		return personaService;
	}

	@Bean
	@Qualifier(value = "bean2")
	PersonaService damebean2(){

		PersonaService personaService = new PersonaServiceImpl();
		personaService.setNombre("bean2");
		return personaService;
	}

	@Bean
	@Qualifier(value = "bean3")
	PersonaService damebean3(){

		PersonaService personaService = new PersonaServiceImpl();
		personaService.setNombre("bean3");
		return personaService;
	}

}

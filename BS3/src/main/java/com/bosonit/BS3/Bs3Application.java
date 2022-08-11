package com.bosonit.BS3;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Bs3Application {

	public static void main(String[] args) {
		SpringApplication.run(Bs3Application.class, args);
	}

	@Bean
	@Qualifier(value = "bean1")
	ObjetoBean damebean1(){

		ObjetoBean objetoBean = new ObjetoBean();
		objetoBean.setNombre("bean1");
		return objetoBean;
	}
}

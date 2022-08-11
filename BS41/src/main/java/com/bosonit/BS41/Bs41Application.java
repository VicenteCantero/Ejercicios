package com.bosonit.BS41;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

@SpringBootApplication
@Configuration
public class Bs41Application {


	public static void main(String[] args) {
		SpringApplication.run(Bs41Application.class, args);
	}



}

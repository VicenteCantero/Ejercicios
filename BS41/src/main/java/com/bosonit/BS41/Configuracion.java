package com.bosonit.BS41;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;

@Configuration
@PropertySource("classpath:miconfiguracion.properties")
public class Configuracion {

    @Autowired
    Valor1 valor1;

    @Autowired
    Valor2 valor2;

    @PostConstruct
    public void ClaseI(){
        System.out.println(valor1.toString());
        System.out.println(valor2.toString());
    }
}

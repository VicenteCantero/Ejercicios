package com.bosonit;

import com.bosonit.service.IPersonaService;
import com.bosonit.service.PersonaServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private static Logger LOG= LoggerFactory.getLogger(com.bosonit.DemoApplication.class);

    private IPersonaService service;

    public static void main(String[] args) {
        SpringApplication.run(com.bosonit.DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //System.out.println("Hola gente");
        //LOG.info("Hola gente");
        //LOG.warn("Advertencia");

        service= new PersonaServiceImpl();
        service.registrar("Bosonit");

    }
}

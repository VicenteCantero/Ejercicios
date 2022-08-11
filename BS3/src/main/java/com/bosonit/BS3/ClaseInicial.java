package com.bosonit.BS3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ClaseInicial{


    @PostConstruct
    public void ClaseI(){
            System.out.println("Hola desde clase inicial");

    }
}

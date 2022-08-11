package com.bosonit.BS3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ClaseTerciaria implements CommandLineRunner {


    @Autowired
    @Qualifier(value = "bean1")
    ObjetoBean objetoBean;


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Soy la tercera clase, y me llamo " + objetoBean.getNombre());
    }
}

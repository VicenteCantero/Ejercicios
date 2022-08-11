package com.bosonit.BS41;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class controlador {

@Autowired
    Variables variable;

@Autowired
    Valor1 valor1;

@Autowired
    Valor2 valor2;

@Autowired
Perfiles perfiles;

    @GetMapping("/parametros")
    String dameParametros(){

        return "valor de url es " + variable.getUrl() + " valor de password es " +variable.getPassword() ;
    }


    @GetMapping("/miconfiguracion")
    String dameValores(){

        return "Valores de " +valor1.toString() +".\nValores de " + valor2.toString() ;
    }


    @GetMapping("/perfil")
    String damePerfil(){

        return perfiles.miFuncion();
    }
}

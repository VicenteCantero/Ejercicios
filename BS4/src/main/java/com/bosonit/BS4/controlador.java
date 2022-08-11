package com.bosonit.BS4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class controlador {

    @Autowired
    Valor valor;

    @GetMapping("/GET/valores")
    String dameValores(){

        return "valor de var1 es " + valor.getVAR1() + " valor de MyVar2 es " +valor.getMyVAR2() ;
    }

    @GetMapping("/var3")
    String valor3(){
       if(valor.getVAR3()== null){
           valor.setVAR3("var 3 no tiene valor");
        }
        return "valor de var3 es: " + valor.getVAR3() ;
    }


}

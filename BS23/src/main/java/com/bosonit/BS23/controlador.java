package com.bosonit.BS23;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controlador {

    @Autowired
    @Qualifier("bean1")
    PersonaService personaServiceBean1;

    @Autowired
    @Qualifier("bean2")
    PersonaService personaServiceBean2;

    @Autowired
    @Qualifier("bean3")
    PersonaService personaServiceBean3;


    @GetMapping("/controlador/bean/{bean}")
    PersonaService eligeBean (@PathVariable String bean){
        PersonaService eligeServicio;
        switch (bean){
            case "bean1":
                eligeServicio = personaServiceBean1;
                break;
            case "bean2":
                eligeServicio = personaServiceBean2;
                break;
            case "bean3":
                eligeServicio = personaServiceBean3;
                break;
            default:
                eligeServicio = personaServiceBean1;
        }

        return eligeServicio;
    }


}

package com.bosonit.RS1.controler;

import com.bosonit.RS1.model.Persona;
import com.bosonit.RS1.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controladorDelete {

    @Autowired
    PersonaService personaService;

    @RequestMapping(value= "/persona/{id}" , method = RequestMethod.DELETE)
    Persona personaBorradaPorID(@PathVariable int id){
        return personaService.borrarPersona(id);

    }

}

package com.bosonit.RS1.controler;

import com.bosonit.RS1.model.Persona;
import com.bosonit.RS1.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class controladorGet {

    @Autowired
    PersonaService personaService;

    @RequestMapping(value = "/persona/{id}", method = RequestMethod.GET)
    Persona damePersonasPorId(@PathVariable(value = "id") int id) {
        return personaService.damePersonasID(id-1);
    }

    @RequestMapping(value = "/persona/nombre/{nombre}", method = RequestMethod.GET)
    Persona damePersonasPorNombre(@PathVariable(value = "nombre") String nombre) {
        return personaService.damePersonasNombre(nombre);
    }


    @GetMapping("/damePersonas")
    List<Persona> damePersonas(){

        return personaService.damePersonas();

    }
}

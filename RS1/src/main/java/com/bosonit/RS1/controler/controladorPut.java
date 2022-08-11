package com.bosonit.RS1.controler;

import com.bosonit.RS1.model.Persona;
import com.bosonit.RS1.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class controladorPut {

    @Autowired
    PersonaService personaService;

    @RequestMapping(value = "/persona/{id}", method = RequestMethod.PUT)
    public Persona updatePersona(@PathVariable(value = "id") int id) {
        int i;
        for (i = 0; i < personaService.damePersonas().size(); i++) {
            if (personaService.damePersonas().get(i).getId() == id) {
                personaService.damePersonas().get(id - 1).setNombre("Vicente");
                personaService.damePersonas().get(id - 1).setEdad(37);
                personaService.damePersonas().get(id - 1).setPoblacion("Cabra");
            }

        }

        return  personaService.damePersonasID(id-1);
    }


   /* public Persona actualizaPersonaId(@RequestBody Persona p, int id) {

        return personaService.actualizaPersonaId(p, id);
    }*/

}


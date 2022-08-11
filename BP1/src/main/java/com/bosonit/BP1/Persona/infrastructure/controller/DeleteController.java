package com.bosonit.BP1.Persona.infrastructure.controller;

import com.bosonit.BP1.Errores.NotFoundException;
import com.bosonit.BP1.Persona.application.PersonaService;
import com.bosonit.BP1.Persona.infrastructure.repository.PersonaRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteController {

    @Autowired
    //PersonaRepositoryJPA personaRepositoryJPA;
    PersonaService personaService;

    @DeleteMapping("/persona/{id}")
    ResponseEntity<String> personaBorradaPorID(@PathVariable int id) throws Exception {
        try {
            //personaRepositoryJPA.deleteById(id);
            personaService.personaBorradaPorID(id);
            return new ResponseEntity<>(("Borrada persona con id: " + id),HttpStatus.OK);
        } catch (Exception e) {
            throw new NotFoundException("No existe el id");
        }
    }


}

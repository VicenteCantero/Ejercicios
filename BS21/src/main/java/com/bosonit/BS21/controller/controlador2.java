package com.bosonit.BS21.controller;

import com.bosonit.BS21.model.Persona;
import com.bosonit.BS21.services.PersonaService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controlador2 {


    @Autowired
    PersonaService personaService;

    @GetMapping("/controlador2/getPersona")
    String getControlador2(){

        return String.valueOf(Integer.parseInt(personaService.getEdad())*2);

    }
}

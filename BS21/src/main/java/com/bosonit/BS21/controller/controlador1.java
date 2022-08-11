package com.bosonit.BS21.controller;

import com.bosonit.BS21.model.Persona;
import com.bosonit.BS21.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

@RestController
public class controlador1 {


    @Autowired
    PersonaService personaService;


    @GetMapping("/nombre/{nombre}")
    public String dimeTuNombre(@PathVariable String nombre, @RequestParam(required = false, defaultValue = "54") String edad){

        personaService.setNombre(nombre);

        return "Hola " + nombre + edad;
    }


    @GetMapping("/controlador1/addPersona")
    public String dame(@RequestParam (value= "nombre") String nombre, @RequestParam (value= "poblacion") String poblacion, @RequestParam (value = "edad") String edad) {

        personaService.setNombre(nombre);
        personaService.setPoblacion(poblacion);
        personaService.setEdad(edad);

        return personaService.getNombre() + " " + personaService.getPoblacion() + " " + personaService.getEdad();

    }


/*
    @GetMapping("/controlador1/addPersona")
    public PersonaService dameCabezera(@RequestHeader Map<String, string> headers) {

        personaService.setNombre(headers.get("nombre"));
        personaService.setPoblación(headers.get("poblacion");
        personaService.setEdad(headers.get("edad");


       // Persona persona = new Persona(nombre, poblacion, edad);
        return personaService;
    }*/

}


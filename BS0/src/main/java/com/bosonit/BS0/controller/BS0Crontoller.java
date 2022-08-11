package com.bosonit.BS0.controller;

import com.bosonit.BS0.model.Persona;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class BS0Crontoller {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {

        model.addAttribute("name", name);
        return "greeting";
    }


    @GetMapping("/user/{name}")
    public String getNombre(@PathVariable String name) {

        return "Hola " + name;
    }

    @PostMapping("/useradd")
    Persona newPerson(@RequestBody ObjectNode requestObject) {
        Persona newPerson = new Persona(requestObject.get("name").asText(), requestObject.get("edad").asText(), requestObject.get("ciudad").asText());
        newPerson.añadirAño();
        return newPerson;
    }
}

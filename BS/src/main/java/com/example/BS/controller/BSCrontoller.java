package com.example.BS.controller;

import com.example.BS.model.Persona;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class BSCrontoller {

    private static final String template = "Hello, %s!";

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {

        model.addAttribute("name", name);
        return "greeting";
    }


    @GetMapping("/user/{name}")
    public String getName(@PathVariable String name) {

        return "Hola " + name;
    }

    @PostMapping("/useradd")
    Persona newPerson(@RequestBody ObjectNode requestObject) {
        Persona newPerson = new Persona(requestObject.get("name").asText(), requestObject.get("edad").asText(), requestObject.get("ciudad").asText());
        newPerson.añadirAño();
        return newPerson;
    }
}

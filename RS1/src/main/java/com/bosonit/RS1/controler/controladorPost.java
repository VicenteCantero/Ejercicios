package com.bosonit.RS1.controler;

import com.bosonit.RS1.model.Persona;
import com.bosonit.RS1.services.PersonaService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class controladorPost {

    @Autowired
    PersonaService personaService;

    @PostMapping("/persona")

    Persona nuevaPersona(@RequestBody ObjectNode requestObject) {
        Persona nuevaPersona = new Persona(requestObject.get("id").asInt(),requestObject.get("nombre").asText(),requestObject.get("edad").asInt(),requestObject.get("poblacion").asText());

        personaService.añadirPersona(nuevaPersona);

        return nuevaPersona;
    }




      /*

  @RequestMapping(value = "/persona", method = RequestMethod.POST)
    public PersonaService nuevaPersona(@RequestBody Persona p) {
        personaService.añadirPersona(p);
        return nuevaPersona(p);
    }


      public PersonaService dameCabezera(@RequestHeader Map<String, String> headers) {

        personaService.setNombre(headers.get("nombre"));
        personaService.setPoblación(headers.get("poblacion"));
        personaService.setEdad(Integer.parseInt(headers.get("edad")));


        // Persona persona = new Persona(nombre, poblacion, edad);
        return personaService;

        */


}

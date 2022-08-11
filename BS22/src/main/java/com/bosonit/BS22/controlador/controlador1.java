package com.bosonit.BS22.controlador;

import com.bosonit.BS22.model.Ciudad;
import com.bosonit.BS22.services.CiudadService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class controlador1 {

    @Autowired
    CiudadService ciudadService;

/* bien
    @PostMapping("/controlador1/addCiudad")
    public String añadeCiudad (@RequestBody ObjectNode requestObject){



        ciudadService.setNombre(requestObject.get("nombre").asText());
        ciudadService.setNumeroHabitantes(Integer.parseInt(requestObject.get("numeroHabitantes").asText()));


        listaCiudades.add(ciudadService);

        return ciudadService.getNombre() + " " +ciudadService.getNumeroHabitantes();
    }

    /*
 */

    @PostMapping("/controlador1/addCiudad")
    Ciudad nuevaCiudad(@RequestBody ObjectNode requestObject) {
        Ciudad nuevaCiudad = new Ciudad(requestObject.get("nombre").asText(), requestObject.get("numeroHabitantes").asInt());

        ciudadService.añadirCiudad(nuevaCiudad);

        return nuevaCiudad;
    }
}


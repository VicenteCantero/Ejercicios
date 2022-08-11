package com.bosonit.BS22.controlador;

import com.bosonit.BS22.model.Ciudad;
import com.bosonit.BS22.services.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class controlador2 {

    @Autowired
    CiudadService ciudadService;


    @GetMapping("/controlador2/getCiudad")
    List<Ciudad> dameCiudades(){

        return ciudadService.getCiudades();

    }
}

package com.bosonit.BP1.Persona.infrastructure.controller;

import com.bosonit.BP1.Errores.UnprocesableException;
import com.bosonit.BP1.Persona.application.PersonaService;
import com.bosonit.BP1.Persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.BP1.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = RequestMethod.POST)
@RequestMapping("addperson")
public class PostController {


    @Autowired
    PersonaService personaService;


    @PostMapping
    public PersonaOutputDTO addPersona(@RequestBody PersonaInputDTO persInputDto) throws Exception {
        try{
            return personaService.añadir(persInputDto);
        }catch (Exception e){
            throw new UnprocesableException ("Revisa los campos");
        }

    }




}

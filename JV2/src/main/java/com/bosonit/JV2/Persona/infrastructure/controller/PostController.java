package com.bosonit.JV2.Persona.infrastructure.controller;

import com.bosonit.JV2.Persona.application.PersonaService;
import com.bosonit.JV2.Persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.JV2.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods = RequestMethod.POST)
@RequestMapping("addperson")
public class PostController {


    @Autowired
    PersonaService personaService;


    @PostMapping
    public PersonaOutputDTO addPersona(@RequestBody PersonaInputDTO persInputDto) throws Exception {
        try{
            return personaService.addPersona(persInputDto);
        }catch (Exception e){
            throw new RuntimeException ("Revisa los campos");
        }

    }




}

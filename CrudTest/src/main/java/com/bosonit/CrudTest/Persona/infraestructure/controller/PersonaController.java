package com.bosonit.CrudTest.Persona.infraestructure.controller;


import com.bosonit.CrudTest.Persona.application.PersonaService;
import com.bosonit.CrudTest.Persona.infraestructure.dto.PersonaInputDto;
import com.bosonit.CrudTest.Persona.infraestructure.dto.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona/api")
@CrossOrigin("*")
public class PersonaController {

    @Autowired
    PersonaService personaService;



    @GetMapping(value = "/publico/all")
    public List<PersonaOutputDto> getAll(){
        return personaService.getall();
    }

    @GetMapping(value= "/publico/find/{id}")
    public PersonaOutputDto find (@PathVariable int id){
        return personaService.get(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value= "/admin/save")
    public PersonaOutputDto save (@RequestBody PersonaInputDto personaInputDto){
        return personaService.save(personaInputDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value= "/admin/delete/{id}")
    public ResponseEntity<PersonaOutputDto> delete (@PathVariable int id){
        PersonaOutputDto personaEncontrada= personaService.get(id);
        if (personaEncontrada != null){
            personaService.delete(id);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(personaEncontrada, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/admin/put/{id}", method = RequestMethod.PUT)
    ResponseEntity<PersonaOutputDto> actualizaPersona(@PathVariable("id") int id, @RequestBody PersonaInputDto personaInputDto) throws Exception {
        try {
            return new ResponseEntity<PersonaOutputDto>((PersonaOutputDto) personaService.put(id, personaInputDto), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException("No existe el id");
        }
    }
}


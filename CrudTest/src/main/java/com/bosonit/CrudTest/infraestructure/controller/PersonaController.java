package com.bosonit.CrudTest.infraestructure.controller;


import com.bosonit.CrudTest.application.PersonaService;
import com.bosonit.CrudTest.domain.Persona;
import com.bosonit.CrudTest.infraestructure.dto.PersonaInputDto;
import com.bosonit.CrudTest.infraestructure.dto.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona/api")
@CrossOrigin("*")
public class PersonaController {

    @Autowired
    PersonaService personaService;



    @GetMapping(value = "/all")
    public List<PersonaOutputDto> getAll(){
        return personaService.getall();
    }

    @GetMapping(value= "/find/{id}")
    public PersonaOutputDto find (@PathVariable int id){
        return personaService.get(id);
    }


    @PostMapping(value= "/save")
    public PersonaOutputDto save (@RequestBody PersonaInputDto personaInputDto){
        return personaService.save(personaInputDto);
    }


    @DeleteMapping(value= "/delete/{id}")
    public ResponseEntity<PersonaOutputDto> delete (@PathVariable int id){
        PersonaOutputDto personaEncontrada= personaService.get(id);
        if (personaEncontrada != null){
            personaService.delete(id);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(personaEncontrada, HttpStatus.OK);
    }


    @RequestMapping(value = "/put/{id}", method = RequestMethod.PUT)
    ResponseEntity<PersonaOutputDto> actualizaPersona(@PathVariable("id") int id, @RequestBody PersonaInputDto personaInputDto) throws Exception {
        try {
            return new ResponseEntity<PersonaOutputDto>((PersonaOutputDto) personaService.put(id, personaInputDto), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException("No existe el id");
        }
    }
}


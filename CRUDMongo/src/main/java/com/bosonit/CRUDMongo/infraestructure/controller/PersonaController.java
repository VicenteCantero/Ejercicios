package com.bosonit.CRUDMongo.infraestructure.controller;

import com.bosonit.CRUDMongo.application.PersonaService;
import com.bosonit.CRUDMongo.domain.Persona;
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
    public List<Persona> getAll(){
        return personaService.getall();
    }

    @GetMapping(value= "/find/{id}")
    public Persona find (@PathVariable int id){
        return personaService.get(id);
    }

    @PostMapping(value= "/save")
    public ResponseEntity<Persona> save (@RequestBody Persona persona){
        Persona obj= personaService.save(persona);
        return new ResponseEntity<Persona>(obj, HttpStatus.OK);
    }

    @DeleteMapping(value= "/delete/{id}")
    public ResponseEntity<Persona> delete (@PathVariable int id){
        Persona personaEncontrada= personaService.get(id);
        if (personaEncontrada != null){
            personaService.delete(id);
        }else{
            return new ResponseEntity<Persona>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Persona>(personaEncontrada, HttpStatus.OK);
    }


    @RequestMapping(value = "/put/{id}", method = RequestMethod.PUT)
    ResponseEntity<Persona> actualizaPersona(@PathVariable("id") int id, @RequestBody Persona persona) throws Exception {
        try {
            return new ResponseEntity<>(personaService.put(id, persona), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException("No existe el id");
        }
    }
}

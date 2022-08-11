package com.example.demoCRUD2.Persona.Infrastructure.Controller.dto;

import com.example.demoCRUD2.Persona.Aplication.PersonaService;
import com.example.demoCRUD2.Persona.Infrastructure.Dto.PersonaInputDto;
import com.example.demoCRUD2.Persona.Infrastructure.Dto.PersonaOutputDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import org.springframework.util.LinkedMultiValueMap;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    PersonaService service;


    //Mostrar todos los registros
    @GetMapping
    List<PersonaOutputDto> getAllPersonas() throws Exception{
        return service.findAll();
    }

    //Buscar por id
    @GetMapping("/{id}")
    ResponseEntity<PersonaOutputDto> getPersonaById(@PathVariable int id) {
        try {

            Map<String,List<String>>  map= Map.of("id",Arrays.asList("1"));

            HttpHeaders httpHeaders= new HttpHeaders(new LinkedMultiValueMap<>(map));
            return ResponseEntity.ok().headers(httpHeaders).
                    body(service.findById(id));
        } catch (Exception k )
        {
            return ResponseEntity.notFound().build();
        }
    }
//    @GetMapping("/user/{user}")
//    PersonaOutputDto getPersonaByUser(@PathVariable String user) throws Exception {
//        return service.findByUser(user);
//    }

    @PostMapping
    public PersonaOutputDto addPersona(@RequestBody PersonaInputDto persInputDto) throws Exception {
        return service.save(persInputDto);

    }




}

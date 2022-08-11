package com.bosonit.rest;

import com.bosonit.model.Persona;
import com.bosonit.repo.IPersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class RestDemoController {

    @Autowired
    private IPersonaRepo repo;

    @GetMapping
    public List<Persona> listar(){
        return repo.findAll();
    }

    @PostMapping
    public void insertar(Persona per){
        repo.save(per);
    }
}

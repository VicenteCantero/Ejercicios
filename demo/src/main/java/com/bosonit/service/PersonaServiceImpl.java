package com.bosonit.service;

import com.bosonit.repository.IPersonaRepo;
import com.bosonit.repository.PersonaRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements IPersonaService{

    @Autowired
    private IPersonaRepo repo;

    public void registrar(String nombre) {

        repo= new PersonaRepoImpl();
        repo.registrar(nombre);
    }
}

package com.example.demoCRUD2.Persona.Aplication;

import com.example.demoCRUD2.Persona.Infrastructure.Dto.PersonaInputDto;
import com.example.demoCRUD2.Persona.Infrastructure.Dto.PersonaOutputDto;

import java.util.List;

public interface PersonaService {

    List<PersonaOutputDto> findAll();
    PersonaOutputDto findById(int id) throws Exception;
    PersonaOutputDto save(PersonaInputDto pers) throws Exception;
    List<PersonaOutputDto> findByUser(String user) throws Exception;
}

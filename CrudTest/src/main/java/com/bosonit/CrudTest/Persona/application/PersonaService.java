package com.bosonit.CrudTest.Persona.application;

import com.bosonit.CrudTest.Persona.infraestructure.dto.PersonaInputDto;
import com.bosonit.CrudTest.Persona.infraestructure.dto.PersonaOutputDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonaService {


    PersonaOutputDto save(PersonaInputDto personaInputDto);

    List<PersonaOutputDto> getall();

    PersonaOutputDto get(int id);

    PersonaOutputDto put(int id, PersonaInputDto personaInputDto);

    ResponseEntity<String> delete(int id);
}

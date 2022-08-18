package com.bosonit.CrudTest.application;

import com.bosonit.CrudTest.domain.Persona;
import com.bosonit.CrudTest.infraestructure.dto.PersonaInputDto;
import com.bosonit.CrudTest.infraestructure.dto.PersonaOutputDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonaService {


    PersonaOutputDto save(PersonaInputDto personaInputDto);

    List<PersonaOutputDto> getall();

    PersonaOutputDto get(int id);

    PersonaOutputDto put(int id, PersonaInputDto personaInputDto);

    ResponseEntity<String> delete(int id);
}

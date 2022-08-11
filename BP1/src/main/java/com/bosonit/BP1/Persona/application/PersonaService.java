package com.bosonit.BP1.Persona.application;

import com.bosonit.BP1.Persona.Domain.Persona;
import com.bosonit.BP1.Persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.BP1.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface PersonaService {
    //crear
    PersonaOutputDTO añadir(PersonaInputDTO personaInputDTO) throws Exception;

    //lista de todos
    List<PersonaOutputDTO> findAll(String outputType);

    //Persona por Id
    ResponseEntity<PersonaOutputDTO> findById(int id, String outputType) throws Exception;

    //Lista de personas por nombre usuario
    List<Object> findByUsuario(String usuario, String outputType) throws Exception;

    PersonaOutputDTO actualizaPersona(int id, PersonaInputDTO personaInputDTO);


    ResponseEntity<String> personaBorradaPorID(@PathVariable int id ) throws Exception;
}

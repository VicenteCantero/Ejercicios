package com.bosonit.JV2.Persona.application;

import com.bosonit.JV2.Persona.Domain.Persona;
import com.bosonit.JV2.Persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.JV2.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;

public interface PersonaService {
    //crear
    PersonaOutputDTO addPersona(PersonaInputDTO personaInputDTO) throws Exception;

    //lista de todos
    List<PersonaOutputDTO> findAll(String outputType);

    //Persona por Id
    ResponseEntity<PersonaOutputDTO> findById(int id) throws Exception;

    //Lista de personas por nombre usuario
    List<Object> findByUsuario(String usuario) throws Exception;

    PersonaOutputDTO actualizaPersona(int id, PersonaInputDTO personaInputDTO);


    ResponseEntity<String> personaBorradaPorID(@PathVariable int id ) throws Exception;


    //------ DBA1
    List<Persona> getData(HashMap<String, Object> conditions);
}

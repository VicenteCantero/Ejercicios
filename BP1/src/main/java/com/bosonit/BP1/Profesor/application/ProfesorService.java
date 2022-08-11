package com.bosonit.BP1.Profesor.application;

import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentInputDto;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoFull;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoSimple;
import com.bosonit.BP1.Persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.BP1.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.bosonit.BP1.Profesor.infrastructure.controller.dto.ProfesorInputDto;
import com.bosonit.BP1.Profesor.infrastructure.controller.dto.ProfesorOutputDto;
import com.bosonit.BP1.Profesor.infrastructure.controller.dto.ProfesorOutputDtoFull;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfesorService {

    ProfesorOutputDtoFull crearProfesor(ProfesorInputDto profesorInputDto) throws Exception;

    ProfesorOutputDto dameProfesorId(int id, String outputType) throws Exception;

    List<ProfesorOutputDtoFull> dameProfesores();

    ProfesorOutputDtoFull actualizaProfesor(int id, ProfesorInputDto profesorInputDto);

    ResponseEntity<String> deleteById(int id) throws Exception;
}

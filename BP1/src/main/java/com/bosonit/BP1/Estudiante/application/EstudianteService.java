package com.bosonit.BP1.Estudiante.application;

import com.bosonit.BP1.Asignaturas.infrastructure.controller.dto.AsignaturaOutputDto;
import com.bosonit.BP1.Errores.NotFoundException;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentInputDto;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoFull;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoSimple;
import com.bosonit.BP1.Persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.BP1.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public interface EstudianteService {

    StudentOutputDtoFull crearEstudiante(StudentInputDto studentInputDto) throws Exception;

    StudentOutputDtoSimple getStudentByID(int id, String ouputType) throws Exception;

    List<StudentOutputDtoFull> getAllStudent();

    StudentOutputDtoFull actualizaEstudiante(int id, StudentInputDto studentInputDto);


    List<AsignaturaOutputDto> asignaturasEstudiante(int idEstudiante);

    ResponseEntity<String> deleteById (int id) throws Exception;
}

package com.bosonit.BP1.Estudiante.infrastructure.controller;

import com.bosonit.BP1.Errores.NotFoundException;
import com.bosonit.BP1.Estudiante.application.EstudianteService;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentInputDto;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoFull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PutControllerStudent {

    @Autowired
    EstudianteService estudianteService;


    @RequestMapping(value = "/estudiante/{id}", method = RequestMethod.PUT)
    ResponseEntity<StudentOutputDtoFull> actualizaEstudiante(@PathVariable("id") int id, @RequestBody StudentInputDto studentInputDto) throws Exception {
        try {
            return new ResponseEntity<>(estudianteService.actualizaEstudiante(id, studentInputDto), HttpStatus.OK);
        } catch (Exception e) {
            throw new NotFoundException("No existe el id");
        }
    }
}

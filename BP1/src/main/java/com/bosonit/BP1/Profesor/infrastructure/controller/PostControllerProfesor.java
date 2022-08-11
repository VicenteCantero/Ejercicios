package com.bosonit.BP1.Profesor.infrastructure.controller;

import com.bosonit.BP1.Estudiante.application.EstudianteService;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentInputDto;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoFull;
import com.bosonit.BP1.Profesor.application.ProfesorService;
import com.bosonit.BP1.Profesor.infrastructure.controller.dto.ProfesorInputDto;
import com.bosonit.BP1.Profesor.infrastructure.controller.dto.ProfesorOutputDtoFull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostControllerProfesor {

    @Autowired
    ProfesorService profesorService;

    @PostMapping("/profesor")
    public ProfesorOutputDtoFull postProfesor(@RequestBody ProfesorInputDto profesorInputDto) throws Exception{

        return profesorService.crearProfesor(profesorInputDto);


    }
}

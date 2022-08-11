package com.bosonit.BP1.Estudiante.infrastructure.controller;

import com.bosonit.BP1.Errores.UnprocesableException;
import com.bosonit.BP1.Estudiante.application.EstudianteService;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentInputDto;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoFull;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoSimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostControllerStudent {

    @Autowired
    EstudianteService estudianteService;

    @PostMapping("/estudiante")
        public StudentOutputDtoFull postStudent(@RequestBody StudentInputDto studentInputDto) throws Exception{

            return estudianteService.crearEstudiante(studentInputDto);


    }
}

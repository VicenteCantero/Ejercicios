package com.bosonit.BP1.Estudiante.infrastructure.controller;

import com.bosonit.BP1.Estudiante.application.EstudianteService;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoFull;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoSimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("estudiante/")
public class GetControllerStudent {


    @Autowired
    EstudianteService estudianteService;

    @GetMapping("{id}")
    public StudentOutputDtoSimple dameEstudiantePorID(@PathVariable int id, @RequestParam(defaultValue = "simple", required = false) String outputType) throws Exception {
        return estudianteService.getStudentByID(id, outputType);

    }

    @GetMapping("todos")
    public List<StudentOutputDtoFull> dameEstudiantes() {
        return estudianteService.getAllStudent();
    }

}

package com.bosonit.BP1.Asignaturas.infrastructure.controller;

import com.bosonit.BP1.Asignaturas.application.AsignaturasService;
import com.bosonit.BP1.Asignaturas.infrastructure.controller.dto.AsignaturaOutputDto;
import com.bosonit.BP1.Asignaturas.infrastructure.controller.dto.AsignaturaInputDto;
import com.bosonit.BP1.Asignaturas.infrastructure.controller.dto.AsignaturasIDInputDto;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoSimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostAsignaturas {


    @Autowired
    AsignaturasService asignaturasService;

    @PostMapping("/asignatura")
    public AsignaturaOutputDto postAsignatura(@RequestBody AsignaturaInputDto asignaturaInputDto) throws Exception{

        return asignaturasService.crearAsignatura(asignaturaInputDto);

    }

    @PostMapping("/asignatura/AaE/{id}")
    public StudentOutputDtoSimple añadirAsignaturasRutaEstudiante(@RequestBody AsignaturasIDInputDto asignaturasIDInputDto, @PathVariable String id){
        return asignaturasService.añadirAsignaturasEstudiante(asignaturasIDInputDto, id);
    }

}

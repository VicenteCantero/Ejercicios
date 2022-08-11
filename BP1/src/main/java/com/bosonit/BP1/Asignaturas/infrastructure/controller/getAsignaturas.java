package com.bosonit.BP1.Asignaturas.infrastructure.controller;

import com.bosonit.BP1.Asignaturas.application.AsignaturasService;
import com.bosonit.BP1.Asignaturas.infrastructure.controller.dto.AsignaturaOutputDto;
import com.bosonit.BP1.Asignaturas.infrastructure.controller.dto.AsignaturaOutputDtoFull;
import com.bosonit.BP1.Estudiante.application.EstudianteService;
import com.bosonit.BP1.Estudiante.infrastructure.repository.StudentRepositoryJpa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("asignatura/")
public class getAsignaturas {

    @Autowired
    AsignaturasService asignaturasService;

    @Autowired
    EstudianteService estudianteService;

    @GetMapping("{id}")
    public AsignaturaOutputDto dameAsignaturaId(@PathVariable int id) throws Exception {
        return asignaturasService.dameAsignaturaID(id);

    }

    @GetMapping("todos")
    public List<AsignaturaOutputDtoFull> dameAsignaturas() {
        return asignaturasService.dameAsignaturas();
    }

 //solucion oscar
 @JsonIgnore
    @GetMapping("asignatura/{id}")
    public List<AsignaturaOutputDto> dameAsignaturasRutaEstudiante(@PathVariable int id){
        return asignaturasService.dameAsignaturasEstudiante(id);
    }


    @JsonIgnore
    @GetMapping("estudiante/{idEstudiante}")
    public List<AsignaturaOutputDto> buscarAsignaturasEstudiante(@PathVariable int idEstudiante) {
        return estudianteService.asignaturasEstudiante(idEstudiante);
    }

}

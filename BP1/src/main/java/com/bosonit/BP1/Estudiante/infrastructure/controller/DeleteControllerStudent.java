package com.bosonit.BP1.Estudiante.infrastructure.controller;

import com.bosonit.BP1.Errores.NotFoundException;
import com.bosonit.BP1.Estudiante.application.EstudianteService;
import com.bosonit.BP1.Estudiante.infrastructure.repository.StudentRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteControllerStudent {

    @Autowired
    //StudentRepositoryJpa studentRepositoryJpa;
    EstudianteService estudianteService;

    @DeleteMapping("estudiante/{id}")
    ResponseEntity<String> estudianteBorradoPorId(@PathVariable int id)throws Exception{
        try{
            estudianteService.deleteById(id);
            return new ResponseEntity<>(("Borrado alumno con id: " + id), HttpStatus.OK);
        } catch (Exception e) {
            throw new NotFoundException("No existe el id");
        }
    }


}

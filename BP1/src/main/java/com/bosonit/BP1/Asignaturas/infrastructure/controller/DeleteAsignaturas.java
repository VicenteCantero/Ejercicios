package com.bosonit.BP1.Asignaturas.infrastructure.controller;

import com.bosonit.BP1.Asignaturas.infrastructure.repository.AsignaturasRepositoryJpa;
import com.bosonit.BP1.Errores.NotFoundException;
import com.bosonit.BP1.Estudiante.infrastructure.repository.StudentRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteAsignaturas {

    @Autowired
    AsignaturasRepositoryJpa asignaturasRepositoryJpa;

    @DeleteMapping("asignatura/{id}")
    ResponseEntity<String> asignaturaBorradaPorId(@PathVariable int id)throws Exception{
        try{
            asignaturasRepositoryJpa.deleteById(id);
            return new ResponseEntity<>(("Borrada asignatura con id: " + id), HttpStatus.OK);
        } catch (Exception e) {
            throw new NotFoundException("No existe el id");
        }
    }
}

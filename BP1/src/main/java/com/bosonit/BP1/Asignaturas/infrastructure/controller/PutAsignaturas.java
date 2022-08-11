package com.bosonit.BP1.Asignaturas.infrastructure.controller;

import com.bosonit.BP1.Asignaturas.application.AsignaturasService;
import com.bosonit.BP1.Asignaturas.infrastructure.controller.dto.AsignaturaInputDto;
import com.bosonit.BP1.Asignaturas.infrastructure.controller.dto.AsignaturaOutputDto;
import com.bosonit.BP1.Asignaturas.infrastructure.controller.dto.AsignaturaOutputDtoFull;
import com.bosonit.BP1.Errores.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PutAsignaturas {


    @Autowired
    AsignaturasService asignaturasService;


    @RequestMapping(value = "/asignatura/{id}", method = RequestMethod.PUT)
    ResponseEntity<AsignaturaOutputDto> actualizaAsignatura(@PathVariable("id") int id, @RequestBody AsignaturaInputDto asignaturaInputDto) throws Exception {
        try {
            return new ResponseEntity<>(asignaturasService.actualizaAsignatura(id, asignaturaInputDto), HttpStatus.OK);
        } catch (Exception e) {
            throw new NotFoundException("No existe el id");
        }
    }
}

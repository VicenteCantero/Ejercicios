package com.bosonit.BP1.Profesor.infrastructure.controller;

import com.bosonit.BP1.Errores.NotFoundException;
import com.bosonit.BP1.Profesor.application.ProfesorService;
import com.bosonit.BP1.Profesor.infrastructure.controller.dto.ProfesorInputDto;
import com.bosonit.BP1.Profesor.infrastructure.controller.dto.ProfesorOutputDtoFull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PutControllerProfesor {

    @Autowired
    ProfesorService profesorService;


    @RequestMapping(value = "/profesor/{id}", method = RequestMethod.PUT)
    ResponseEntity<ProfesorOutputDtoFull> actualizaProfesor(@PathVariable("id") int id, @RequestBody ProfesorInputDto profesorInputDto) throws Exception {
        try {
            return new ResponseEntity<>(profesorService.actualizaProfesor(id, profesorInputDto), HttpStatus.OK);
        } catch (Exception e) {
            throw new NotFoundException("No existe el id");
        }
    }
}

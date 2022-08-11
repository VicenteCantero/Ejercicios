package com.bosonit.BP1.Profesor.infrastructure.controller;

import com.bosonit.BP1.Estudiante.application.EstudianteService;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoFull;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoSimple;
import com.bosonit.BP1.Profesor.ProfesorFeign;
import com.bosonit.BP1.Profesor.application.ProfesorService;
import com.bosonit.BP1.Profesor.domain.Profesor;
import com.bosonit.BP1.Profesor.infrastructure.controller.dto.ProfesorOutputDto;
import com.bosonit.BP1.Profesor.infrastructure.controller.dto.ProfesorOutputDtoFull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("profesor/")
public class GetControllerProfesor {

        @Autowired
        ProfesorService profesorService;

        @Autowired
        ProfesorFeign profesorFeign;

        @GetMapping("{id}")
        public ProfesorOutputDto dameProfesoresPorID(@PathVariable int id, @RequestParam(defaultValue = "simple", required = false) String outputType) throws Exception {
            return profesorService.dameProfesorId(id, outputType);

        }

        @GetMapping("todos")
        public List<ProfesorOutputDtoFull> dameProfesores() {
            return profesorService.dameProfesores();
        }



    @GetMapping("rest/{id}")
    public ProfesorOutputDto getProfesorRest(@PathVariable int id){
        ResponseEntity<ProfesorOutputDto> responseEntity = new  RestTemplate().getForEntity("http://localhost:8080/profesor/" + id, ProfesorOutputDto.class);
        if (responseEntity.getStatusCode()== HttpStatus.OK)
            return responseEntity.getBody();
        throw new RuntimeException("The server didn't respond OK");

    }

    @GetMapping("Feign/{id}")
    public ProfesorOutputDto getProfesorFeign(@PathVariable int id){
            return profesorFeign.dameProfesorID(id);
    }

}

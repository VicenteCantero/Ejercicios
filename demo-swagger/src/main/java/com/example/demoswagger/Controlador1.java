package com.example.demoswagger;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.Random;
import java.util.random.RandomGenerator;

@RestController
@RequestMapping("/test")
public class Controlador1 {


    @PostMapping
    @Operation(summary = "Petición post de ejemplo")
    public StudentOutputDTO insert(@RequestBody StudentInputDTO studentInputDTO)
    {
        StudentOutputDTO studentOutputDTO= new StudentOutputDTO();
        studentOutputDTO.setName(studentInputDTO.getNombre());
        studentOutputDTO.setEdad(studentInputDTO.getEdad());
        studentOutputDTO.setId(RandomGenerator.getDefault().nextInt());
        return new StudentOutputDTO();
    }
    @GetMapping("{id}")
    @Operation(summary = "Peticion get de ejemplo")
    public String get(@PathVariable String id)
    {
        return "Hola "+id;
    }
}

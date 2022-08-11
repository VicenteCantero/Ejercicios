package com.bosonit.BP1.Estudiante.infrastructure.controller.dto;

import com.bosonit.BP1.Persona.Domain.Persona;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentInputDto implements Serializable {

    private int id_persona;
    private int num_hours_week;
    private String coments;
    private String branch;

/*
     private Profesor profesor;

     List<Alumnos_Estudios> estudios;
     */

}

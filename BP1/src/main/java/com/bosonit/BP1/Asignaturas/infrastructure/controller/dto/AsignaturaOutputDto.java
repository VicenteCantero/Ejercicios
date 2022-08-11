package com.bosonit.BP1.Asignaturas.infrastructure.controller.dto;

import com.bosonit.BP1.Asignaturas.domain.Asignaturas;
import com.bosonit.BP1.Estudiante.Domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignaturaOutputDto {

    String asignatura;

    String comment;

    Date initial_date;

    Date finish_date;

    public AsignaturaOutputDto (Asignaturas asignaturas){
        setAsignatura(asignaturas.getAsignatura());
        setComment(asignaturas.getComment());
        setInitial_date(asignaturas.getInitial_date());
        setFinish_date(asignaturas.getFinish_date());
    }
}

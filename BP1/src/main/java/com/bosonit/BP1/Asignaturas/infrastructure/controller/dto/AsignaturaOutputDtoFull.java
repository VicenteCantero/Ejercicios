package com.bosonit.BP1.Asignaturas.infrastructure.controller.dto;

import com.bosonit.BP1.Asignaturas.domain.Asignaturas;
import com.bosonit.BP1.Estudiante.Domain.Student;
import com.bosonit.BP1.Profesor.domain.Profesor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignaturaOutputDtoFull extends AsignaturaOutputDto{

    private Profesor profesor;

    private Student student;

    public AsignaturaOutputDtoFull(Asignaturas asignaturas){
        setProfesor(asignaturas.getProfesor());
        setStudent(asignaturas.getStudent());

        setAsignatura(asignaturas.getAsignatura());
        setComment(asignaturas.getComment());
        setInitial_date(asignaturas.getInitial_date());
        setFinish_date(asignaturas.getFinish_date());
    }
}

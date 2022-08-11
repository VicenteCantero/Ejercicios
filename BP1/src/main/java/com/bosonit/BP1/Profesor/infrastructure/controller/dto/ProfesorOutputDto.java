package com.bosonit.BP1.Profesor.infrastructure.controller.dto;

import com.bosonit.BP1.Estudiante.Domain.Student;
import com.bosonit.BP1.Persona.Domain.Persona;
import com.bosonit.BP1.Profesor.domain.Profesor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfesorOutputDto {

    private int id_profesor;

    private String coments;

    private String branch;

    public ProfesorOutputDto (Profesor profesor){
        setId_profesor(profesor.getId_profesor());
        setComents(profesor.getComents());
        setBranch(profesor.getBranch());
    }

}

package com.bosonit.BP1.Profesor.infrastructure.controller.dto;

import com.bosonit.BP1.Persona.Domain.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfesorInputDto {

    private int id_persona;

    private String coments;

    private String branch;

}

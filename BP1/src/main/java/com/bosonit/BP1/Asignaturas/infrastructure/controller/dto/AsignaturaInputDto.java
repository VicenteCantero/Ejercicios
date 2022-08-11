package com.bosonit.BP1.Asignaturas.infrastructure.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignaturaInputDto {

    String asignatura;

    String comment;

    Date initial_date;

    Date finish_date;

}

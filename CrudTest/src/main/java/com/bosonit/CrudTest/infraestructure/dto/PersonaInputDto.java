package com.bosonit.CrudTest.infraestructure.dto;

import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import lombok.Data;

@Data
@JsonSerializableSchema
public class PersonaInputDto {

    private String nombre;
    private int edad;
}

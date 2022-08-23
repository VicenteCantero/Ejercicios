package com.bosonit.CrudTest.Persona.infraestructure.dto;

import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import lombok.Data;

@Data
public class PersonaInputDto {

    private String nombre;
    private int edad;
}

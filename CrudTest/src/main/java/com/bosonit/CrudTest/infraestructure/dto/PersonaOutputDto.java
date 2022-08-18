package com.bosonit.CrudTest.infraestructure.dto;

import com.bosonit.CrudTest.domain.Persona;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonaOutputDto {
    private int id_persona;
    private String nombre;
    private int edad;


    public PersonaOutputDto(Persona persona) {
        setId_persona(persona.getId_persona());
        setNombre(persona.getNombre());
        setEdad(persona.getEdad());
    }
}

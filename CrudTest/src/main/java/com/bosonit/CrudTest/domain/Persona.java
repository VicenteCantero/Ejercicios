package com.bosonit.CrudTest.domain;

import com.bosonit.CrudTest.infraestructure.dto.PersonaInputDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name= "Persona")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_persona;

    private String nombre;
    private int edad;



    public Persona(PersonaInputDto personaInputDto) {
        if (personaInputDto == null)
            return;
        setNombre(personaInputDto.getNombre());
        setEdad(personaInputDto.getEdad());
    }



    public void put(PersonaInputDto persona) throws Exception{
        try {
            if (persona.getNombre() != null) {
                setNombre(persona.getNombre());
            }
            if (String.valueOf(persona.getEdad()) != null) {
                setEdad(persona.getEdad());
            }
        }catch (Exception e){
            throw new RuntimeException("Campos erróneos");
        }
    }
}
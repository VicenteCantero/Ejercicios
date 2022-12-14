package com.bosonit.CRUDMongo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "persona")
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

    @Id
    private int id_persona;

    private String nombre;
    private String apellido;
    private String direccion;
    private int edad;

    public Persona(Persona persona) {
    }


    public void put(Persona persona) throws Exception{
        try {
            if (persona.getNombre() != null) {
                setNombre(persona.getNombre());
            }
            if (persona.getApellido() != null) {
                setApellido(persona.getApellido());
            }
            if (persona.getDireccion() != null) {
                setDireccion(persona.getDireccion());
            }
            if (String.valueOf(persona.getEdad()) != null) {
                setEdad(persona.getEdad());
            }
        }catch (Exception e){
            throw new RuntimeException("Campos erróneos");
        }
    }
}

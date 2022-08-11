package com.bosonit.CRUDMongo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

    @Id
    private int id_persona;

    private String nombre;
    private String apellido;
    private String direccion;
    private int edad;
}

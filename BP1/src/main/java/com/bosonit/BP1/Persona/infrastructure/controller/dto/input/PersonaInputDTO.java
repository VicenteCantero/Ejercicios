package com.bosonit.BP1.Persona.infrastructure.controller.dto.input;

import com.bosonit.BP1.Estudiante.Domain.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class PersonaInputDTO implements Serializable {

    private int id_persona;
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private Boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;


}

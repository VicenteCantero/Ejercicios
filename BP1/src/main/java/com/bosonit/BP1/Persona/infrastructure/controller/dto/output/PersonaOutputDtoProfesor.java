package com.bosonit.BP1.Persona.infrastructure.controller.dto.output;


import com.bosonit.BP1.Persona.Domain.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaOutputDtoProfesor extends PersonaOutputDTO {


    private int id_profesor;

    private String coments;

    private String branch;

    public PersonaOutputDtoProfesor(Persona persona) {
       setId_persona(persona.getId_persona());
        setUsuario(persona.getUsuario());
        setPassword(persona.getPassword());
        setName(persona.getName());
        setSurname(persona.getSurname());
        setCompany_email(persona.getCompany_email());
        setPersonal_email(persona.getPersonal_email());
        setCity(persona.getCity());
        setActive(persona.getActive());
        setCreated_date(persona.getCreated_date());
        setImagen_url(persona.getImagen_url());
        setTermination_date(persona.getTermination_date());

        setId_profesor(persona.getProfesor().getId_profesor());
        setComents(persona.getProfesor().getComents());
        setBranch(persona.getProfesor().getBranch());
    }
}

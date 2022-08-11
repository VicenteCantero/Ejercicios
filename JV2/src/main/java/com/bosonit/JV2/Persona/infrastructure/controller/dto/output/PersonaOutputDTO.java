package com.bosonit.JV2.Persona.infrastructure.controller.dto.output;


import com.bosonit.JV2.Persona.Domain.Persona;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class PersonaOutputDTO implements Serializable {

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




    public PersonaOutputDTO(Persona persona){

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




        /* ES lo mismo que:
        id_persona = persona.getId_persona();
        usuario = persona.getUsuario();
        password = persona.getPassword();
        name = persona.getName();
        surname = persona.getSurname();
        company_email = persona.getCompany_email();
        personal_email = persona.getPersonal_email();
        city = persona.getCity();
        active = persona.getActive();
        created_date = persona.getCreated_date();
        imagen_url = persona.getImagen_url();
        termination_date = persona.getTermination_date();

         public static List<PersonaOutputDTO> findByUsuario(String usuario) {
        return null;
    }

    public PersonaOutputDTO findById(int id) {
        return null;
    }

         */
    }


}

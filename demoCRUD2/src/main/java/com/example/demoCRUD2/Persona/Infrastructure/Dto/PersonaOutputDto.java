package com.example.demoCRUD2.Persona.Infrastructure.Dto;


import com.example.demoCRUD2.Persona.Domain.Persona;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
public class PersonaOutputDto {
    @Id
    @GeneratedValue
    int id;

    String user;
    String password;
    String surname;
//    @NotNull ... NO TIENE SENTIDO
    String companyEmail;
    String personalEmail;
    String city;
    Boolean active;
    Date createdDate;
    String imagenUrl;
    Date terminationDate;

    public PersonaOutputDto (Persona persona){
        BeanUtils.copyProperties(persona,this);
        /*        setActive(pers.getActive());
        setId(pers.getId());
        setCity(pers.getCity());
        setCompany_email(pers.getCompany_email());
        setPersonal_email(pers.getPersonal_email());
        setCreated_date(pers.getCreated_date());
        setTermination_date(pers.getTermination_date());
        setImagen_url(pers.getImagen_url());
        setPassword(pers.getPassword());
        setSurname(pers.getSurname());
        setUser(pers.getUser());*/
    }
}

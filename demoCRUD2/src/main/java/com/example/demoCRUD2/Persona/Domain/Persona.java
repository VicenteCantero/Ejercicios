package com.example.demoCRUD2.Persona.Domain;

import com.example.demoCRUD2.Persona.Infrastructure.Dto.PersonaInputDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Persona {

    @GeneratedValue
    @Id
    int id;

    String user; // ATENCION: User es una variable reservada en ciertas bases de datos. Postgresql, por ejemplo dara un error .
    String password;
    String surname;
    String companyEmail;
    String personalEmail;
    String city;
    Boolean active;
    Date createdDate;
    String imagenUrl;
    Date terminationDate;

    public Persona (PersonaInputDto persDto){
        BeanUtils.copyProperties(persDto,this);
/*        setUser(persDto.user());
        setActive(persDto.active());
        setCity(persDto.city());
        setCompany_email(persDto.companyEmail());
        setPersonal_email(persDto.personalEmail());
        setCreated_date(persDto.createdDate());
        setPassword(persDto.password());
        setImagen_url(persDto.imagenUrl());
        setSurname(persDto.surname());
        setTermination_date(persDto.terminationDate());*/
    }


}

package com.bosonit.JV2.Persona.application;

import com.bosonit.JV2.Persona.Domain.Persona;
import com.bosonit.JV2.Persona.Domain.Records.PersonaRecords;
import com.bosonit.JV2.Persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.JV2.Persona.infrastructure.repository.PersonaRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
public class ClaseInicial {

    @Autowired
    PersonaRepositoryJPA personaRepositoryJPA;

    @PostConstruct
    public void construirPersonas(){

        for(int i=1; i< 30; i++){
            PersonaInputDTO persona3 =new PersonaInputDTO(

                    "Lola" + i,
                    "password",
                    "Lola",
                    "surname",
                    "Lolacompany_email",
                    "Lolapersonal_email",
                    "Lolacity",
                    true,
                    null,
                    "Lolaimagen_url",
                    null
            );
            personaRepositoryJPA.save(new Persona(persona3));
        }


        PersonaInputDTO persona =new PersonaInputDTO(

                "Lolo",
                "password",
                "Lolo",
                "Lolosurname",
                "Lolocompany_email",
                "Lolopersonal_email",
                "Lolocity",
                true,
                null,
                "imagen_url",
                null
        );
        PersonaInputDTO persona2 =new PersonaInputDTO(


                "Lola",
                "password",
                "Lola",
                "surname",
                "Lolacompany_email",
                "Lolapersonal_email",
                "Lolacity",
                true,
                null,
                "Lolaimagen_url",
                null
        );

        personaRepositoryJPA.save(new Persona(persona));
        personaRepositoryJPA.save(new Persona(persona2));




    }
}

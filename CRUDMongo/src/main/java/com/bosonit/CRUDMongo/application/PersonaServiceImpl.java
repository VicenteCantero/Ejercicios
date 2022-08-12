package com.bosonit.CRUDMongo.application;

import com.bosonit.CRUDMongo.application.generico.GenericImpl;
import com.bosonit.CRUDMongo.domain.Persona;
import com.bosonit.CRUDMongo.infraestructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class PersonaServiceImpl extends GenericImpl<Persona, Integer> implements PersonaService{

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public MongoRepository<Persona, Integer> getDao() {
        return personaRepository;
    }

    @Override
    public Persona put(int id, Persona persona) {

        try {
           Persona personaEncontrada = personaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Persona con esa id no encontrada"));

            personaEncontrada.put(persona);
            personaRepository.save(personaEncontrada);

            return personaEncontrada;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}

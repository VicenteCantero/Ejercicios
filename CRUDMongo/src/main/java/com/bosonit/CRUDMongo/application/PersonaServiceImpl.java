package com.bosonit.CRUDMongo.application;

import com.bosonit.CRUDMongo.application.generico.GenericImpl;
import com.bosonit.CRUDMongo.domain.Persona;
import com.bosonit.CRUDMongo.infraestructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceImpl extends GenericImpl<Persona, Integer> implements PersonaService{

    @Autowired
    PersonaRepository personaRepository;


    @Autowired
    MongoTemplate mongoTemplate;

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

    // MONGO TEMPLATE

    @Override
    public Persona añadir(Persona persona) {
        mongoTemplate.save(persona);
        return persona;
    }


    @Override
    public void borraByID(int id) {
        if (mongoTemplate.exists(Query.query(Criteria.where("id_persona").is(id)), Persona.class))
            mongoTemplate.remove(Query.query(Criteria.where("id_persona").is(id)), Persona.class);
        else throw new RuntimeException("No se ha encontrado la Persona con ID: " + id);
    }

    @Override
    public Persona damePersonaByID(int id) {
        Persona personaID = new Persona();
        Query query = new Query();
        query.addCriteria(Criteria.where("id_persona").is(id));
        mongoTemplate.find(query, Persona.class);
        return personaID;
    }

    @Override
    public List<Persona> damePersonas() {
        List<Persona> listaPersonas = new ArrayList<>();
        mongoTemplate.findAll(Persona.class).forEach(p -> listaPersonas.add(new Persona(p)));
        return listaPersonas;
    }




}

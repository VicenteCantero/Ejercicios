package com.bosonit.CRUDMongo.infraestructure.repository;

import com.bosonit.CRUDMongo.domain.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonaRepository extends MongoRepository<Persona, Integer> {
}

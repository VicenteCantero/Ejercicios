package com.bosonit.CRUDMongo.application;

import com.bosonit.CRUDMongo.application.generico.GenericService;
import com.bosonit.CRUDMongo.domain.Persona;

public interface PersonaService extends GenericService<Persona, Integer> {

    Persona put(int id, Persona persona);
}

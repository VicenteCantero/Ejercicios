package com.bosonit.CRUDMongo.application;

import com.bosonit.CRUDMongo.application.generico.GenericService;
import com.bosonit.CRUDMongo.domain.Persona;

import java.util.List;

public interface PersonaService extends GenericService<Persona, Integer> {

      Persona put(int id, Persona persona);


      // MONGO TEMPLATE
    Persona añadir (Persona persona);

    void borraByID(int id);

    List<Persona> damePersonaByID(int id);

    List<Persona> damePersonas();
}

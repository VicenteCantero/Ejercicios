package com.bosonit.RS1.services;

import com.bosonit.RS1.model.Persona;

import java.util.List;

public interface PersonaService {


    List<Persona> damePersonas();

    Persona añadirPersona (Persona persona);

    Persona actualizaPersonaId(Persona persona, int id);

    Persona borrarPersona (int id);

    Persona damePersonasID (int id);

    Persona damePersonasNombre (String nombre);



    int getID();

    void setID(int id);
    String getNombre();

    void setNombre(String nombre);

    String getPoblacion();

    void setPoblación(String poblacion);

    int getEdad();

    void setEdad(int edad);
}

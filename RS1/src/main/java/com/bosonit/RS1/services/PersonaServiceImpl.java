package com.bosonit.RS1.services;

import com.bosonit.RS1.model.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService{
    Persona persona= new Persona();

    List<Persona> listaPersonas= new ArrayList<>();

    @Override
    public List<Persona> damePersonas() {
        return listaPersonas;
    }

    @Override
    public Persona añadirPersona(Persona p) {
        listaPersonas.add(p);
        return p;
    }

    public Persona actualizaPersonaId(Persona persona, int id){
        Persona personaPorId = damePersonasID(id);
        if(persona.getNombre() != null){
            personaPorId.setNombre(persona.getNombre());
        }
        if (persona.getPoblacion() != null){
            personaPorId.setPoblacion(persona.getPoblacion());
        }
        if (String.valueOf(persona.getEdad()) != null){
            personaPorId.setEdad(persona.getEdad());
        }
        if (String.valueOf(persona.getId()) != null){
            personaPorId.setId(persona.getId());
        }

        return personaPorId;
    }
    @Override
    public Persona borrarPersona(int id) {
        Persona personaBorrada= listaPersonas.get(id-1);
        listaPersonas.remove(personaBorrada);
        return personaBorrada;
    }

    @Override
    public Persona damePersonasID(int id) {
        return listaPersonas.get(id);
    }

    @Override
    public Persona damePersonasNombre(String nombre) {
        Persona persona = listaPersonas.stream()
                .filter(p-> nombre.equals(p.getNombre())).findFirst().orElse(null);
        return persona;
    }

    @Override
    public int getID() {
        return persona.getId();
    }

    @Override
    public void setID(int id) {
        persona.setId(id);
    }


    @Override
    public String getNombre() {
        return persona.getNombre();
    }

    @Override
    public void setNombre(String nombre) {
        persona.setNombre(nombre);
    }

    @Override
    public String getPoblacion() {
        return persona.getPoblacion();
    }

    @Override
    public void setPoblación(String poblacion) {
        persona.setPoblacion(poblacion);
    }

    @Override
    public int getEdad() {
        return persona.getEdad();
    }

    @Override
    public void setEdad(int edad) {
        persona.setEdad(edad);
    }
}

package com.bosonit.BS21.services;

import com.bosonit.BS21.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements PersonaService{

    Persona persona =new Persona();

    @Override
    public String getNombre() {
        return persona.getNombre();
    }

    public void setNombre(String nombre){
        persona.setNombre(nombre);
    }
    public String getPoblacion() {
        return persona.getPoblación();
    }

    public void setPoblacion(String poblacion){
        persona.setPoblación(poblacion);
    }
    public String getEdad() {
        return persona.getEdad();
    }

    public void setEdad(String edad){
        persona.setEdad(edad);
    }


}

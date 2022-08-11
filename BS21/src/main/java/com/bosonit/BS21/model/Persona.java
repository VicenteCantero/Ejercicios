package com.bosonit.BS21.model;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public class Persona {

    private String nombre;
    private String población;
    private String edad;


    public Persona(){ }

    public Persona( String nombre, String poblacion, String edad){
        this.nombre= nombre;
        this.población = poblacion;
        this.edad= edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPoblación() {
        return población;
    }

    public void setPoblación(String población) {
        this.población = población;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public void dobleEdad(){
        this.edad= String.valueOf(Integer.parseInt(getEdad()) * 2);
    }

    /*public Persona dobleEdad(Persona persona){
        Persona doblePersona= new Persona (persona.getNombre(), persona.getNombre(), persona.getEdad()*2);
        return doblePersona;
    }*/

}

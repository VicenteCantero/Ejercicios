package com.bosonit.RS1.model;

import org.springframework.stereotype.Component;

@Component
public class Persona {
        private int id;
        private String nombre;
        private int edad;
        private String poblacion;

     public Persona(){

     }

     public Persona (int id, String nombre,  int edad, String poblacion){
         this.id=id;
         this.nombre=nombre;
         this.edad=edad;
         this.poblacion=poblacion;
     }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

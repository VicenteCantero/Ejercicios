package com.bosonit.BS0.model;

public class Persona {
    private String name;
    private String edad;
    private String ciudad;

    public Persona(String name, String edad, String ciudad) {
        this.name = name;
        this.edad = edad;
        this.ciudad  = ciudad;
    }

    public void añadirAño() {
        this.edad =  String.valueOf(Integer.parseInt(getEdad()) +1);
    }

    public String getName() {
        return name;
    }

    public String getEdad() {
        return edad;
    }

    public String getCiudad() {
        return ciudad;
    }

    @Override
    public String toString() {
        String response = "Nombre: " + getName() + ". "
                + "Poblacion: " + getCiudad() + ". "
                + "Edad: " + getEdad();
        return response;
    }
}

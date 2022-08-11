package PlanEstudiosJava;

import java.util.Optional;

public class Persona {

    private String nombre;
    private String poblacion;
    private Optional<Integer> edad;

    public Persona(String nombre, String poblacion,Optional<Integer> edad){
        this.nombre= nombre;
        this.poblacion= poblacion;
        this.edad= edad;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String ciudad) {
        this.poblacion = ciudad;
    }

    public Optional<Integer> getEdad() {
        return edad;
    }

    public void setEdad(Optional<Integer> edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return  "Nombre=" + nombre + '.' +
                ", Poblacion=" + poblacion + '.' +
                ", Edad=" + edad.get() +
                '}';
    }
}

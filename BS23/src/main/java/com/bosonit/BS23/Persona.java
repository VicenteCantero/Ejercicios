package com.bosonit.BS23;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Persona {

    private String nombre;

    public Persona(){}

    public Persona(String nombre){
        this.nombre=nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*
    @Component
    @Qualifier(value ="bean1, bean2, bean3")
    public class PersonConfig {
        @Bean
        public Persona persona1(){
            return new Persona("bean1");
        }

        @Bean
        public Persona persona2(){
            return new Persona("bean2");
        }

        @Bean
        public Persona persona3(){
            return new Persona("bean3");
        }
    }*/
}

package com.bosonit.BS3;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ObjetoBean {

    String nombre;

    ObjetoBean(){

    }
    public ObjetoBean(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

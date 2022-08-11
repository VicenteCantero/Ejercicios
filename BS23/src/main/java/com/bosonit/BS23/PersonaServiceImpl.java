package com.bosonit.BS23;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements PersonaService{


    @Qualifier(value = " ")
    Persona persona= new Persona();
/*
    private Persona bean1= new Persona();

    private Persona bean2 = new Persona();

    private Persona bean3 = new Persona();*/

    @Override
    public void setNombre(String nombre) {

        persona.setNombre(nombre);
    }

    public String getNombre(){
        return persona.getNombre();
    };
/*
    @Qualifier(value = "bean1")
    public void setBean1(Persona bean1){
        this.bean1=bean1;
        this.bean1.setNombre("bean1");
    }


    @Qualifier("bean2")
    public void setBean2(Persona bean2){
        this.bean2=bean2;
        this.bean2.setNombre("bean2");
    }


    @Qualifier("bean3")
    public void setBean3(Persona bean3){
        this.bean3=bean3;
        this.bean3.setNombre("bean3");
    }

    @Override
    public void setNombre(String nombre) {

    }*/
}

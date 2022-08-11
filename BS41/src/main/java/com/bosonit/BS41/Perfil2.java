package com.bosonit.BS41;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("perfil2")
public class Perfil2 implements Perfiles {

    //spring.profiles.active=perfil2 en edit config
    @Override
    public String miFuncion() {
        return "Valor de perfil2 es hakuna matata";
    }
}

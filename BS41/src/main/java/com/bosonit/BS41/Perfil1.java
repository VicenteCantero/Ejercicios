package com.bosonit.BS41;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("perfil1")
public class Perfil1 implements Perfiles{

//spring.profiles.active=perfil1
    @Override
    public String miFuncion() {
     return "Valor de perfil1 es: perfil1";
    }

}

package com.bosonit.demoJwt.Security.util;

import com.bosonit.demoJwt.Security.entity.Rol;
import com.bosonit.demoJwt.Security.enums.RolNombre;
import com.bosonit.demoJwt.Security.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CreateRoles{

    @Autowired
    RolService rolService;


    @PostConstruct
    public void crearRol(){
    Rol rolAdmin= new Rol(RolNombre.ROLE_ADMIN);
    Rol rolUser= new Rol(RolNombre.ROLE_USER);
    rolService.save(rolAdmin);
    rolService.save(rolUser);
    }
}

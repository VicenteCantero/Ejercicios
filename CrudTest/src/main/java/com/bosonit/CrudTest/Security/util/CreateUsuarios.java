package com.bosonit.CrudTest.Security.util;

import com.bosonit.CrudTest.Security.entity.Rol;
import com.bosonit.CrudTest.Security.entity.Usuario;
import com.bosonit.CrudTest.Security.enums.RolNombre;
import com.bosonit.CrudTest.Security.service.RolService;
import com.bosonit.CrudTest.Security.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

import static com.bosonit.CrudTest.Security.enums.RolNombre.ROLE_ADMIN;

@Component
public class CreateUsuarios implements CommandLineRunner {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;

    @Override
    public void run(String... args) throws Exception {
        //Usuario admin= new Usuario("admin","admin","admin@email","1234");
        Usuario user= new Usuario("user","user","user@email","1234");
        //usuarioService.save(admin);
        usuarioService.save(user);

    }
}

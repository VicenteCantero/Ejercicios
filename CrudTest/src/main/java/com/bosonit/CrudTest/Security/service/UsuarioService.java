package com.bosonit.CrudTest.Security.service;

import com.bosonit.CrudTest.Persona.infraestructure.dto.PersonaOutputDto;
import com.bosonit.CrudTest.Security.entity.Usuario;
import com.bosonit.CrudTest.Security.entity.UsuarioPrincipal;
import com.bosonit.CrudTest.Security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional    //evitar incoherencias en BBDD
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<Usuario> getByNombreUsuario (String nombreUsuario) {
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public boolean existByNombreUsuario (String nombreUsuario){
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    public boolean existByEmail (String email){
        return usuarioRepository.existsByEmail(email);
    }


    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public List<Usuario> getall() {

        List<Usuario> usuarios;
        //buscamos todas los objetos en el repositorio y los casteamos a nuestro objeto de salida
        usuarios = usuarioRepository.findAll();

        return usuarios;
    }
}


//https://www.youtube.com/watch?v=MWW8sFbq39c&list=PL4bT56Uw3S4z9rtwwGvuk1Mjhu5sdLSwX&index=4
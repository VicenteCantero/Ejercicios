package com.bosonit.JPAdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class controlador {


    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @GetMapping
    public List<Usuario> getAll(){
     return usuarioRepositorio.findAll();
    }

    @GetMapping("{id}")
    public Usuario getbyId(@PathVariable String id) throws Exception{
        return usuarioRepositorio.findById(id).orElseThrow(()->new Exception("No encontrado"));
    }

    @PostMapping
    public Usuario añadirUsuario(@RequestBody Usuario usu){
        System.out.println("en el controlador de post");
        usuarioRepositorio.save(usu);
        return usu;
    }
}

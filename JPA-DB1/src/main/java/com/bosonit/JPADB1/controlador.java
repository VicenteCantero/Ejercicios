package com.bosonit.JPADB1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class controlador {

    @Autowired
    PersonaRepositorio personaRepositorio;


    //CREAR
    @PostMapping("/persona")
    public Persona añadirPersona(@RequestBody Persona p) throws Exception {

        try {
            if (p.getUsuario() == null) {
                throw new Exception("Usuario no puede ser nulo");
            }
            if (p.getUsuario().length() > 10) {
                throw new Exception("Longitud de usuario no puede ser superior a 10 caracteres");
            }
            if (p.getPassword() == null) {
                throw new Exception("Password no puede ser nulo");
            }
            if (p.getName() == null) {
                throw new Exception("Name no puede ser nulo");
            }
            if (p.getCompany_email() == null) {
                throw new Exception("Company_email no puede ser nulo");
            }
            if (p.getPersonal_email() == null) {
                throw new Exception("Personal_email no puede ser nulo");
            }
            if (p.getActive() == null) {
                throw new Exception("Active no puede ser nulo");
            }
            if (p.getCreated_date() == null) {
                throw new Exception("Create_date no puede ser nulo");
            }
            personaRepositorio.save(p);
            return p;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return p;
        }
    }

    //READ
    @GetMapping("/persona")
        public List<Persona> getAll() {
        return personaRepositorio.findAll();
    }

    @GetMapping("/persona/{id}")
    public Persona getbyId(@PathVariable int id) throws Exception {
        try{
            return personaRepositorio.findById(id).orElseThrow(() -> new Exception("No encontrado"));
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @GetMapping("/persona/usuario/{usuario}")
    public List<Persona> findByUsuario(@PathVariable String usuario) throws Exception {
        List<Persona> personasDos = null;
        try {
            List<Persona> listaPersonas;

            listaPersonas = personaRepositorio.findAll();

            personasDos = listaPersonas.stream()
                    .filter(p -> usuario.equals(p.getUsuario())).toList();

            if (personasDos.isEmpty()) {
                throw new Exception("No hay coincidencias");
            }
            return personasDos;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return personasDos;
        }

    }

    @GetMapping("usuario/{usuario}")
    public List<Persona> damePersonaPorUsuaio(@PathVariable (value= "usuario") String usuario){
        return personaRepositorio.findByUsuario(usuario);
    }

    //DELETE
    @DeleteMapping("/persona/{id}")
    String personaBorradaPorID(@PathVariable int id) throws Exception {
        try {
            personaRepositorio.deleteById(id);
            return "Borrada persona con id: " + id;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "La persona con el id no existe";
        }
    }

     //PUT

    @PutMapping("/persona/actualiza")
    public Persona personaActualizada(@RequestBody Persona persona) throws Exception{
        try {
            Persona persona1 = personaRepositorio.findById(persona.getId_persona()).get();
            personaRepositorio.save(persona);
            return persona1;
        }catch (Exception e){
            System.out.println("El id no existe");
            return null;
        }
    }

}




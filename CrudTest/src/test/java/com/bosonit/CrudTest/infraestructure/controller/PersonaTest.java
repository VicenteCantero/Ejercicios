package com.bosonit.CrudTest.infraestructure.controller;

import com.bosonit.CrudTest.Persona.domain.Persona;
import com.bosonit.CrudTest.Persona.infraestructure.repository.PersonaRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonaTest {

    @Autowired
    PersonaRepository personaRepository;

    @Test
    @Order(1)
    @Rollback(false)
    public void testCrearPersona(){
        Persona persona= new Persona("Pepe", 10);
        Persona creadaPersona= personaRepository.save(persona);
        assertNotNull(creadaPersona);
    }


    @Test
    @Order(2)
    public void testBuscarPorNombre(){
        String nombre="Pepe";
        Persona persona= personaRepository.findByNombre(nombre);
        assertThat(persona.getNombre()).isEqualTo(nombre);
    }

    @Test
    @Order(3)
    public void testBuscarPorNombreInexistente(){
        String nombre="Pepote";
        Persona persona= personaRepository.findByNombre(nombre);
        assertNull(persona);
    }

    @Test
    @Order(4)
    public void testDamePersonas(){
        List<Persona> listaPersonas= personaRepository.findAll();

        assertThat(listaPersonas).size().isGreaterThan(0);
    }


    @Test
    @Order(5)
    public void testActualizarPersona(){
        Persona persona = personaRepository.findByNombre("Pepe");
        persona.setEdad(15);
        Persona personaActualizada =  personaRepository.save(persona);
        assertThat(personaActualizada.getEdad()).isEqualTo(15);
    }


    @Test
    public void testBorrarPersona(){
        int id=1;
        boolean siExisteAntesBorrar=personaRepository.findById(id).isPresent();

        personaRepository.deleteById(id);

        boolean noExisteAntesBorrar=personaRepository.findById(id).isPresent();

        assertTrue(siExisteAntesBorrar);
        assertFalse(noExisteAntesBorrar);


    }
}


//https://www.youtube.com/watch?v=1kLwwsfghgE
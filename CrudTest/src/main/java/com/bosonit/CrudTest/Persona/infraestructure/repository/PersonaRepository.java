package com.bosonit.CrudTest.Persona.infraestructure.repository;

import com.bosonit.CrudTest.Persona.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonaRepository extends JpaRepository<Persona,Integer> {
    Persona findByNombre(String nombre);
}

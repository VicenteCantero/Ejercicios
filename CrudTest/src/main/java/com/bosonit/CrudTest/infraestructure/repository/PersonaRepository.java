package com.bosonit.CrudTest.infraestructure.repository;

import com.bosonit.CrudTest.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonaRepository extends JpaRepository<Persona,Integer> {
}

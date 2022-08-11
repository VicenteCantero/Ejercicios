package com.bosonit.JV2.Persona.infrastructure.repository;

import com.bosonit.JV2.Persona.Domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashMap;
import java.util.List;

public interface PersonaRepositoryJPA extends JpaRepository<Persona, Integer> {

    List<Persona> findByUsuario(String usuario);

}

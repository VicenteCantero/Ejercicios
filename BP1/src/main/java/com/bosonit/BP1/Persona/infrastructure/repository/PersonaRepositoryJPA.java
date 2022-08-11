package com.bosonit.BP1.Persona.infrastructure.repository;

import com.bosonit.BP1.Persona.Domain.Persona;
import com.bosonit.BP1.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepositoryJPA extends JpaRepository<Persona, Integer> {

    List<Persona> findByUsuario(String usuario);
}

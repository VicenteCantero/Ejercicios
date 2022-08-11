package com.example.demoCRUD2.Persona.Infrastructure.Repository;

import com.example.demoCRUD2.Persona.Domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface PersonaRepository extends JpaRepository<Persona,String> {
    Optional<Persona> findById(int id_persona);

    List<Persona> findByUser(String paco);
}

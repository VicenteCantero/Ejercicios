package com.bosonit.repo;

import com.bosonit.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonaRepo extends JpaRepository<Persona, Integer> {
}

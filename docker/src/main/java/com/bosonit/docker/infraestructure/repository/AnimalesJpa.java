package com.bosonit.docker.infraestructure.repository;

import com.bosonit.docker.domain.Animales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalesJpa extends JpaRepository<Animales, Integer> {
}

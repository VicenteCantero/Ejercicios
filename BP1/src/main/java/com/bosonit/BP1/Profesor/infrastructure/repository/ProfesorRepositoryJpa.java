package com.bosonit.BP1.Profesor.infrastructure.repository;

import com.bosonit.BP1.Profesor.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepositoryJpa extends JpaRepository<Profesor, Integer> {
}

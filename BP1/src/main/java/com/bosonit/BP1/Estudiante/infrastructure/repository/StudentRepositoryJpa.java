package com.bosonit.BP1.Estudiante.infrastructure.repository;

import com.bosonit.BP1.Estudiante.Domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositoryJpa extends JpaRepository<Student, Integer> {


}

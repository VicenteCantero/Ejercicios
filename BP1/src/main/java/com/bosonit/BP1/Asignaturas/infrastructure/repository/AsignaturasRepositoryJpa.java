package com.bosonit.BP1.Asignaturas.infrastructure.repository;

import com.bosonit.BP1.Asignaturas.domain.Asignaturas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsignaturasRepositoryJpa extends JpaRepository<Asignaturas, Integer> {

    @Query(value = "SELECT * FROM ESTUDIOS WHERE ID_STUDY IN (SELECT ASIGNATURAS_ID_STUDY FROM  ESTUDIANTES_ASIGNATURAS WHERE ESTUDIANTES_APUNTADOS_ID_STUDENT = ?1)", nativeQuery = true)
    List<Asignaturas> encuentraAsignaturaEstudiante(int id);

}

package com.bosonit.CrudTest.Security.repository;

import com.bosonit.CrudTest.Security.entity.Rol;
import com.bosonit.CrudTest.Security.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

        Optional<Rol> findByRolNombre (RolNombre rolNombre);
}

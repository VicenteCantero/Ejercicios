package com.bosonit.JPADB1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface PersonaRepositorio extends JpaRepository<Persona, Integer> {

    List<Persona> findByUsuario(String usuario);
}

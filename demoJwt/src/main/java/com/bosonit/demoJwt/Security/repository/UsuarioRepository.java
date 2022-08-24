package com.bosonit.demoJwt.Security.repository;

import com.bosonit.demoJwt.Security.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByNombreUsuario (String nombreUsuario);

    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByEmail(String email);
}

//https://www.youtube.com/watch?v=MWW8sFbq39c&list=PL4bT56Uw3S4z9rtwwGvuk1Mjhu5sdLSwX&index=5

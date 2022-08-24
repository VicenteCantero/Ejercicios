package com.bosonit.demoJwt.Security.service;

import com.bosonit.demoJwt.Security.entity.Usuario;
import com.bosonit.demoJwt.Security.entity.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario usuario= usuarioService.getByNombreUsuario(nombreUsuario).get();
        return UsuarioPrincipal.build(usuario);
    }
}

//https://www.youtube.com/watch?v=MWW8sFbq39c&list=PL4bT56Uw3S4z9rtwwGvuk1Mjhu5sdLSwX&index=4

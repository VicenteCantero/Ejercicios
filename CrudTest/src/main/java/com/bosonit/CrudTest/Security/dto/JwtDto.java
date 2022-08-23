package com.bosonit.CrudTest.Security.dto;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
public class JwtDto {

    private String token;
    private String bearer= "Bearer";
    private String nombreUsuario;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtDto(String token, String nombreUsuario, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.nombreUsuario = nombreUsuario;
        this.authorities = authorities;
    }
}

////https://www.youtube.com/watch?v=jX2tsI58j-c&list=PL4bT56Uw3S4z9rtwwGvuk1Mjhu5sdLSwX&index=6

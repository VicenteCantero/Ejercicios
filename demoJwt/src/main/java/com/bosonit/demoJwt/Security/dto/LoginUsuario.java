package com.bosonit.demoJwt.Security.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;


public class LoginUsuario {

    @NotBlank
    private String nombreUsuario;
    @NotBlank
    private String password;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

////https://www.youtube.com/watch?v=jX2tsI58j-c&list=PL4bT56Uw3S4z9rtwwGvuk1Mjhu5sdLSwX&index=6

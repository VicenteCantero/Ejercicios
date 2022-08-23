package com.bosonit.CrudTest.Security.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginUsuario {

    @NotBlank
    private String nombreUsuario;
    @NotBlank
    private String password;
}

////https://www.youtube.com/watch?v=jX2tsI58j-c&list=PL4bT56Uw3S4z9rtwwGvuk1Mjhu5sdLSwX&index=6

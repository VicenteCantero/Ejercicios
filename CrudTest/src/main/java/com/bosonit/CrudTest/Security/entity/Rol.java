package com.bosonit.CrudTest.Security.entity;

import com.bosonit.CrudTest.Security.enums.RolNombre;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RolNombre rolNombre;

    public Rol() {
    }

    public Rol(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
}

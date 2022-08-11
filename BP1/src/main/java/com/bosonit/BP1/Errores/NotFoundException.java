package com.bosonit.BP1.Errores;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{

    //Esto no lo entiendo
    //private static final long serialVersionUID =1L;

    public NotFoundException (String mensaje){
        super(mensaje);
    }
}

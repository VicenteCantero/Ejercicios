package com.bosonit.BP1.Errores;

import lombok.Data;

import java.util.Date;

@Data
public class CustomError {

    Date timestap;
    int httpCode;
    String mensajeError;

    public CustomError(Date timestap, int httpCode, String mensajeError) {
        this.timestap = timestap;
        this.httpCode = httpCode;
        this.mensajeError = mensajeError;
    }
}

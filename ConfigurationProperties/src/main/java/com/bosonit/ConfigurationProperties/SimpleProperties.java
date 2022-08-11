package com.bosonit.ConfigurationProperties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix= "simple")

public class SimpleProperties {

    private String texto;
    private int numero;

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "SimpleProperties{" +
                "texto='" + texto + '\'' +
                ", numero=" + numero +
                '}';
    }
}

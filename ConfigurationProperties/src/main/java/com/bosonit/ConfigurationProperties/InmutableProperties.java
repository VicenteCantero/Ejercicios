package com.bosonit.ConfigurationProperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties(prefix= "inmutable")
@ConstructorBinding
public class InmutableProperties {

    private final String texto;
    private final double numero;

    private final String relaxBinding;

    public InmutableProperties(String texto, double numero, String relaxBinding) {
        this.texto = texto;
        this.numero = numero;
        this.relaxBinding = relaxBinding;
    }

    @Override
    public String toString() {
        return "InmutableProperties{" +
                "texto='" + texto + '\'' +
                ", numero=" + numero +
                ", relaxBinding='" + relaxBinding + '\'' +
                '}';
    }
}

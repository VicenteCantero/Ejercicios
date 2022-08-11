package com.bosonit.BS41;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix= "valor1")
@Component
public class Valor1 {

    private String url1;
    private String password1;

    public Valor1(String url1, String password1) {
        this.url1 = url1;
        this.password1 = password1;
    }

    public Valor1() {
    }

    public String getUrl1() {
        return url1;
    }

    public void setUrl1(String url1) {
        this.url1 = url1;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    @Override
    public String toString() {
        return "Valor1{" +
                "url1='" + url1 + '\'' +
                ", password1='" + password1 + '\'' +
                '}';
    }
}

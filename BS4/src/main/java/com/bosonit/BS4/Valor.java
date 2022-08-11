package com.bosonit.BS4;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix= "valor")
@Component
public class Valor {
    private String VAR1;
    private String MyVAR2;

    private String VAR3;

    public Valor(String VAR1, String myVAR2, String VAR3) {
        this.VAR1 = VAR1;
        MyVAR2 = myVAR2;
        this.VAR3 = VAR3;
    }

    public String getVAR3() {
        return VAR3;
    }

    public void setVAR3(String VAR3) {
        this.VAR3 = VAR3;
    }

    public Valor (){

    };

    public Valor(String VAR1) {
        this.VAR1 = VAR1;
    }

    public String getVAR1() {
        return VAR1;
    }

    public String getMyVAR2() {
        return MyVAR2;
    }

    public void setVAR1(String VAR1) {
        this.VAR1 = VAR1;
    }

    public void setMyVAR2(String myVAR2) {
        MyVAR2 = myVAR2;
    }

    @Override
    public String toString() {
        return "Valor de var1 es " + VAR1 + ", Valor de MyVAR2 es " + MyVAR2 + ", Valor de VAR3 es " + VAR3;
    }

}

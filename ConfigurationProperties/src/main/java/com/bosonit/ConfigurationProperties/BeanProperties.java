package com.bosonit.ConfigurationProperties;

//import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

@Validated
public class BeanProperties {
    //@Length(min=1, max=3)
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

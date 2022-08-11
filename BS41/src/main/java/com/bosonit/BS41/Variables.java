package com.bosonit.BS41;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix= "variable")
@Component
public class Variables {
    private String url;
    private String password;

    public Variables() {
    }

    public Variables(String url, String password) {
        this.url = url;
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Variables{" +
                "url='" + url + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

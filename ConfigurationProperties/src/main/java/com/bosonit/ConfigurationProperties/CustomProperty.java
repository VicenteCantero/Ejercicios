package com.bosonit.ConfigurationProperties;

public class CustomProperty {
    private String name;
    private boolean inmutable;

    public CustomProperty(String name, boolean inmutable) {
        this.name = name;
        this.inmutable = inmutable;
    }

    @Override
    public String toString() {
        return "CustomProperty{" +
                "name='" + name + '\'' +
                ", inmutable=" + inmutable +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isInmutable() {
        return inmutable;
    }

    public void setInmutable(boolean inmutable) {
        this.inmutable = inmutable;
    }
}

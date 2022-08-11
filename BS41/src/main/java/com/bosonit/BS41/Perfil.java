package com.bosonit.BS41;

public class Perfil {

    private String perfil1;

    private String perfil2;

    public Perfil() {
    }

    public Perfil(String perfil1, String perfil2) {
        this.perfil1 = perfil1;
        this.perfil2 = perfil2;
    }

    public String getPerfil1() {
        return perfil1;
    }

    public void setPerfil1(String perfil1) {
        this.perfil1 = perfil1;
    }

    public String getPerfil2() {
        return perfil2;
    }

    public void setPerfil2(String perfil2) {
        this.perfil2 = perfil2;
    }

    @Override
    public String toString() {
        return "Perfil{" +
                "perfil1='" + perfil1 + '\'' +
                ", perfil2='" + perfil2 + '\'' +
                '}';
    }
}

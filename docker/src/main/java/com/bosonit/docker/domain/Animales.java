package com.bosonit.docker.domain;

import com.bosonit.docker.infraestructure.dto.AnimalesInputDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Animales {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int animalId;

    private String nombre;


    public Animales(AnimalesInputDto animalesInputDto) {
        setNombre(animalesInputDto.getNombre());

    }
}

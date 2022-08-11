package com.bosonit.docker.infraestructure.dto;

import com.bosonit.docker.domain.Animales;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AnimalesOutputDto {

    private int animalId;
    private String nombre;

    public AnimalesOutputDto(Animales animales){

        setAnimalId(animales.getAnimalId());
        setNombre(animales.getNombre());

    }
}

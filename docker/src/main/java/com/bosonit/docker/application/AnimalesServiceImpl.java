package com.bosonit.docker.application;

import java.util.List;


import com.bosonit.docker.domain.Animales;

import com.bosonit.docker.infraestructure.dto.AnimalesInputDto;
import com.bosonit.docker.infraestructure.dto.AnimalesOutputDto;
import com.bosonit.docker.infraestructure.repository.AnimalesJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Component
public class AnimalesServiceImpl implements AnimalesService {

     @Autowired
    AnimalesJpa animalesJpa;



    @Override
    public List<AnimalesOutputDto> findAll() {
        //creamos lista de animales de salida
        List<AnimalesOutputDto> animales;
        //buscamos todas los objetos en el repositorio y los casteamos a nuestro objeto de salida
        animales = animalesJpa.findAll().stream().map(s -> new AnimalesOutputDto(s)).toList();

        return animales;
    }

    @Override
    public AnimalesOutputDto insertaAnimal(AnimalesInputDto animalesInputDto){

        Animales animales= new Animales(animalesInputDto);

        //guardamos el objeto de entrada
        animalesJpa.save(animales);
        //creamos objeto de salida y le pasamos los parámetros
        AnimalesOutputDto animalesOutputDto= new AnimalesOutputDto(animales);
        return animalesOutputDto;
    }
}

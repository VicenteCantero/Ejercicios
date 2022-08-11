package com.bosonit.docker.application;

import com.bosonit.docker.domain.Animales;
import com.bosonit.docker.infraestructure.dto.AnimalesInputDto;
import com.bosonit.docker.infraestructure.dto.AnimalesOutputDto;

import java.util.List;


public interface AnimalesService {

    List<AnimalesOutputDto> findAll();

    public AnimalesOutputDto insertaAnimal(AnimalesInputDto animalesInputDto);

}

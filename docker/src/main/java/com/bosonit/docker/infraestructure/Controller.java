package com.bosonit.docker.infraestructure;

import com.bosonit.docker.application.AnimalesService;
import com.bosonit.docker.infraestructure.dto.AnimalesInputDto;
import com.bosonit.docker.infraestructure.dto.AnimalesOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animales")
public class Controller {

    @Autowired
    AnimalesService animalesService;


    @PostMapping
    public AnimalesOutputDto addAnimal(@RequestBody AnimalesInputDto animalesInputDto) {
            return animalesService.insertaAnimal(animalesInputDto);

    }

    @GetMapping("/getall")
    List<AnimalesOutputDto> dameTodos(){
        return animalesService.findAll();
    }
}

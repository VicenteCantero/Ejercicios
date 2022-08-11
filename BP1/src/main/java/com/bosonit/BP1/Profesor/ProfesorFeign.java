package com.bosonit.BP1.Profesor;

import com.bosonit.BP1.Profesor.infrastructure.controller.dto.ProfesorOutputDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="ProfesorFeign", url = "http://localhost:8080/profesor/")
public interface ProfesorFeign {
    @GetMapping("{id}")
    ProfesorOutputDto dameProfesorID(@PathVariable int id);
}

package com.bosonit.BS11;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/recarga")
    ResponseEntity<String> recargar(){
        return ResponseEntity.ok("Buenas!!!!!!!");
    }

}

package com.bosonit.LOGGING;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class controlador {
    Logger logger = LoggerFactory.getLogger(controlador.class);
/*
    @RequestMapping("/")
    public String index() {
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");

        return "Howdy! Check out the Logs to see the output...";
    }*/

    @GetMapping("/error")
    public void getError(){
        logger.error("Hola soy un log de error");
    }

    @GetMapping("/warn")
    public void getWarn(){
        logger.warn("Hola soy un log de warn, no me guardaré en el file error, saldré por consola");
    }

    @GetMapping("/info")
    public void getInfo(){
        logger.error("Hola soy un log de info");
    }
}

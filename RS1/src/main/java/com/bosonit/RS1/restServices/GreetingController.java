package com.bosonit.RS1.restServices;

import java.util.concurrent.atomic.AtomicLong;

import com.bosonit.RS1.model.Persona;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {
/*
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }*/


    @PostMapping("/greeting/post")
    Greeting dameGreeting (@RequestBody ObjectNode requestObject){
        Greeting greeting  =new Greeting(requestObject.get("id").asInt(), requestObject.get("content").asText());
        return greeting;
    }


    @GetMapping("/user/{id}")
    public int dameID(@PathVariable int id){

        return id;
    }


    @PutMapping("/post")
    public String g(@RequestParam (value= "var1") int var1, @RequestParam (value= "var2") String var2) {

        return "Value1:" + var1 + " Value2:" + var2;

    }
}

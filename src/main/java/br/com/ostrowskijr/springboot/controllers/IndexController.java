package br.com.ostrowskijr.springboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {
    
    @GetMapping()
    public String index() {
        return "Bem Vindo ao Mundo de Spring-Boot Framewordk!";
    }
}

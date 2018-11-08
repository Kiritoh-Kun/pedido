package com.kiritoh.pedidos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class categorias {
    @RequestMapping(method = RequestMethod.GET)
    public String categorias(){
        return "El proyecto esta corriendo";
    }
}

package com.kiritoh.pedidos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/root")
public class categorias {
    @GetMapping("/ListaCategoria")
    public String listaCategoria(){
        return "proximamente lista de categorias";
    }
}

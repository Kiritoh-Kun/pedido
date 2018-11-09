package com.kiritoh.pedidos.controller;

import com.kiritoh.pedidos.entity.entityCategoria;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/root")
public class ControllerCategrias {
    @GetMapping("/ListaCategoria")
    public List<entityCategoria> listaCategoria(){
        entityCategoria cat1=new entityCategoria("Informatica");
        entityCategoria cat2=new entityCategoria("Escritorio");

        List<entityCategoria> LC= new ArrayList<>();
        LC.add(cat1);
        LC.add(cat2);
        return LC;
    }
}

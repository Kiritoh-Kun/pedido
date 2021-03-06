package com.kiritoh.pedidos.controller;

import com.kiritoh.pedidos.entity.entityCategoria;
import com.kiritoh.pedidos.model.modelCategoria;
import com.kiritoh.pedidos.model.modelProductos;
import com.kiritoh.pedidos.servicios.servicePedido;
import com.sun.corba.se.spi.ior.ObjectKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/root")
public class ControllerCategrias {
    /*@GetMapping("/ListaCategoria")
    public List<entityCategoria> listaCategoria(){
        entityCategoria cat1=new entityCategoria("Informatica");
        entityCategoria cat2=new entityCategoria("Escritorio");
        List<entityCategoria> LC= new ArrayList<>();
        LC.add(cat1);
        LC.add(cat2);
        return LC;
    }
    */

    @Autowired
    @Qualifier("serviciosPedido")
    servicePedido sp;

   /* @PostMapping("/addCategoria")
    public modelCategoria add(@RequestBody entityCategoria categoria) {
        return sp.addCategoria(categoria);
    }*/

    @GetMapping("/showCategoria")
    public List<modelCategoria> showCategoria() {
        return sp.showCategoria();
    }

    @GetMapping("/findCategoriaById/{x}")
    public Object findCategoriaById(@PathVariable int x){
        modelCategoria categoriaRespuesta;
        categoriaRespuesta=sp.FindCategoriaById(x);
        /*if(categoriaRespuesta==null)
            return "esta categoria no existe";
        else{
            return  categoriaRespuesta;
            /*List<modelProductos> lista=categoriaRespuesta.getListaProductos();
            return lista;
        }*/
        return  categoriaRespuesta;
    }
}

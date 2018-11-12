package com.kiritoh.pedidos.servicios;

import com.kiritoh.pedidos.converter.converter;
import com.kiritoh.pedidos.entity.entityCategoria;
import com.kiritoh.pedidos.model.modelCategoria;
import com.kiritoh.pedidos.repositorio.repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service("serviciosPedido")
public class servicePedido implements CommandLineRunner {
    @Autowired
    @Qualifier("repositorioPedido")
    repositorio r;

    @Autowired
    @Qualifier("converter")
    converter converter;

    public modelCategoria addCategoria(entityCategoria categoria) {
        return new modelCategoria(r.save(categoria));
    }

    public List<modelCategoria> showCategoria() {
        return converter.ModelLista(r.findAll());
    }

    public modelCategoria FindCategoriaById(int id){
        entityCategoria categoriaAuxiliar=r.findById(id);
        if(categoriaAuxiliar==null)
            return null;
        else
            return new modelCategoria(categoriaAuxiliar);
    }

    @Override
    public void run(String... args) throws Exception {

        //agregar al inicio
        /*entityCategoria a=new entityCategoria("legumbres");
        entityCategoria b=new entityCategoria("flores");
        List<entityCategoria> list=new ArrayList<>();
        list.add(a);
        list.add(b);
        r.saveAll(list);*/
    }
}

package com.kiritoh.pedidos.converter;

import com.kiritoh.pedidos.entity.entityCategoria;
import com.kiritoh.pedidos.model.modelCategoria;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("converter")
public class converter {
    public List<modelCategoria> ModelLista(List<entityCategoria> categorias){
        List<modelCategoria> Mlista=new ArrayList<>();
        for( entityCategoria x : categorias){
            Mlista.add(new modelCategoria(x));
        }
        return Mlista;
    }
}

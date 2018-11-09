package com.kiritoh.pedidos.servicios;
import com.kiritoh.pedidos.converter.converter;
import com.kiritoh.pedidos.entity.entityCategoria;
import com.kiritoh.pedidos.model.modelCategoria;
import com.kiritoh.pedidos.repositorio.repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("serviciosPedido")
public class servicePedido {
    @Autowired
    @Qualifier("repositorioPedido")
    repositorio r;

    @Autowired
    @Qualifier("converter")
    converter converter;

    public modelCategoria addCategoria(entityCategoria categoria){
        return new modelCategoria(r.save(categoria));
    }

    public List<modelCategoria> showCategoria(){
        return converter.ModelLista(r.findAll());
    }


}

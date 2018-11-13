package com.kiritoh.pedidos.servicios;

import com.kiritoh.pedidos.converter.converter;
import com.kiritoh.pedidos.entity.entityCategoria;
import com.kiritoh.pedidos.entity.entityProducto;
import com.kiritoh.pedidos.exceptions.ObjetoNoEncontrado;
import com.kiritoh.pedidos.model.modelCategoria;
import com.kiritoh.pedidos.model.modelProductos;
import com.kiritoh.pedidos.repositorio.repositorio;
import com.kiritoh.pedidos.repositorio.repositoryProducto;
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
    repositorio rc;

    @Autowired
    @Qualifier("converter")
    converter converter;

    @Autowired
    @Qualifier("repositoryProducto")
    repositoryProducto rp;

    /*public modelCategoria addCategoria(entityCategoria categoria) {
        return new modelCategoria(rc.save(categoria));
    }*/

    public List<modelCategoria> showCategoria() {
        return converter.ModelLista(rc.findAll());
    }

    public modelCategoria FindCategoriaById(int id){
        entityCategoria categoriaAuxiliar=rc.findById(id);

        List<modelProductos> lm;
        try{
            if(categoriaAuxiliar==null){
                throw new ObjetoNoEncontrado("objeto no encontrado");
            }
            lm=converter.ModelListaP(categoriaAuxiliar.getProductos());
            return new modelCategoria(categoriaAuxiliar,lm);

        }catch (ObjetoNoEncontrado e){
            throw new ObjetoNoEncontrado("objeto no encontrado");
            //return new modelCategoria();
            //throw new ObjetoNoEncontrado(" Categoria no encontrada " + " ID_Categoria: "+ id + " Calse "+ entityCategoria.class.getName());
        }
            /*if(categoriaAuxiliar==null){
                throw new ObjetoNoEncontrado(" Categoria no encontrada " + " ID_Categoria: "+ id + " Calse "+ entityCategoria.class.getName());
            }else{
                lm=converter.ModelListaP(categoriaAuxiliar.getProductos());
                return new modelCategoria(categoriaAuxiliar,lm);
            }*/

    }

    @Override
    public void run(String... args) throws Exception {

        //agregar al inicio
        /*entityCategoria cat1=new entityCategoria("informatica");
        entityCategoria cat2=new entityCategoria("escritorio");
        entityProducto p1 = new entityProducto("cumpador",2000);
        entityProducto p2 = new entityProducto("impresora",800);
        entityProducto p3 = new entityProducto("mouse",80);
        cat1.getProductos().addAll(Arrays.asList(p1,p2,p3));
        cat2.getProductos().addAll(Arrays.asList(p2));
        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));
        rc.saveAll(Arrays.asList(cat1,cat2));
        rp.saveAll(Arrays.asList(p1,p2,p3));*/

    }
}

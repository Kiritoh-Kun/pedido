package com.kiritoh.pedidos.servicios;

import com.kiritoh.pedidos.converter.converter;
import com.kiritoh.pedidos.entity.entityCategoria;
import com.kiritoh.pedidos.entity.entityCiudades;
import com.kiritoh.pedidos.entity.entityEstado;
import com.kiritoh.pedidos.entity.entityProducto;
import com.kiritoh.pedidos.exceptions.ObjetoNoEncontrado;
import com.kiritoh.pedidos.model.modelCategoria;
import com.kiritoh.pedidos.model.modelProductos;
import com.kiritoh.pedidos.repositorio.repositorio;
import com.kiritoh.pedidos.repositorio.repositorioCiudades;

import com.kiritoh.pedidos.repositorio.repositorioEstado;
import com.kiritoh.pedidos.repositorio.repositoryProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;


@Service("serviciosPedido")
public class servicePedido implements CommandLineRunner {

    @Autowired
    @Qualifier("repositorioEstado")
    repositorioEstado resta;
    @Autowired
    @Qualifier("repositorioPedido")
    repositorio rc;

    @Autowired
    @Qualifier("converter")
    converter converter;

    @Autowired
    @Qualifier("repositoryProducto")
    repositoryProducto rp;

    @Autowired
    @Qualifier("repositorioCiudad")
    repositorioCiudades rciu;

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

        entityEstado est1 = new entityEstado( "Minas Gerais");
        entityEstado est2 = new entityEstado( "San Pablo");

        entityCiudades c1= new entityCiudades("Uberlandia",est1);
        entityCiudades c2= new entityCiudades("San Pablo",est2);
        entityCiudades c3= new entityCiudades("Campinas",est2);

        est1.getCiudades().add(c1);
        est2.getCiudades().addAll(Arrays.asList(c2,c3));

        resta.saveAll(Arrays.asList(est1,est2));
        rciu.saveAll(Arrays.asList(c1,c2,c3));

    }
}

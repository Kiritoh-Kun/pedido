package com.kiritoh.pedidos.servicios;

import com.kiritoh.pedidos.converter.converter;
import com.kiritoh.pedidos.entity.*;
import com.kiritoh.pedidos.enums.TipoCliente;
import com.kiritoh.pedidos.exceptions.ClienteNoEncontrado;
import com.kiritoh.pedidos.exceptions.ObjetoNoEncontrado;
import com.kiritoh.pedidos.model.modelCategoria;
import com.kiritoh.pedidos.model.modelCliente;
import com.kiritoh.pedidos.model.modelProductos;
import com.kiritoh.pedidos.repositorio.*;

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

    @Autowired
    @Qualifier("repositorioCliente")
    repositorioCliente rpc;

    @Autowired
    @Qualifier("repositorioDirecciones")
    repositorioDirecciones rpd;

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
    public modelCliente showClient(int c){
        entityCliente auxClient = rpc.findById(c);
        if(auxClient==null){
           throw new ClienteNoEncontrado("Cliente invalid " + " ID "+c);
        }else{
            return new modelCliente(rpc.findById(c), converter.direcciones(rpc.findById(c).getDirecciones()));
        }
        
    }

    @Override
    public void run(String... args) throws Exception {

        //agregar al inicio
        entityCategoria cat1=new entityCategoria("informatica");
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
        rp.saveAll(Arrays.asList(p1,p2,p3));

        entityEstado est1 = new entityEstado( "Minas Gerais");
        entityEstado est2 = new entityEstado( "San Pablo");

        entityCiudades c1= new entityCiudades("Uberlandia",est1);
        entityCiudades c2= new entityCiudades("San Pablo",est2);
        entityCiudades c3= new entityCiudades("Campinas",est2);

        est1.getCiudades().add(c1);
        est2.getCiudades().addAll(Arrays.asList(c2,c3));

        resta.saveAll(Arrays.asList(est1,est2));
        rciu.saveAll(Arrays.asList(c1,c2,c3));

        entityCliente cli1=new entityCliente ("Maira Silva","maira@gmail.com","36378912377", TipoCliente.PERSONAFISICA);
        cli1.getTelefonos().addAll(Arrays.asList("27363323","93838393"));
        entityDirecciones e1=new entityDirecciones("Rua Flores", 300,"Apto. 203","Jardim","38220834",cli1, c1);
        entityDirecciones e2=new entityDirecciones("Avenida Matos", 105,"Sala 800","Centro","38777012",cli1, c2);
        cli1.getDirecciones().addAll(Arrays.asList(e1,e2));
        rpc.save(cli1);
        rpd.saveAll(Arrays.asList(e1,e2));

    }
}

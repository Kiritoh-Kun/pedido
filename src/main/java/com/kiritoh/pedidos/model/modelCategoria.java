package com.kiritoh.pedidos.model;

import com.kiritoh.pedidos.converter.converter;
import com.kiritoh.pedidos.entity.entityCategoria;
import com.kiritoh.pedidos.entity.entityProducto;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

public class modelCategoria {

    public static final Log Log= LogFactory.getLog(modelCategoria.class);

    private int id;
    private String name;
    private List<modelProductos> listaProductos=new ArrayList<>();

    public List<modelProductos> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<modelProductos> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public modelCategoria(){}

    public modelCategoria(entityCategoria categoria){
        this.id=categoria.getId();
        this.name=categoria.getName();
    }

    public modelCategoria(entityCategoria categoria, List<modelProductos> lm){
        this.id=categoria.getId();
        this.name=categoria.getName();
        this.listaProductos=lm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public modelCategoria(String name) {
        this.name = name;
    }
}

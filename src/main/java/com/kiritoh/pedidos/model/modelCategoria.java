package com.kiritoh.pedidos.model;

import com.kiritoh.pedidos.entity.entityCategoria;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class modelCategoria {
    private int id;
    private String name;

    public modelCategoria(){}

    public modelCategoria(entityCategoria categoria){
        this.id=categoria.getId();
        this.name=categoria.getName();
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

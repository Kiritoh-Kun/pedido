package com.kiritoh.pedidos.model;

import com.kiritoh.pedidos.entity.entityCategoria;
import com.kiritoh.pedidos.entity.entityProducto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class modelProductos {
    private int id;
    private String name;
    private int price;

    public modelProductos(entityProducto entityProducto){
        this.id=entityProducto.getId();
        this.name=entityProducto.getName();
        this.price=entityProducto.getPrice();
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof modelProductos)) return false;
        modelProductos that = (modelProductos) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

package com.kiritoh.pedidos.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class entityProducto implements Serializable {
    @GeneratedValue
    @Id
    @Column(name ="id")
    private int id;

    @Column(name ="name")
    private String name;

    @Column(name = "price")
    private int price;

    @ManyToMany
    @JoinTable(
            name="producto_categoria",
            joinColumns = @JoinColumn( name ="producto_id"),
            inverseJoinColumns = @JoinColumn ( name = "categoria_id")
    )
    List<entityCategoria>  categorias =new ArrayList<>();

    public entityProducto(){

    }

    public List<entityCategoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<entityCategoria> categorias) {
        this.categorias = categorias;
    }

    public entityProducto(String name, int price) {
        this.name = name;
        this.price = price;
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
        if (!(o instanceof entityProducto)) return false;
        entityProducto that = (entityProducto) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

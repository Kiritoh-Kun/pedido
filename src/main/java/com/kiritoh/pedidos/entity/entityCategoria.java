package com.kiritoh.pedidos.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class entityCategoria implements Serializable {
    //private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;

    @Column(name ="name")
    private String name;

    @JsonManagedReference
    @ManyToMany(mappedBy = "categorias")
    private List<entityProducto> productos= new ArrayList<>();


    public entityCategoria(){}

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

    public entityCategoria(String name) {
        this.name = name;
    }

    public List<entityProducto> getProductos() {
        return productos;
    }

    public void setProductos(List<entityProducto> productos) {
        this.productos = productos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof entityCategoria)) return false;
        entityCategoria that = (entityCategoria) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

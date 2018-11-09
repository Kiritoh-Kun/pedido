package com.kiritoh.pedidos.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class entityCategoria implements Serializable {
    //private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;

    @Column(name ="name")
    private String name;


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
}

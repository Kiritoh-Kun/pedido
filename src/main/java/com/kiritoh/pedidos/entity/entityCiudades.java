package com.kiritoh.pedidos.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class entityCiudades implements Serializable {

    @Id
    @GeneratedValue
    @Column(name ="id")
    private int id;

    @Column(name ="name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private entityEstado estado;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof entityCiudades)) return false;
        entityCiudades that = (entityCiudades) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public entityCiudades(){}

    public entityCiudades(String name, entityEstado estado) {
        this.name = name;
        this.estado = estado;
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

    public entityEstado getEstado() {
        return estado;
    }

    public void setEstado(entityEstado estado) {
        this.estado = estado;
    }
}

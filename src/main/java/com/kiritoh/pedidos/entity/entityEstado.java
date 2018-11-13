package com.kiritoh.pedidos.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class entityEstado implements Serializable {

    @Id
    @GeneratedValue
    @Column(name ="id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "estado")
    private List<entityCiudades> ciudades = new ArrayList<>();

    public entityEstado(){}

    public entityEstado(String name) {
        this.name = name;
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

    public List<entityCiudades> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<entityCiudades> ciudades) {
        this.ciudades = ciudades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof entityEstado)) return false;
        entityEstado that = (entityEstado) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

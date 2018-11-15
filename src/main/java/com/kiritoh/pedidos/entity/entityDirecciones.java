package com.kiritoh.pedidos.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class entityDirecciones implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    private String calle;

    private int numero;

    private String complemento;

    private String barrio;

    private String cep;

    @ManyToOne
    @JoinColumn(name="cliente_id")
    private entityCliente cliente;

    @ManyToOne
    @JoinColumn(name="ciudad_id")
    private entityCiudades ciudad;

    public entityDirecciones (String calle, int numero, String complemento, String barrio, String cep, entityCliente cliente, entityCiudades ciudad) {
        this.calle = calle;
        this.numero = numero;
        this.complemento = complemento;
        this.barrio = barrio;
        this.cep = cep;
        this.cliente = cliente;
        this.ciudad= ciudad;
    }

    public entityCiudades getCiudad() {
        return ciudad;
    }

    public void setCiudad(entityCiudades ciudad) {
        this.ciudad = ciudad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public entityCliente getCliente() {
        return cliente;
    }

    public void setCliente(entityCliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof entityDirecciones)) return false;
        entityDirecciones that = (entityDirecciones) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

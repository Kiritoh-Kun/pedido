package com.kiritoh.pedidos.entity;

import com.kiritoh.pedidos.enums.TipoCliente;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class entityCliente implements Serializable {

    @Id
    @GeneratedValue()
    private int id;

    private String name;

    private String email;

    private String cpfOuCnpj;

    private Integer tipo;

    @OneToMany(mappedBy = "cliente")
    private List<entityDirecciones> direcciones = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name ="telefonos")
    private Set<String> telefonos = new HashSet<>();

    public entityCliente(String name, String email, String cpfOuCnpj, TipoCliente tipo) {
        this.name = name;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.tipo = tipo.getCodigo();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public TipoCliente getTipo() {
        return TipoCliente.toEnum(tipo);
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo.getCodigo();
    }

    public List<entityDirecciones> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<entityDirecciones> direcciones) {
        this.direcciones = direcciones;
    }

    public Set<String> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(Set<String> telefonos) {
        this.telefonos = telefonos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof entityCliente)) return false;
        entityCliente that = (entityCliente) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

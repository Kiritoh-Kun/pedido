package com.kiritoh.pedidos.repositorio;

import com.kiritoh.pedidos.entity.entityCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("repositorioPedido")
public interface repositorio extends JpaRepository<entityCategoria, Serializable> {
    public abstract entityCategoria findById(int id);

}

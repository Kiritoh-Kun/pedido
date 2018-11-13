package com.kiritoh.pedidos.repositorio;

import com.kiritoh.pedidos.entity.entityProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("repositoryProducto")
public interface repositoryProducto extends JpaRepository<entityProducto, Serializable> {

}

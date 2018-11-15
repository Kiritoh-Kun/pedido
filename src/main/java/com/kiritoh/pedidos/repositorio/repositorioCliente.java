package com.kiritoh.pedidos.repositorio;

import com.kiritoh.pedidos.entity.entityCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("repositorioCliente")
public interface repositorioCliente extends JpaRepository<entityCliente, Serializable> {
}

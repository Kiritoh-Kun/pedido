package com.kiritoh.pedidos.repositorio;

import com.kiritoh.pedidos.entity.entityEstado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("repositorioEstado")
public interface repositorioEstado extends JpaRepository<entityEstado, Serializable> {
}

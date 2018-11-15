package com.kiritoh.pedidos.repositorio;

import com.kiritoh.pedidos.entity.entityDirecciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("repositorioDirecciones")
public interface repositorioDirecciones extends JpaRepository<entityDirecciones, Serializable> {
}

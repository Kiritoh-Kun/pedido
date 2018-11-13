package com.kiritoh.pedidos.repositorio;

import com.kiritoh.pedidos.entity.entityCiudades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("repositorioCiudad")
public interface repositorioCiudades extends JpaRepository<entityCiudades, Serializable> {
}

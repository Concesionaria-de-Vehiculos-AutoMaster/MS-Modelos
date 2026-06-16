package com.automaster.msmodelo.repository;

import com.automaster.msmodelo.model.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {

    // Query Method para buscar todos los modelos de una marca específica
    List<Modelo> findByMarcaIgnoreCase(String marca);

    // Query Method para buscar por tipo de combustible
    List<Modelo> findByTipoCombustibleIgnoreCase(String tipoCombustible);
}
package com.proyecto.solicitud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.solicitud.model.Ejecutivo;

@Repository
public interface EjecutivoRepository extends JpaRepository<Ejecutivo, Integer>
{
    List<Ejecutivo> findAll();

    @SuppressWarnings({ "unchecked", "null" })
    Ejecutivo save (Ejecutivo ejecutivo);

    Ejecutivo getReferenceById(int id);
    Ejecutivo getByName(String nombre);
}

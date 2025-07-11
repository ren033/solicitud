package com.proyecto.solicitud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.solicitud.model.Solicitud;

@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud, Integer>
{
    //List<Solicitud> findAll();

    //@SuppressWarnings({ "unchecked", "null" })
    //Solicitud save (Solicitud solicitud);

    Optional<Solicitud> findById(int id);
    List<Solicitud> findByClienteId(Integer idCliente);
}

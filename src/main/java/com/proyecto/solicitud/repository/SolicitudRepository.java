package com.proyecto.solicitud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.solicitud.model.Solicitud;

@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud, Integer>
{
    //List<Solicitud> findAll();

    //@SuppressWarnings({ "unchecked", "null" })
    //Solicitud save (Solicitud solicitud);

    Solicitud getReferenceById(int id);
}

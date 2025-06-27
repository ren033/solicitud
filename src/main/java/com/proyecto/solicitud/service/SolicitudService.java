package com.proyecto.solicitud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.solicitud.model.Solicitud;
import com.proyecto.solicitud.repository.SolicitudRepository;

@Service
public class SolicitudService
{
    @Autowired
    private SolicitudRepository solicitudRepository;

    public List<Solicitud> listSolicitudes(){
        return solicitudRepository.findAll();
    }

    public Solicitud save(Solicitud solicitud){
        return solicitudRepository.save(solicitud);
    }

    public Optional<Solicitud> findById(int id){
        return solicitudRepository.findById(id);
    }

    public List<Solicitud> findByClienteId(int idCliente) {
        return solicitudRepository.findByClienteId(idCliente);
    }

    public Solicitud deleteById(int id){
        return solicitudRepository.getReferenceById(id);
    }
}



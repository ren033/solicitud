package com.proyecto.solicitud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.solicitud.model.Ejecutivo;
import com.proyecto.solicitud.repository.EjecutivoRepository;

@Service
public class EjecutivoService
{
    @Autowired
    private EjecutivoRepository ejecutivoRepository;

    public List<Ejecutivo> listEjecutivos(){
        return ejecutivoRepository.findAll();
    }

    public Ejecutivo save(Ejecutivo ejecutivo){
        return ejecutivoRepository.save(ejecutivo);
    }

    public Ejecutivo updateById(int id){
        return ejecutivoRepository.getReferenceById(id);
    }

    public Ejecutivo findById(int id){
        return ejecutivoRepository.getReferenceById(id);
    }

    public Ejecutivo findByName(String nombre){
        return ejecutivoRepository.getByName(nombre);
    }

    public Ejecutivo deleteById(int id){
        return ejecutivoRepository.getReferenceById(id);
    }
}


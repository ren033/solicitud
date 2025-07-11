package com.proyecto.solicitud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.proyecto.solicitud.model.Solicitud;
import com.proyecto.solicitud.model.UsuarioDTO;
import com.proyecto.solicitud.repository.SolicitudRepository;

@Service
public class SolicitudService
{
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private SolicitudRepository solicitudRepository;

    public UsuarioDTO getUsuarioById(Integer id) {
        String url = "http://localhost:8083/api/usuario/" + id;
        return restTemplate.getForObject(url, UsuarioDTO.class);
    }

    public Solicitud create(Solicitud resupply) {
        RestTemplate restTemplate = new RestTemplate();
        
        String url = "http://localhost:8083/api/usuario/" + resupply.getIdCliente();
        UsuarioDTO cliente = restTemplate.getForObject(url, UsuarioDTO.class);
        
        if (cliente == null) {
            throw new RuntimeException("Cliente no encontrado con ID: " + resupply.getIdCliente());
        }

            resupply.setIdCliente(cliente.getId());
            resupply.setNombreCliente(cliente.getNombre());

            return solicitudRepository.save(resupply);
    }

    public List<Solicitud> listSolicitudes(){
        return solicitudRepository.findAll();
    }

    public Solicitud save(Solicitud solicitud){
        return solicitudRepository.save(solicitud);
    }

    public Optional<Solicitud> findById(int id){
        return solicitudRepository.findById(id);
    }

    public void deleteById(int id) {
        solicitudRepository.deleteById(id);
    }

    public Solicitud update(Solicitud solicitud){
        return solicitudRepository.save(solicitud);
    }

}



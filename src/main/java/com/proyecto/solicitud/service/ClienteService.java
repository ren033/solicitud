package com.proyecto.solicitud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.solicitud.model.Cliente;
import com.proyecto.solicitud.repository.ClienteRepository;

@Service
public class ClienteService
{
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listClientes(){
        return clienteRepository.findAll();
    }

    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> updateById(int id) {
    return clienteRepository.findById(id);
    }

    public Optional<Cliente> findById(int id) {
        return clienteRepository.findById(id);
    }

    public Optional<Cliente> findByName(String nombre){
        return clienteRepository.getReferenceByName(nombre);
    }

    public Optional<Cliente> deleteById(int id){
        return clienteRepository.findById(id);
    }
}


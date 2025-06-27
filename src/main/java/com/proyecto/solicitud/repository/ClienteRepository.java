package com.proyecto.solicitud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.solicitud.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>
{
    List<Cliente> FindAll();

    //@SuppressWarnings({"unchecked", "null"})
    //Cliente save (Cliente cliente);

    Optional<Cliente> getReferenceById(int id);
    Optional<Cliente> getReferenceByName(String nombre);
}

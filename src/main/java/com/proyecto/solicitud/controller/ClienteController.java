package com.proyecto.solicitud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proyecto.solicitud.model.Cliente;
import com.proyecto.solicitud.service.ClienteService;

@RestController
@RequestMapping("api/cliente")
public class ClienteController
{
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping
    public ResponseEntity<List<Cliente>> getAll()
    {
        List<Cliente> clientes = clienteService.listClientes();
        if (!clientes.isEmpty()) {
            return new ResponseEntity<>(clientes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/id")
    public ResponseEntity<Cliente> getById(@PathVariable int id){
        return new ResponseEntity<Cliente>(clienteService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/cliente")
    public ResponseEntity<Cliente> getByName(@PathVariable String nombre){
        return new ResponseEntity<Cliente>(clienteService.findByName(nombre), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity <Cliente> postCliente(@RequestBody Cliente cliente)
    {
        Cliente search = clienteService.findById(cliente.getId());
        if (search == null) {
            return new ResponseEntity<>(clienteService.save(cliente), HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/id")
    public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente, @PathVariable int id)
    {
        List<Cliente> updateCliente = clienteService.listClientes();
        if (!updateCliente.isEmpty())
            return ResponseEntity.notFound().build();
            cliente.setId(id);
            clienteService.save(cliente);
            return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/id")
    public void deleteCliente(@PathVariable int id){
        clienteService.deleteById(id);
    }
}

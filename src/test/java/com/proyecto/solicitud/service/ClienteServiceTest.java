package com.proyecto.solicitud.service;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.proyecto.solicitud.model.Cliente;
import com.proyecto.solicitud.repository.ClienteRepository;

class ClienteServiceTest
{
    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveCliente() {
        Cliente cliente = new Cliente();
        Cliente clienteSaved = new Cliente();
        
        when(clienteRepository.save(cliente)).thenReturn(clienteSaved);

        Cliente resultado = clienteService.save(cliente);
        assertThat(resultado.getId()).isEqualTo(1);
        assertThat(resultado.getNombre()).isEqualTo("");
        verify(clienteRepository).save(cliente);
    }

    @Test
    void testListClientes() {
        Cliente c1 = new Cliente();
        Cliente c2 = new Cliente();
        Cliente c3 = new Cliente();

        when(clienteRepository.findAll()).thenReturn(Arrays.asList(c1, c2, c3));

        List<Cliente> resultado = clienteService.listClientes();
        assertThat(resultado).hasSize(3).contains(c1, c2, c3);
        verify(clienteRepository).findAll();
    }
}

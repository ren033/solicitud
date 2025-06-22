package com.proyecto.solicitud.service;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
    public void testSaveCliente() {
        Cliente cliente = new Cliente(1, "pass", "usercarlos",
            "Carlos","carlos@gmail.com", "Calle 23", true);

        when(clienteRepository.save(cliente)).thenReturn(cliente);
        Cliente saved = clienteService.save(cliente);

        assertNotNull(saved);
        assertEquals(1, saved.getId());
        assertEquals("Carlos", saved.getNombre());
    }

    @Test
    void testListClientes() {
        Cliente c1 = new Cliente(1, "pass", "usercarlos", "Carlos", "carlos@gmail.com", "Calle 23", true);
        Cliente c2 = new Cliente(2, "passw0rd", "anonimo", "Antonio", "anon@gmail.com", "Edificio A2", true);
        Cliente c3 = new Cliente(3, "321", "marii", "Mari", "marimail@email.com", "Dpto 10", false);

        when(clienteRepository.findAll()).thenReturn(Arrays.asList(c1, c2, c3));

        List<Cliente> resultado = clienteService.listClientes();
        assertThat(resultado).hasSize(3).contains(c1, c2, c3);
        verify(clienteRepository).findAll();
    }
}

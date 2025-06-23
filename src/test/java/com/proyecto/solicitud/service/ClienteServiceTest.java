package com.proyecto.solicitud.service;

//import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
//import java.util.Optional;

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
/*
    @Test
void testFindById() {
    int id = 1;

    Cliente c1 = new Cliente();
    c1.setId(id);
    c1.setPassword("pass");
    c1.setUsername("usercarlos");
    c1.setNombre("Carlos");
    c1.setCorreo("carlos@gmail.com");
    c1.setDireccion("Calle 23");
    c1.setEstado(true);

    when(clienteRepository.findById(id)).thenReturn(Optional.of(c1));

    Cliente resultado = clienteService.findById(id);

    assertNotNull(resultado);
    assertEquals(id, resultado.getId());
    assertEquals("pass", resultado.getPassword());
    assertEquals("usercarlos", resultado.getUsername());
    assertEquals("Carlos", resultado.getNombre());
    assertEquals("carlos@gmail.com", resultado.getCorreo());

    verify(clienteRepository).findById(id);
}

    @Test
    void testUpdateById() {
        int id = 1;

        Cliente existingCliente = new Cliente();
        existingCliente.setId(id);
        existingCliente.setNombre("Juan");

        Cliente updatedData = new Cliente();
        updatedData.setNombre("Carlos");

        Cliente updatedCliente = new Cliente();
        updatedCliente.setId(id);
        updatedCliente.setNombre("Carlos");

        when(clienteRepository.findById(id)).thenReturn(Optional.of(existingCliente));
        when(clienteRepository.save(any(Cliente.class))).thenReturn(updatedCliente);

        Cliente resultado = clienteService.updateById(id);

        assertNotNull(resultado);
        assertThat(resultado.getNombre()).isEqualTo("Carlos");

        verify(clienteRepository).findById(id);
        verify(clienteRepository).save(any(Cliente.class));
    }
*/
}

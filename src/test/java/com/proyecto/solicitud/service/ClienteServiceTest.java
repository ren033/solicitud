package com.proyecto.solicitud.service;

//import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
            "Carlos","carlos@email.com", "Calle 23", true);

        when(clienteRepository.save(cliente)).thenReturn(cliente);
        Cliente saved = clienteService.save(cliente);

        assertNotNull(saved);
        assertEquals(1, saved.getId());
        assertEquals("Carlos", saved.getNombre());
    }

    @Test
    void testListClientes() {
        Cliente c1 = new Cliente(1, "pass", "usercarlos", "Carlos", "carlos@email.com", "Calle 23", true);
        Cliente c2 = new Cliente(2, "passw0rd", "anonimo", "Antonio", "anon@email.com", "Edificio A2", true);
        Cliente c3 = new Cliente(3, "321", "marii", "Mari", "marimail@email.com", "Dpto 10", false);

        when(clienteRepository.findAll()).thenReturn(Arrays.asList(c1, c2, c3));

        List<Cliente> response = clienteService.listClientes();
        assertThat(response).hasSize(3).contains(c1, c2, c3);
        verify(clienteRepository).findAll();
    }

    @Test
    public void testUpdate() {
        int id = 1;
        Cliente c1 = new Cliente();
        c1.setId(id);
        c1.setPassword("pass");
        c1.setUsername("usercarlos");
        c1.setNombre("Carlos");
        c1.setCorreo("carlos@email.com");
        c1.setDireccion("Calle 23");
        c1.setEstado(true);

        when(clienteRepository.findById(id)).thenReturn(Optional.of(c1));

        Optional<Cliente> response = clienteService.updateById(id);

        assertThat(response).isPresent();
        assertThat(response.get().getNombre()).isEqualTo("Carlos");
        verify(clienteRepository, times(1)).findById(id);
    }

    @Test
    public void testFindById() {
        int id = 2;
        Cliente c2 = new Cliente(id, "passw0rd", "anonimo", "Antonio", "anon@email.com", "Edificio A2", true);
        when(clienteRepository.findById(id)).thenReturn(Optional.of(c2));

        Optional<Cliente> response = clienteService.findById(id);
        assertTrue(response.isPresent());
        assertEquals(c2, response.get());
    }

    @Test
    public void testFindByName() {
        String nombre = "Antonio";
        Cliente c2 = new Cliente(2, "passw0rd", "anonimo", nombre, "anon@email.com", "Edificio A2", true);
        when(clienteRepository.getReferenceByName(nombre)).thenReturn(Optional.of(c2));

        Optional<Cliente> response = clienteService.findByName(nombre);

        assertTrue(response.isPresent());
        assertEquals(c2, response.get());
    }

    @Test
    public void testDeleteById() {
        int id = 3;
        Cliente c3 = new Cliente(id, "321", "marii", "Mari", "marimail@email.com", "Dpto 10", false);
        when(clienteRepository.findById(id)).thenReturn(Optional.of(c3));

        Optional<Cliente> response = clienteService.deleteById(id);

        verify(clienteRepository).deleteById(id);
        assertTrue(response.isPresent());
        assertEquals(c3, response.get());
    }
}

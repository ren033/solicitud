package com.proyecto.solicitud.service;

//import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
//import java.util.Optional;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;

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
    public void testUpdate_Exists() {
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

        // Act
        Optional<Cliente> response = clienteService.updateById(id);

        // Assert
        assertThat(response).isPresent();
        assertThat(response.get().getNombre()).isEqualTo("Carlos");
        verify(clienteRepository, times(1)).findById(id);
    }

    @Test
    public void testUpdate_NotExists() {
        int id = 1;
        when(clienteRepository.findById(id)).thenReturn(Optional.empty());

        Optional<Cliente> response = clienteService.updateById(id);

        assertThat(response).isEmpty();
        verify(clienteRepository, times(1)).findById(id);
    }
}

package com.proyecto.solicitud.service;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.proyecto.solicitud.model.Cliente;
import com.proyecto.solicitud.model.Solicitud;
import com.proyecto.solicitud.repository.SolicitudRepository;

class SolicitudServiceTest
{
    @Mock
    private SolicitudRepository solicitudRepository;

    @InjectMocks
    private SolicitudService solicitudService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListSolicitudes() {
        Cliente c1 = new Cliente(1, "pass", "usercarlos", "Carlos", "carlos@email.com", "Calle 23", true);
        Cliente c2 = new Cliente(2, "passw0rd", "anonimo", "Antonio", "anon@email.com", "Edificio A2", true);
        Solicitud sol1 = new Solicitud(1, "Tipo Solicitud", "Descripcion Solicitud", true, c2);
        Solicitud sol2 = new Solicitud(2, "Tipo Solicitud", "Descripcion Solicitud", false, c2);
        Solicitud sol3 = new Solicitud(2, "Tipo Solicitud", "Descripcion Solicitud", true, c1);
        List<Solicitud> solicitudes = Arrays.asList(sol1, sol2, sol3);
        when(solicitudRepository.findAll()).thenReturn(solicitudes);

        List<Solicitud> response = solicitudService.listSolicitudes();

        assertNotNull(response);
        assertEquals(3, response.size());
        assertEquals(solicitudes, response);
    }

    @Test
    public void testSaveSolicitud() {
        Solicitud solicitud = createSolicitud();
        when(solicitudRepository.save(solicitud)).thenReturn(solicitud);

        Solicitud saved = solicitudService.save(solicitud);
        assertNotNull(saved);
        assertEquals(1, saved.getId());
    }


    private Solicitud createSolicitud() {
        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setPassword("pass");
        cliente.setUsername("usercarlos");
        cliente.setNombre("Carlos");
        cliente.setCorreo("carlos@gmail.com");
        cliente.setDireccion("Calle 23");
        cliente.setEstado(true);

        Solicitud solicitud = new Solicitud();
        solicitud.setId(1);
        solicitud.setTipo("Tipo Solicitud");
        solicitud.setDescripcion("Descripcion Solicitud");
        solicitud.setEstado(true);

        return solicitud;
    }

    @Test
    public void testFindByClienteId() {
        int idCliente = 2;
        Cliente c2 = new Cliente();  // Mock Cliente
        Solicitud sol1 = new Solicitud(1, "Tipo Solicitud", "Descripcion Solicitud", true, c2);
        Solicitud sol2 = new Solicitud(2, "Tipo Solicitud", "Descripcion Solicitud", false, c2);
        List<Solicitud> solicitudes = Arrays.asList(sol1, sol2);
        when(solicitudRepository.findByClienteId(idCliente)).thenReturn(solicitudes);

        List<Solicitud> response = solicitudService.findByClienteId(idCliente);

        assertNotNull(response);
        assertEquals(2, response.size());
        assertEquals(solicitudes, response);
    }
}

package com.proyecto.solicitud.service;

import static org.mockito.Mockito.*;

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
}

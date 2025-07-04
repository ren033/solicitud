package com.proyecto.solicitud.service;

import static org.mockito.Mockito.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.proyecto.solicitud.enums.EstadoSol;
import com.proyecto.solicitud.enums.TipoSol;
import com.proyecto.solicitud.model.Solicitud;
import com.proyecto.solicitud.repository.SolicitudRepository;

class SolicitudServiceTest
{
    @Mock
    private SolicitudRepository solicitudRepository;

    @InjectMocks
    private SolicitudService solicitudService;

    private Solicitud sol1;
    private Solicitud sol2;

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

        Solicitud solicitud = new Solicitud();
        solicitud.setId(1);
        solicitud.setTipoSol(TipoSol.ASISTENCIA);
        solicitud.setDescripcion("Descripcion Solicitud");
        solicitud.setEstadoSol(EstadoSol.PENDIENTE);

        return solicitud;
    }

    @Test
    public void testFindById() {
        int id = 1;
        Solicitud sol1 = new Solicitud();
        when(solicitudRepository.findById(id)).thenReturn(Optional.of(sol1));

        Optional<Solicitud> response = solicitudService.findById(id);
        assertTrue(response.isPresent());
        assertEquals(sol1, response.get());
    }
}

package com.proyecto.solicitud.service;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
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
        solicitud.setDescripcion("Solicitud de prueba 1");
        solicitud.setEstadoSol(EstadoSol.PENDIENTE);

        return solicitud;
    }

    @Test
    void testListSolicitudes() {
        Solicitud sol1 = new Solicitud();
        sol1.setId(1);
        sol1.setTipoSol(TipoSol.ASISTENCIA);
        sol1.setDescripcion("Solicitud de prueba 1");
        sol1.setEstadoSol(EstadoSol.PENDIENTE);

        Solicitud sol2 = new Solicitud();
        sol2.setId(2);
        sol2.setTipoSol(TipoSol.CONSULTA);
        sol2.setDescripcion("Solicitud de prueba 2");
        sol2.setEstadoSol(EstadoSol.AUTORIZADA);

        List<Solicitud> mockSolicitudes = Arrays.asList(sol1, sol2);
        when(solicitudRepository.findAll()).thenReturn(mockSolicitudes);

        List<Solicitud> result = solicitudService.listSolicitudes();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(solicitudRepository, times(1)).findAll();
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

    @Test
    void testDeleteById() {
        int id = 1;
        solicitudService.deleteById(id);

        verify(solicitudRepository, times(1)).deleteById(id);
    }
}

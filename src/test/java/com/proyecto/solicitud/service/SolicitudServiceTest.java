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
    void testSaveSolicitud() {
        Solicitud solicitud = new Solicitud();
        Solicitud solicitudSaved = new Solicitud();
        
        when(solicitudRepository.save(solicitud)).thenReturn(solicitudSaved);

        Solicitud resultado = solicitudService.save(solicitud);
        assertThat(resultado.getId()).isEqualTo(1);
        verify(solicitudRepository).save(solicitud);
    }

    @Test
    void testListClientes() {
        Solicitud s1 = new Solicitud();
        Solicitud s2 = new Solicitud();

        when(solicitudRepository.findAll()).thenReturn(Arrays.asList(s1, s2));

        List<Solicitud> resultado = solicitudService.listSolicitudes();
        assertThat(resultado).hasSize(2).contains(s1, s2);
        verify(solicitudRepository).findAll();
    }
}

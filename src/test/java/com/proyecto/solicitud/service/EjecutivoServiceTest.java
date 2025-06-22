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

import com.proyecto.solicitud.model.Ejecutivo;
import com.proyecto.solicitud.repository.EjecutivoRepository;

class EjecutivoServiceTest
{
    @Mock
    private EjecutivoRepository ejecutivoRepository;

    @InjectMocks
    private EjecutivoService ejecutivoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveEjecutivo() {
        Ejecutivo ejecutivo = new Ejecutivo(1, "543", "Juan", "juan43@gmail.com", "Dpto 08", true);

        when(ejecutivoRepository.save(ejecutivo)).thenReturn(ejecutivo);
        Ejecutivo saved = ejecutivoService.save(ejecutivo);

        assertNotNull(saved);
        assertEquals(1, saved.getId());
        assertEquals("Juan", saved.getNombre());
    }

    @Test
    void testListEjecutivo() {
        Ejecutivo e1 = new Ejecutivo(1, "543", "Juan", "juan43@gmail.com", "Dpto 08", true);
        Ejecutivo e2 = new Ejecutivo(2, "098", "Jose", "jj@gmail.com", "Calle 9", true);

        when(ejecutivoRepository.findAll()).thenReturn(Arrays.asList(e1, e2));

        List<Ejecutivo> resultado = ejecutivoService.listEjecutivos();
        assertThat(resultado).hasSize(2).contains(e1, e2);
        verify(ejecutivoRepository).findAll();
    }
}

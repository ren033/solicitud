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
    void testSaveEjecutivo() {
        Ejecutivo ejecutivo = new Ejecutivo();
        Ejecutivo ejecutivoSaved = new Ejecutivo();
        
        when(ejecutivoRepository.save(ejecutivo)).thenReturn(ejecutivoSaved);

        Ejecutivo resultado = ejecutivoService.save(ejecutivo);
        assertThat(resultado.getId()).isEqualTo(1);
        assertThat(resultado.getNombre()).isEqualTo("");
        verify(ejecutivoRepository).save(ejecutivo);
    }

    @Test
    void testListClientes() {
        Ejecutivo e1 = new Ejecutivo();
        Ejecutivo e2 = new Ejecutivo();

        when(ejecutivoRepository.findAll()).thenReturn(Arrays.asList(e1, e2));

        List<Ejecutivo> resultado = ejecutivoService.listEjecutivos();
        assertThat(resultado).hasSize(2).contains(e1, e2);
        verify(ejecutivoRepository).findAll();
    }
}

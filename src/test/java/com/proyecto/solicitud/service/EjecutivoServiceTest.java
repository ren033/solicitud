package com.proyecto.solicitud.service;

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
        Ejecutivo e1 = new Ejecutivo(1, "543", "Juan", "juan43@email.com", "Dpto 08", true);
        Ejecutivo e2 = new Ejecutivo(2, "098", "Jose", "jj@email.com", "Calle 9", true);

        when(ejecutivoRepository.findAll()).thenReturn(Arrays.asList(e1, e2));

        List<Ejecutivo> resultado = ejecutivoService.listEjecutivos();
        assertThat(resultado).hasSize(2).contains(e1, e2);
        verify(ejecutivoRepository).findAll();
    }

    @Test
    public void testUpdate() {
        int id = 1;
        Ejecutivo e1 = new Ejecutivo();
        e1.setId(id);
        e1.setPassword("543");
        e1.setNombre("Juan");
        e1.setCorreo("juan43@email.com");
        e1.setDireccion("Dpto 08");
        e1.setEstado(true);

        when(ejecutivoRepository.findById(id)).thenReturn(Optional.of(e1));

        Optional<Ejecutivo> response = ejecutivoService.updateById(id);

        assertThat(response).isPresent();
        assertThat(response.get().getNombre()).isEqualTo("Juan");
        verify(ejecutivoRepository, times(1)).findById(id);
    }

    @Test
    public void testFindById() {
        int id = 2;
        Ejecutivo e2 = new Ejecutivo(id, "098", "Jose", "jj@email.com", "Calle 9", true);
        when(ejecutivoRepository.findById(id)).thenReturn(Optional.of(e2));

        Optional<Ejecutivo> response = ejecutivoService.findById(id);
        assertTrue(response.isPresent());
        assertEquals(e2, response.get());
    }

    @Test
    public void testFindByName() {
        String nombre = "Jose";
        Ejecutivo e2= new Ejecutivo(2, "098", nombre, "jj@email.com", "Calle 9", true);
        when(ejecutivoRepository.getReferenceByName(nombre)).thenReturn(Optional.of(e2));

        Optional<Ejecutivo> response = ejecutivoService.findByName(nombre);

        assertTrue(response.isPresent());
        assertEquals(e2, response.get());
    }

    @Test
    public void testDeleteById() {
        int id = 2;
        Ejecutivo e2 = new Ejecutivo(id,"098", "Jose", "jj@email.com", "Calle 9", true);
        when(ejecutivoRepository.findById(id)).thenReturn(Optional.of(e2));

        Optional<Ejecutivo> response = ejecutivoService.deleteById(id);

        verify(ejecutivoRepository).deleteById(id);
        assertTrue(response.isPresent());
        assertEquals(e2, response.get());
    }
}

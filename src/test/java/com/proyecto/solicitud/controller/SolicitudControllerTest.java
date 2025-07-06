package com.proyecto.solicitud.controller;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.solicitud.enums.EstadoSol;
import com.proyecto.solicitud.enums.TipoSol;
import com.proyecto.solicitud.model.Solicitud;
import com.proyecto.solicitud.model.UsuarioDTO;
import com.proyecto.solicitud.service.SolicitudService;

@WebMvcTest(SolicitudController.class)

public class SolicitudControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @SuppressWarnings("removal")
    @MockBean
    private SolicitudService solicitudService;

    @Autowired
    private ObjectMapper objectMapper;

    private Solicitud sol;
    private Solicitud sol2;
    private UsuarioDTO cliente;

    @BeforeEach
    void setup() {
        sol.setId(1);
        sol.setTipoSol(TipoSol.ASISTENCIA);
        sol.setDescripcion("Solicitud de prueba");
        sol.setEstadoSol(EstadoSol.PENDIENTE);

        sol2.setId(2);
        sol2.setTipoSol(TipoSol.CONSULTA);
        sol2.setDescripcion("Solicitud de prueba 2");
        sol2.setEstadoSol(EstadoSol.AUTORIZADA);

        cliente.setId(1);
        cliente.setNombre("Cliente test");
    }

    @Test
    void listSolicitud() throws Exception {
        when(solicitudService.listSolicitudes()).thenReturn(Arrays.asList(sol));

        mockMvc.perform(get("/api/Solicitud/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(sol.getId()))
                .andExpect(jsonPath("$[1].id").value(sol2.getId()));
    }

    @Test
    void createSolicitud() throws Exception {
        when(solicitudService.getUsuarioById(1)).thenReturn(cliente);
        when(solicitudService.create(any())).thenReturn(sol);

        mockMvc.perform(post("/api/Solicitud/create/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(sol)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(sol.getId()));
    }
}

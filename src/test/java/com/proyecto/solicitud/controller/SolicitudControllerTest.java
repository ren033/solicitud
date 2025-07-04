package com.proyecto.solicitud.controller;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.solicitud.model.Solicitud;
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

    private Solicitud solicitud;

    @BeforeEach
    void setup() {
        
    }
}

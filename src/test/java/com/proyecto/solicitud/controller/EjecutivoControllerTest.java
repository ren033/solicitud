package com.proyecto.solicitud.controller;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.solicitud.model.Ejecutivo;
import com.proyecto.solicitud.service.EjecutivoService;

@WebMvcTest(EjecutivoController.class)
public class EjecutivoControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @SuppressWarnings("removal")
    @MockBean
    private EjecutivoService ejecutivoService;

    @Autowired
    private ObjectMapper objectMapper;

    private Ejecutivo ejecutivo;

    @BeforeEach
    void setUp() {
        Ejecutivo e1 = new Ejecutivo();
        e1.setId(1);
        e1.setPassword("543");
        e1.setNombre("Juan");
        e1.setCorreo("juan43@email.com");
        e1.setDireccion("Dpto 08");
        e1.setEstado(true);
    }
}

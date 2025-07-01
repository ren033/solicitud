package com.proyecto.solicitud.controller;

import com.proyecto.solicitud.model.Cliente;
import com.proyecto.solicitud.service.ClienteService;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(ClienteController.class)
public class ClienteControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @SuppressWarnings("removal")
    @MockBean
    private ClienteService clienteService;

    @Autowired
    private ObjectMapper objectMapper;

    private Cliente cliente;

    @BeforeEach
    void setUp(){
        Cliente c1 = new Cliente();
        c1.setId(1);
        c1.setPassword("pass");
        c1.setUsername("usercarlos");
        c1.setNombre("Carlos");
        c1.setCorreo("carlos@email.com");
        c1.setDireccion("Calle 23");
        c1.setEstado(true);
    }
}

/* 
package com.proyecto.solicitud.controller;

import com.proyecto.solicitud.model.Cliente;
import com.proyecto.solicitud.service.ClienteService;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

    private Optional<Cliente> cliente;

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

    @Test
    public void testListClientes() throws Exception {
        when(clienteService.listClientes()).thenReturn(List.of(cliente));
        
        mockMvc.perform(get("/api/Cliente"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].username").value("usercarlos"))
                .andExpect(jsonPath("$[0].nombre").value("Carlos"));
    }

    @Test
    public void testFindById() throws Exception {
        when(clienteService.findById(1)).thenReturn(cliente);

        mockMvc.perform(get("/api/Cliente/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.password").value("pass"))
                .andExpect(jsonPath("$.username").value("usercarlos"));
    }
}
*/
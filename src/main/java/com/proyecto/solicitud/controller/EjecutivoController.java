package com.proyecto.solicitud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proyecto.solicitud.model.Ejecutivo;
import com.proyecto.solicitud.service.EjecutivoService;

@RestController
@RequestMapping("api/ejecutivo")
public class EjecutivoController
{
    @Autowired
    private EjecutivoService ejecutivoService;

    @GetMapping
    public ResponseEntity<List<Ejecutivo>> getAll()
    {
        List<Ejecutivo> ejecutivos = ejecutivoService.listEjecutivos();
        if (!ejecutivos.isEmpty()) {
            return new ResponseEntity<>(ejecutivos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}

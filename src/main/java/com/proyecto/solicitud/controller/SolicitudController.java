package com.proyecto.solicitud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.proyecto.solicitud.model.Solicitud;
import com.proyecto.solicitud.service.SolicitudService;

@RestController
@RequestMapping("api/solicitud")
public class SolicitudController
{
    @Autowired
    private SolicitudService solicitudService;

    @GetMapping
    public ResponseEntity<List<Solicitud>> getAll()
    {
        List<Solicitud> solicitudes = solicitudService.listSolicitudes();
        if (!solicitudes.isEmpty()) {
            return new ResponseEntity<>(solicitudes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}

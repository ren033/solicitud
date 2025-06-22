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

    @GetMapping("/id")
    public ResponseEntity<Solicitud> getById(@PathVariable int id){
        return new ResponseEntity<Solicitud>(solicitudService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity <Solicitud> postSolicitud(@RequestBody Solicitud solicitud)
    {
        Solicitud search = solicitudService.findById(solicitud.getId());
        if (search == null) {
            return new ResponseEntity<>(solicitudService.save(solicitud), HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/id")
    public ResponseEntity<Solicitud> updateSolicitud(@RequestBody Solicitud solicitud, @PathVariable int id)
    {
        List<Solicitud> updateSolicitud = solicitudService.listSolicitudes();
        if (!updateSolicitud.isEmpty())
            return ResponseEntity.notFound().build();
            solicitud.setId(id);
            solicitudService.save(solicitud);
            return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/id")
    public void deleteSolicitud(@PathVariable int id){
        solicitudService.deleteById(id);
    }
}

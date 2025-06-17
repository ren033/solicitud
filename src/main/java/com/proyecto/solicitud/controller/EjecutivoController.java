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

    @GetMapping("/id")
    public ResponseEntity<Ejecutivo> getById(@PathVariable int id){
        return new ResponseEntity<Ejecutivo>(ejecutivoService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/ejecutivo")
    public ResponseEntity<Ejecutivo> getByName(@PathVariable String nombre){
        return new ResponseEntity<Ejecutivo>(ejecutivoService.findByName(nombre), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity <Ejecutivo> postEjecutivo(@RequestBody Ejecutivo ejecutivo)
    {
        Ejecutivo search = ejecutivoService.findById(ejecutivo.getId());
        if (search == null) {
            return new ResponseEntity<>(ejecutivoService.save(ejecutivo), HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/id")
    public ResponseEntity<Ejecutivo> updateEjecutivo(@RequestBody Ejecutivo ejecutivo, @PathVariable int id)
    {
        List<Ejecutivo> updateEjecutivo = ejecutivoService.listEjecutivos();
        if (!updateEjecutivo.isEmpty())
            return ResponseEntity.notFound().build();
            ejecutivo.setId(id);
            ejecutivoService.save(ejecutivo);
            return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/id")
    public void deleteEjecutivo(@PathVariable int id){
        ejecutivoService.deleteById(id);
    }
}

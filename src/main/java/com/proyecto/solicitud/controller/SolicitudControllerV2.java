/*
package com.proyecto.solicitud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.solicitud.assemblers.SolicitudModelAssembler;
import com.proyecto.solicitud.model.Solicitud;
import com.proyecto.solicitud.service.SolicitudService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v2/solicitud")
public class SolicitudControllerV2
{
    @Autowired
    private SolicitudService solicitudService;

    @Autowired
    private SolicitudModelAssembler assembler;

    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public CollectionModel<EntityModel<Solicitud>> getAll() {
        List<EntityModel<Solicitud>> solicitudes = solicitudService.listSolicitudes().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(solicitudes,
                linkTo(methodOn(SolicitudControllerV2.class).getAll()).withSelfRel());
    }

    @GetMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public EntityModel<Solicitud> getById(@PathVariable int id) {
        Optional<Solicitud> solicitud = solicitudService.findById(id);
        return assembler.toModel(solicitud);
    }

    @GetMapping(value = "/cliente/{idCliente}", produces = MediaTypes.HAL_JSON_VALUE)
    public CollectionModel<EntityModel<Solicitud>> getByClienteId(@PathVariable Integer idCliente)
    {
        List<EntityModel<Solicitud>> solicitudes = solicitudService.findByClienteId(idCliente).stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(solicitudes,
        linkTo(methodOn(SolicitudControllerV2.class).getByClienteId(idCliente)).withSelfRel());
    }

    @PostMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Solicitud>> createSolicitud(@RequestBody Solicitud solicitud) {
        Solicitud newSol = solicitudService.save(solicitud);
        return ResponseEntity
                .created(linkTo(methodOn(SolicitudControllerV2.class).getById(newSol.getId())).toUri())
                .body(assembler.toModel(newSol));
    }

    @PutMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Solicitud>> update(@PathVariable int id, @RequestBody Solicitud solicitud) {
        solicitud.setId(id);
        Solicitud updatedSol = solicitudService.save(solicitud);
        return ResponseEntity.ok(assembler.toModel(updatedSol));
    }

    @DeleteMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable int id) {
        solicitudService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
*/
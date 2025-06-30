package com.proyecto.solicitud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.solicitud.assemblers.SolicitudModelAssembler;
import com.proyecto.solicitud.model.Solicitud;
import com.proyecto.solicitud.service.SolicitudService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v2/solicitud")
public class SolicitudControllerV2
{
    @Autowired
    private SolicitudService solicitudService;

    @Autowired
    private SolicitudModelAssembler assembler;

    @GetMapping(value = "/cliente/{idCliente}", produces = MediaTypes.HAL_JSON_VALUE)
    public CollectionModel<EntityModel<Solicitud>> getByClienteId(@PathVariable Integer idCliente)
    {
        List<EntityModel<Solicitud>> solicitudes = solicitudService.findByClienteId(idCliente).stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(solicitudes,
        linkTo(methodOn(SolicitudControllerV2.class).getByClienteId(idCliente)).withSelfRel());
    }
}

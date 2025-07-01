package com.proyecto.solicitud.assemblers;


import org.springframework.stereotype.Component;

import com.proyecto.solicitud.controller.SolicitudController;
import com.proyecto.solicitud.model.Solicitud;

import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;


@Component
public class SolicitudModelAssembler implements RepresentationModelAssembler<Solicitud, EntityModel<Solicitud>>{
    @Override
    public EntityModel<Solicitud> toModel(Optional<Solicitud> solicitud) {
        return EntityModel.of(solicitud,
                linkTo(methodOn(SolicitudController.class).getAllSolicitudes()).withRel("Solicitudes"));
    }
    @Override
    public EntityModel<Solicitud> toModel(Solicitud solicitud) {
        return EntityModel.of(solicitud,
                linkTo(methodOn(SolicitudController.class).getSolicitudById(solicitud.getId())).withSelfRel());
    }
}


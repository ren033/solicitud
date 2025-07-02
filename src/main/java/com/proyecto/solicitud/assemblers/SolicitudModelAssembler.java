package com.proyecto.solicitud.assemblers;


import org.springframework.stereotype.Component;

import com.proyecto.solicitud.controller.SolicitudController;
import com.proyecto.solicitud.model.Solicitud;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.Optional;

import org.springframework.hateoas.EntityModel;

@Component
public class SolicitudModelAssembler implements RepresentationModelAssembler<Solicitud, EntityModel<Solicitud>>{
    @Override
    public EntityModel<Solicitud> toModel(Optional<Solicitud> solicitud) {
        return EntityModel.of(solicitud,
                linkTo(methodOn(SolicitudController.class).getById(solicitud.getId())).withSelfRel(),
                linkTo(methodOn(SolicitudController.class).getAll()).withRel("Solicitudes"));
    }
}


package com.proyecto.solicitud.assemblers;


import org.springframework.stereotype.Component;

import com.proyecto.solicitud.controller.SolicitudControllerV2;
import com.proyecto.solicitud.model.Solicitud;

<<<<<<< HEAD
=======
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
>>>>>>> 5c76576c8bb7fdab886a822a799c47e1a6efb15a
import org.springframework.hateoas.server.RepresentationModelAssembler;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.Optional;

import org.springframework.hateoas.EntityModel;

@Component
public class SolicitudModelAssembler implements RepresentationModelAssembler<Solicitud, EntityModel<Solicitud>>{
    @Override
    public EntityModel<Solicitud> toModel(Optional<Solicitud> solicitud) {
<<<<<<< HEAD
        return EntityModel.of(solicitud,
                linkTo(methodOn(SolicitudController.class).getById(solicitud.getId())).withSelfRel(),
                linkTo(methodOn(SolicitudController.class).getAll()).withRel("Solicitudes"));
=======
        return EntityModel.of(solicitud,
                linkTo(methodOn(SolicitudControllerV2.class).getAll()).withRel("Solicitudes"));
    }
    @Override
    public EntityModel<Solicitud> toModel(Solicitud solicitud) {
        return EntityModel.of(solicitud,
                linkTo(methodOn(SolicitudControllerV2.class).getById(solicitud.getId())).withSelfRel());
>>>>>>> 5c76576c8bb7fdab886a822a799c47e1a6efb15a
    }
}


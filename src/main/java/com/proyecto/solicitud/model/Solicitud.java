package com.proyecto.solicitud.model;

import com.proyecto.solicitud.enums.EstadoSol;
import com.proyecto.solicitud.enums.TipoSol;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true)
    private int id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoSol tipoSol;

    @Column(name = "Descripcion", nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Integer idCliente;

    @Column(nullable = false)
    private String nombreCliente;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoSol estadoSol;
}

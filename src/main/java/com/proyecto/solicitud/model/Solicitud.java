package com.proyecto.solicitud.model;

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

    @Column(name = "Tipo Solicitud", nullable = false)
    private String tipo;

    @Column(name = "Descripcion", nullable = false)
    private String descripcion;
}

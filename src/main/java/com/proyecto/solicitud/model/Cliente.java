package com.proyecto.solicitud.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Cliente")

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true)
    private int id;

    @Column(name = "Contraseña", nullable = false)
    private String password;

    @Column(name = "Username", nullable = false)
    private String username;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "Correo", nullable = false)
    private String correo;

    @Column(name = "Direccion", nullable = false)
    private String direccion;

    @Column(name = "Estado", nullable = false)
    private boolean estado;
}


package com.anunez.apirest.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "Futbolista")
public class Futbolista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name= "IDFutbolista")
    private long idFutbolista;

    @ManyToOne
    @JoinColumn(name= "IDPosicion", referencedColumnName = "IDPosicion")
    private Posicion posicion;

    @Column(name= "Nombres", nullable = false, length = 255)
    private String nombres;

    @Column(name= "Apellidos", nullable = false, length = 255)
    private String apellidos;

    @Column(name= "FechaNacimiento", nullable = false)
    private Date fechaNacimiento;
    
    @Column(name= "Caracteristica", nullable = false, length = 255)
    private String caracteristica;
}

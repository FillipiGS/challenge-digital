package com.fiap.challenge.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "SENSOR")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroInstalacao;

    @Column(name = "corrente")
    private double corrente;

    @Column(name = "watts_hora")
    private double wattsHora;
}

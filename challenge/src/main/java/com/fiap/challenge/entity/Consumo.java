package com.fiap.challenge.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "CONSUMO")
public class Consumo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor_consumo")
    private double valorConsumo;

    @Column(name = "descricao_KwH")
    private String descricaoKwH;

    @Column(name = "data")
    private Date data;

}

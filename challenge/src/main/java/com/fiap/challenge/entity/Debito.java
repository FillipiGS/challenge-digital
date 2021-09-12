package com.fiap.challenge.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "DEBITO")
public class Debito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_banco")
    private String nomeBanco;

    @Column(name = "agencia")
    private int agencia;

    @Column(name = "conta")
    private int conta;

    @Column(name = "digito_verificador")
    private int digitoVerificador;

}

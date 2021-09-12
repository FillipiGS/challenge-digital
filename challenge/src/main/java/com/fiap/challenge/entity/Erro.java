package com.fiap.challenge.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ERRO")
public class Erro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "descricao")
    private String descricao;

}

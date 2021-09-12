package com.fiap.challenge.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "rua")
    private String rua;

    @Column(name = "numero")
    private int numero;

    @Column(name = "cep")
    private String cep;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "numero_relogio")
    private Long numeroRelogio;

    @Column(name = "senha")
    private String senha;

}

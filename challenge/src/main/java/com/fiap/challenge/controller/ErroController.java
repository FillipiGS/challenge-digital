package com.fiap.challenge.controller;

import com.fiap.challenge.entity.Erro;
import com.fiap.challenge.repository.ErroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class ErroController {

    @Autowired
    private ErroRepository erroRepository;

    @PostMapping("/erros")
    public ResponseEntity<Object> reportarErro(@RequestBody Erro erro) {
        Erro criarReport = erroRepository.save(erro);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(criarReport.getId()).toUri();
        return ResponseEntity.created(location).build();
    }


}

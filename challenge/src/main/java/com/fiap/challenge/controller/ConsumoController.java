package com.fiap.challenge.controller;

import com.fiap.challenge.entity.Consumo;
import com.fiap.challenge.repository.ConsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ConsumoController {

    @Autowired
    private ConsumoRepository consumoRepository;

    @GetMapping("/consumos")
    public List<Consumo> listarTodosConsumos() {
        return consumoRepository.findAll();
    }

    @GetMapping("/consumos/{id}")
    public Consumo detalharUsuario(@PathVariable long id) {
        Optional<Consumo> consumo = consumoRepository.findById(id);
        return consumo.get();
    }

}

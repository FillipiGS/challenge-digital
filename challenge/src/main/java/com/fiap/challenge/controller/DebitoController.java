package com.fiap.challenge.controller;

import com.fiap.challenge.entity.Debito;
import com.fiap.challenge.repository.DebitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
public class DebitoController {

    @Autowired
    private DebitoRepository debitoRepository;

    @GetMapping("/debitos/{id}")
    public Debito detalharDebito(@PathVariable long id) {
        Optional<Debito> debito = debitoRepository.findById(id);
        return debito.get();
    }

    @DeleteMapping("/debitos/{id}")
    public void deletarDebito(@PathVariable long id) {
        debitoRepository.deleteById(id);
    }

    @PostMapping("/debitos")
    public ResponseEntity<Object> cadastrarDebito(@RequestBody Debito debito) {
        Debito debitoSavo = debitoRepository.save(debito);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(debitoSavo.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/debitos/{id}")
    public ResponseEntity<Object> atualizarDebito(@RequestBody Debito debito, @PathVariable long id) {
        Optional<Debito> optionalDebito = debitoRepository.findById(id);

        if (!optionalDebito.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        debito.setId(id);
        debitoRepository.save(debito);

        return ResponseEntity.noContent().build();
    }


}

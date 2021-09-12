package com.fiap.challenge.controller;

import com.fiap.challenge.entity.Usuario;
import com.fiap.challenge.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public List<Usuario> listarTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/usuarios/{id}")
    public Usuario detalharUsuario(@PathVariable long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.get();
    }


    @PostMapping("/usuarios")
    public ResponseEntity<Object> cadastrarUsuario(@RequestBody Usuario usuario) {
        Usuario criarUsuario = usuarioRepository.save(usuario);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(criarUsuario.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Object> atualizarUsuario(@RequestBody Usuario usuario, @PathVariable long id) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);

        if (!optionalUsuario.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        usuario.setId(id);
        usuarioRepository.save(usuario);

        return ResponseEntity.noContent().build();
    }


}

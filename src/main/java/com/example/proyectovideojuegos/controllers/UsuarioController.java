package com.example.proyectovideojuegos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.proyectovideojuegos.entity.models.Usuario;
import com.example.proyectovideojuegos.entity.services.IUsuarioService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    IUsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAll();
    }

    @GetMapping("/{id}")
    public Usuario getOne(@PathVariable(value = "id") Integer id) {
        return usuarioService.get(id);
    }

    @PostMapping
    public ResponseEntity<Usuario> post(@RequestBody Usuario usuario) {
        usuarioService.post(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> put(@RequestBody Usuario usuario, @PathVariable(value = "id") Integer id) {
        usuarioService.put(usuario, id);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

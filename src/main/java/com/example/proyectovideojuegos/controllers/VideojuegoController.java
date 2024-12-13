package com.example.proyectovideojuegos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.proyectovideojuegos.entity.models.Videojuego;
import com.example.proyectovideojuegos.entity.services.IVideojuegoService;

@RestController
@CrossOrigin(origins= "*")
@RequestMapping("/videojuegos")
public class VideojuegoController {

    @Autowired
    IVideojuegoService videojuegoService;

    @GetMapping
    public List<Videojuego> getAllVideojuegos() {
        return videojuegoService.getAll();
    }

    @GetMapping("/{id}")
    public Videojuego getOne(@PathVariable(value = "id") Integer id) {
        return videojuegoService.get(id);
    }

    
    @PostMapping
    public ResponseEntity<Videojuego> post(@RequestBody Videojuego videojuego) {
        videojuegoService.post(videojuego);
        return ResponseEntity.status(HttpStatus.CREATED).body(videojuego);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Videojuego> put(@RequestBody Videojuego videojuego, @PathVariable(value = "id") Integer id) {
        videojuegoService.put(videojuego, id);
        return ResponseEntity.ok(videojuego);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id) {
        videojuegoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

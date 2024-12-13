package com.example.proyectovideojuegos.entity.services;

import java.util.List;

import com.example.proyectovideojuegos.entity.models.Videojuego;

public interface IVideojuegoService {
    public Videojuego get(int id);
    public List<Videojuego> getAll();
    public void post(Videojuego videojuego);
    public void put(Videojuego videojuego, int id);
    public void delete(int id);
}

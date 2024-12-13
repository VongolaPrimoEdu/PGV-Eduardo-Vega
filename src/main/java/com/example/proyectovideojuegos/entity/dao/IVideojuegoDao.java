package com.example.proyectovideojuegos.entity.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.proyectovideojuegos.entity.models.Videojuego;

public interface IVideojuegoDao extends CrudRepository<Videojuego, Integer> {

}

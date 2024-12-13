package com.example.proyectovideojuegos.entity.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.proyectovideojuegos.entity.models.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Integer> {

}

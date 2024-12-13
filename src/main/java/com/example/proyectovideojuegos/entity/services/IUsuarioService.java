package com.example.proyectovideojuegos.entity.services;

import java.util.List;

import com.example.proyectovideojuegos.entity.models.Usuario;

public interface IUsuarioService {
    public Usuario get(int id);
    public List<Usuario> getAll();
    public void post(Usuario usuario);
    public void put(Usuario usuario, int id);
    public void delete(int id);
}

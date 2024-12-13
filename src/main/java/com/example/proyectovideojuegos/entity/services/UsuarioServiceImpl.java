package com.example.proyectovideojuegos.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyectovideojuegos.entity.dao.IUsuarioDao;
import com.example.proyectovideojuegos.entity.models.Usuario;
import com.example.proyectovideojuegos.exceptions.ResourceNotFoundException;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioDao usuarioDao;

    @Override
    public Usuario get(int id) {
        return usuarioDao.findById(id).orElseThrow(() -> 
            new ResourceNotFoundException("Usuario no encontrado con ID: " + id));
    }

    @Override
    public List<Usuario> getAll() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    public void post(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    public void put(Usuario usuario, int id) {
        if (!usuarioDao.existsById(id)) {
            throw new ResourceNotFoundException("Usuario no encontrado con ID: " + id);
        }
        usuario.setId(id);
        usuarioDao.save(usuario);
    }

    @Override
    public void delete(int id) {
        if (!usuarioDao.existsById(id)) {
            throw new ResourceNotFoundException("Usuario no encontrado con ID: " + id);
        }
        usuarioDao.deleteById(id);
    }
}

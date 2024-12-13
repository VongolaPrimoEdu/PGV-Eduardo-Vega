package com.example.proyectovideojuegos.entity.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyectovideojuegos.entity.dao.IVideojuegoDao;
import com.example.proyectovideojuegos.entity.models.Videojuego;
import com.example.proyectovideojuegos.exceptions.ResourceNotFoundException;

@Service
public class VideojuegoServiceImpl implements IVideojuegoService {

    @Autowired
    private IVideojuegoDao videojuegoDao;

    @Override
    public Videojuego get(int id) {
        return videojuegoDao.findById((int) id).orElseThrow(() -> 
            new ResourceNotFoundException("Videojuego no encontrado con ID: " + id));
    }

    @Override
    public List<Videojuego> getAll() {
        return (List<Videojuego>) videojuegoDao.findAll();
    }
    
    

    @Override
    public void post(Videojuego videojuego) {
        videojuegoDao.save(videojuego);
    }

    @Override
    public void put(Videojuego videojuego, int id) {
        if (!videojuegoDao.existsById(id)) {
            throw new ResourceNotFoundException("Videojuego no encontrado con ID: " + id);
        }
        videojuego.setId(id);
        videojuegoDao.save(videojuego);
    }

    @Override
    public void delete(int id) {
        if (!videojuegoDao.existsById(id)) {
            throw new ResourceNotFoundException("Videojuego no encontrado con ID: " + id);
        }
        videojuegoDao.deleteById(id);
    }

}

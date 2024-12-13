package com.example.proyectovideojuegos.entity.models;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "videojuego")
public class Videojuego implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String fechaLanzamiento; // Usamos String, puede ser Date si se trabaja con formatos específicos
    private String genero;
    private String plataforma;
    private String reseña; // En español sería "reseña"
    private double precio;
    private int ventas;

    // Relación muchos a muchos con Usuario
    @ManyToMany(mappedBy = "listaVideojuegos")
    @JsonIgnore
    private Set<Usuario> usuarios;

    // Constructor con todos los atributos
    public Videojuego(int id, String nombre, String fechaLanzamiento, String genero, String plataforma, String reseña, double precio, int ventas) {
        this.id = id;
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
        this.genero = genero;
        this.plataforma = plataforma;
        this.reseña = reseña;
        this.precio = precio;
        this.ventas = ventas;
    }

    // Constructor vacío
    public Videojuego() {
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getResena() {
        return reseña;
    }

    public void setResena(String resena) {
        this.reseña = resena;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}

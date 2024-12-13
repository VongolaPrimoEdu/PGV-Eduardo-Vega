package com.example.proyectovideojuegos.entity.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    private String correo;
    private String contrasena;

    // Relación muchos a muchos con Videojuego
    @ManyToMany
    @JoinTable(
        name = "usuario_videojuego", // Nombre de la tabla intermedia
        joinColumns = @JoinColumn(name = "usuario_id"), // Llave foránea hacia Usuario
        inverseJoinColumns = @JoinColumn(name = "videojuego_id") // Llave foránea hacia Videojuego
    )
    private Set<Videojuego> listaVideojuegos;

    // Constructor con todos los atributos
    public Usuario(int id, String nombreUsuario, String correo, String contrasena) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    // Constructor vacío
    public Usuario() {
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Set<Videojuego> getlistaVideojuegos() {
        return listaVideojuegos;
    }

    public void setlistaVideojuegos(Set<Videojuego> listaVideojuegos) {
        this.listaVideojuegos = listaVideojuegos;
    }
}

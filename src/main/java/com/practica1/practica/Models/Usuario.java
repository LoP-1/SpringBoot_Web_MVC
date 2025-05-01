package com.practica1.practica.Models;

//el usuario, sin usar lombok que eso solo da errores
//lombok nunca mas >:c

public class Usuario {
 private String nombre;
 private String apellido;
 private String email;

    public Usuario() {
    }

    public Usuario(String email, String apellido, String nombre) {
        this.email = email;
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}

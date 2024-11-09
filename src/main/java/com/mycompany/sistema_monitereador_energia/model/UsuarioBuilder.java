
package com.mycompany.sistema_monitereador_energia.model;


public class UsuarioBuilder {
     private int id;
    private String nombre;
    private String contrasena;

    public UsuarioBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public UsuarioBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public UsuarioBuilder setContrasena(String contrasena) {
        this.contrasena = contrasena;
        return this;
    }

    public Usuario build() {
        return new Usuario(id, nombre, contrasena);
    }
}

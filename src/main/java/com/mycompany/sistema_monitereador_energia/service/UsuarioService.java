
package com.mycompany.sistema_monitereador_energia.service;

import com.mycompany.sistema_monitereador_energia.model.Usuario;
import com.mycompany.sistema_monitereador_energia.observer.UsuarioObserver;
import com.mycompany.sistema_monitereador_energia.repository.UsuarioRepository;
import java.util.ArrayList;
import java.util.List;


public class UsuarioService {
    
    private static UsuarioService instance; 
    private final UsuarioRepository usuarioRepository;
    private final List<UsuarioObserver> observers = new ArrayList<>();
    private Usuario usuarioActual;

    // Constructor privado para prevenir instanciación desde fuera de la clase
    private UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Método para obtener la instancia Singleton
    public static UsuarioService getInstance(UsuarioRepository usuarioRepository) {
        if (instance == null) {
            instance = new UsuarioService(usuarioRepository);
        }
        return instance;
    }

    public static UsuarioService getInstance() {
        if (instance == null) {
            throw new IllegalStateException("UsuarioService no ha sido configurado con un repositorio.");
        }
        return instance;
    }
    
    public void addObserver(UsuarioObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers(Usuario usuario) {
        for (UsuarioObserver observer : observers) {
            observer.onUsuarioUpdated(usuario);
        }
    }
    
    public boolean iniciarSesion(String nombre, String contrasena) {
        Usuario usuario = usuarioRepository.obtenerUsuarioNombre(nombre);
        if (usuario != null && usuario.getContrasena().equals(contrasena)) {
            usuarioActual = usuario; 
            return true;
        }
        return false;
    }
    
    public Usuario obtenerUsuarioActual() {
        if (usuarioActual == null) {
            throw new IllegalStateException("No hay un usuario autenticado en sesión.");
        }
        return usuarioActual;
    }
    
    public void actualizarUsuario(Usuario usuario) {
        usuarioRepository.actualizarUsuario(usuario);
        notifyObservers(usuario); 
    }

    public void agregarUsuario(Usuario usuario) {
        usuarioRepository.agregarUsuario(usuario);
    }

    public Usuario obtenerUsuario(int id) {
        return usuarioRepository.obtenerUsuario(id);
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.obtenerTodosLosUsuarios();
    }
    
    public boolean validarUsuario(String nombre, String contrasena) {
        return usuarioRepository.validarUsuario(nombre, contrasena);
    }
}


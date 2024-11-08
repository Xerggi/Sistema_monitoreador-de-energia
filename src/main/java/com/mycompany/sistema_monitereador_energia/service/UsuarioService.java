
package com.mycompany.sistema_monitereador_energia.service;

import com.mycompany.sistema_monitereador_energia.model.Usuario;
import com.mycompany.sistema_monitereador_energia.observer.UsuarioObserver;
import com.mycompany.sistema_monitereador_energia.repository.UsuarioRepository;
import java.util.ArrayList;
import java.util.List;


public class UsuarioService {
    
    private final UsuarioRepository usuarioRepository;
    private final List<UsuarioObserver> observers = new ArrayList<>();
    
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void addObserver(UsuarioObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers(Usuario usuario) {
        for (UsuarioObserver observer : observers) {
            observer.onUsuarioUpdated(usuario);
        }
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
}


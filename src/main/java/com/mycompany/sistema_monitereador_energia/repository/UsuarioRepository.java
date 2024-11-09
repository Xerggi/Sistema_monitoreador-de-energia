
package com.mycompany.sistema_monitereador_energia.repository;

import com.mycompany.sistema_monitereador_energia.model.Usuario;
import java.util.List;


public interface UsuarioRepository {
    void agregarUsuario(Usuario usuario);
    Usuario obtenerUsuario(int id);
    Usuario obtenerUsuarioNombre(String nombre);
    List<Usuario> obtenerTodosLosUsuarios();
    void actualizarUsuario(Usuario usuario);
    void eliminarUsuario(int id);
    
    boolean validarUsuario(String nombre, String contrasena);
}

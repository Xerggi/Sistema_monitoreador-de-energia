
package com.mycompany.sistema_monitereador_energia.controller;

import com.mycompany.sistema_monitereador_energia.model.Usuario;
import com.mycompany.sistema_monitereador_energia.service.UsuarioService;



public class UsuarioController {
    
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    
    public void actualizarUsuario(Usuario usuario) {
        usuarioService.actualizarUsuario(usuario);
    }
    

}

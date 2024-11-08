
package com.mycompany.sistema_monitereador_energia.observer;

import com.mycompany.sistema_monitereador_energia.model.Usuario;


public interface UsuarioObserver {
    void onUsuarioUpdated(Usuario usuario);
}

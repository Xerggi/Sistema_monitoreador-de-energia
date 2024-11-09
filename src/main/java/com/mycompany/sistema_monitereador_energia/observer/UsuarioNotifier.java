
package com.mycompany.sistema_monitereador_energia.observer;

import com.mycompany.sistema_monitereador_energia.model.Usuario;


public class UsuarioNotifier implements UsuarioObserver{

    @Override
    public void onUsuarioUpdated(Usuario usuario) {
        System.out.println("El usuario " + usuario.getNombre() + " ha sido actualizado exitosamente.");
    }
    
}

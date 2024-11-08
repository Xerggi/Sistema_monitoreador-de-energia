/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_monitereador_energia.observer;

import com.mycompany.sistema_monitereador_energia.model.Usuario;

/**
 *
 * @author Xerggi
 */
public class UsuarioNotifier implements UsuarioObserver{

    @Override
    public void onUsuarioUpdated(Usuario usuario) {
        System.out.println("El usuario " + usuario.getNombre() + " ha sido actualizado exitosamente.");
    }
    
}

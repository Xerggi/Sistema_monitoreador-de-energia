
package com.mycompany.sistema_monitereador_energia.controller;

import com.mycompany.sistema_monitereador_energia.model.Dispositivo;
import com.mycompany.sistema_monitereador_energia.service.DispositivoService;
import java.util.List;

public class DispositivoController {
    private final DispositivoService dispositivoService;

    // Constructor con la inyección del servicio
    public DispositivoController(DispositivoService dispositivoService) {
        this.dispositivoService = dispositivoService;
    }

    // Método para obtener los dispositivos de un usuario
    public List<Dispositivo> obtenerDispositivosUsuario(int usuarioId) {
        return dispositivoService.obtenerDispositivosUsuario(usuarioId);
    }

    // Método para eliminar un dispositivo
    public void eliminarDispositivo(int id) {
        dispositivoService.eliminarDispositivo(id);
    }
}

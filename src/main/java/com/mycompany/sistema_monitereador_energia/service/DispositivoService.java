
package com.mycompany.sistema_monitereador_energia.service;

import com.mycompany.sistema_monitereador_energia.model.Dispositivo;
import com.mycompany.sistema_monitereador_energia.model.Usuario;
import com.mycompany.sistema_monitereador_energia.repository.DispositivoRepository;
import java.util.ArrayList;
import java.util.List;


public class DispositivoService {
    
     private final DispositivoRepository dispositivoRepository;

    public DispositivoService(DispositivoRepository dispositivoRepository) {
        this.dispositivoRepository = dispositivoRepository;
    }
     
    public void registrarDispositivo(String tipo, double consumoEstimado, double consumoActual) {
         Usuario usuarioActual = UsuarioService.getInstance().obtenerUsuarioActual();
        int usuarioId = usuarioActual.getId(); 

    Dispositivo dispositivo = new Dispositivo(0, tipo, consumoEstimado, consumoActual, usuarioId);

        dispositivoRepository.agregarDispositivo(dispositivo);
    }
    
    public List<Dispositivo> obtenerDispositivosUsuario(int usuarioId) {
        return dispositivoRepository.obtenerDispositivosUsuario(usuarioId);
    }
    
    public void eliminarDispositivo(int id) {
        dispositivoRepository.eliminarDispositivo(id);
    }
    
}

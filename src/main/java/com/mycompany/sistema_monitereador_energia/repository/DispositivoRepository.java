
package com.mycompany.sistema_monitereador_energia.repository;

import com.mycompany.sistema_monitereador_energia.model.Dispositivo;
import java.util.List;


public interface DispositivoRepository {
    void agregarDispositivo(Dispositivo dispositivo);
    List<Dispositivo> obtenerTodosLosDispositivos();
    void eliminarDispositivo(int id);
}

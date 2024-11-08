
package com.mycompany.sistema_monitereador_energia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor

public class Dispositivo {
    private int id;
    private String tipo;
    private double consumoEstimado;
    private double consumoActual;
    private int usuarioId;
}

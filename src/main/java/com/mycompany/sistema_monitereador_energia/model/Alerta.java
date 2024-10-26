
package com.mycompany.sistema_monitereador_energia.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alerta {
    private int id;
    private Dispositivo dispositivo;
    private double consumo;
    private Date fecha;
}

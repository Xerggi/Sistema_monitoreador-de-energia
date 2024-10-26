package com.mycompany.sistema_monitereador_energia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private int id;
    private String nombre;
    private String contrasena;
}

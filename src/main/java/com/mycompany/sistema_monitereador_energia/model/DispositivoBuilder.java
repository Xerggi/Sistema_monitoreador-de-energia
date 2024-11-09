
package com.mycompany.sistema_monitereador_energia.model;


public class DispositivoBuilder {
    
    private int id;
    private String tipo;
    private double consumoEstimado;
    private double consumoActual;
    private int usuarioId;

    public DispositivoBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public DispositivoBuilder setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public DispositivoBuilder setConsumoEstimado(double consumoEstimado) {
        this.consumoEstimado = consumoEstimado;
        return this;
    }

    public DispositivoBuilder setConsumoActual(double consumoActual) {
        this.consumoActual = consumoActual;
        return this;
    }

    public DispositivoBuilder setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
        return this;
    }

    public Dispositivo build() {
        return new Dispositivo(id, tipo, consumoEstimado, consumoActual, usuarioId);
    }
}

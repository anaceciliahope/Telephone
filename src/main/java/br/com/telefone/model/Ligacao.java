package br.com.telefone.model;

import java.time.LocalDateTime;


public class Ligacao {
    private Telefone origem;
    private Telefone destino;
    private LocalDateTime horaInicio;
    private LocalDateTime horaTermino;

    public Ligacao(Telefone origem, Telefone destino) {
        this.origem = origem;
        this.destino = destino;
    }
    public Ligacao() {

    }
    public Telefone getOrigem() {
        return origem;
    }

    public void setOrigem(Telefone origem) {
        this.origem = origem;
    }

    public Telefone getDestino() {
        return destino;
    }

    public void setDestino(Telefone destino) {
        this.destino = destino;
    }

    public LocalDateTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalDateTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalDateTime getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(LocalDateTime horaTermino) {
        this.horaTermino = horaTermino;
    }
    @Override
    public String toString() {
        return "Ligação: " +
                " origem: " + origem +
                " destino: " + destino +
                " horaInicio: " + horaInicio +
                " horaTermino: " + horaTermino;
    }
}

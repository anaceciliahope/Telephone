package br.com.telefone.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Ligacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Telefone origem;
    @ManyToOne
    private Telefone destino;
    private LocalDateTime horaInicio;
    private LocalDateTime horaTermino;

    public Ligacao(Telefone origem, Telefone destino) {
        this.origem = origem;
        this.destino = destino;
    }
    public Ligacao() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

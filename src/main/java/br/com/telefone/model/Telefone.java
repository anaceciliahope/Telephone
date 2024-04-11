package br.com.telefone.model;

import br.com.telefone.model.enums.TipoTelefone;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer ddi;
    private Integer ddd;
    private Long numero;
    private TipoTelefone tipoTelefone;
    @ManyToOne
    private Contato contato;
    @OneToMany(mappedBy = "origem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ligacao> ligacoesOrigem;
    @OneToMany(mappedBy = "destino", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ligacao> ligacoesDestino;
    public Telefone(Integer ddi, Integer ddd, Long numero) {
        this.ddi = ddi;
        this.ddd = ddd;
        this.numero = numero;
    }

    public Telefone() {
        super();
    }

    public Integer getDDI() {
        return ddi;
    }
    public void setDDI(Integer DDI) {
        this.ddi = DDI;
    }

    public Integer getDDD() {
        return ddd;
    }

    public void setDDD(Integer DDD) {
        this.ddd = DDD;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public TipoTelefone getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(TipoTelefone tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    @Override
    public String toString() {
        return "Telefone: " +
                " ddi" + "(" + ddi + ")" +
                " ddd " + "("+ ddd + ")" +
                " numero " + numero +
                " (" + "tipoTelefone: " + tipoTelefone.getMensagem() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefone telefone = (Telefone) o;
        return Objects.equals(ddi, telefone.ddi) && Objects.equals(ddd, telefone.ddd) && Objects.equals(numero, telefone.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ddi, ddd, numero);
    }
}

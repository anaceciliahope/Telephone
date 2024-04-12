package br.com.telefone.model;

import br.com.telefone.model.enums.TipoTelefone;
import jakarta.persistence.*;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDdi() {
        return ddi;
    }

    public void setDdi(Integer ddi) {
        this.ddi = ddi;
    }

    public Integer getDdd() {
        return ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public List<Ligacao> getLigacoesOrigem() {
        return ligacoesOrigem;
    }

    public void setLigacoesOrigem(List<Ligacao> ligacoesOrigem) {
        this.ligacoesOrigem = ligacoesOrigem;
    }

    public List<Ligacao> getLigacoesDestino() {
        return ligacoesDestino;
    }

    public void setLigacoesDestino(List<Ligacao> ligacoesDestino) {
        this.ligacoesDestino = ligacoesDestino;
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

package br.com.telefone.model;

import java.util.List;
import java.util.Objects;

public class Contato {
    private String nome;
    private List<Telefone> telefones;

    public List<Telefone> getTelefones() {
        return telefones;
    }


    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public Contato(String nome) {
        this.nome = nome;

    }
    @Override
    public String toString() {
        return "Contato: " +
                "nome: " + nome + ": " +
                 telefones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return Objects.equals(nome, contato.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}

package br.com.telefone.model.enums;

public enum TipoTelefone {
    TELEFONE_PRINCIPAl("Telefone Principal"),
    TELEFONE_ADICIONAL("Telefone Adicional");

    private String mensagem;

    TipoTelefone(String mensagem) {
        this.mensagem = mensagem;
    }
    public String getMensagem() {
        return mensagem;
    }
}

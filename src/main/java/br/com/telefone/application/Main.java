package br.com.telefone.application;

import br.com.telefone.model.Contato;
import br.com.telefone.model.Telefone;
import br.com.telefone.model.enums.TipoTelefone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner teclado = new Scanner(System.in);
    static List<Contato> contatos = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("1- Cadastrar Contato\n2- Efetuar Ligação\n3- Alterar Contato Principal");
        Integer opcao = teclado.nextInt();
        while (opcao != 0) {
            switch (opcao) {
                case 1:
                    cadastrarContatos();
                    listarContatos();
                    break;
                case 2:
                    System.out.println("Efetuando Ligação...");
                    break;
                case 3:
                    alterarTelefonePrincipal();
                    break;
                default:
                    System.out.println("Opção Invalida! ");
            }

            System.out.println("1- Cadastrar Contato\n2- Efetuar Ligação\n3- Alterar Contato Principal");
            opcao = teclado.nextInt();
        }
    }

    public static void cadastrarContatos() {
        System.out.print("Informe o nome: ");
        teclado.nextLine();
        String nome = teclado.nextLine();
        System.out.print("Informe o DDI: ");
        Integer ddi = teclado.nextInt();
        System.out.print("Informe o DDD: ");
        Integer ddd = teclado.nextInt();
        System.out.print("Informe o número: ");
        Long numero = teclado.nextLong();
        Telefone telefone = new Telefone(ddi, ddd, numero);
        Contato contato = new Contato(nome);
        contato.setTelefones(new ArrayList<>());
        contato.getTelefones().add(telefone);
        telefone.setTipoTelefone(telefone.getTipoTelefone());
        TipoTelefone tipoTelefone = TipoTelefone.TELEFONE_PRINCIPAl;
        telefone.setTipoTelefone(TipoTelefone.TELEFONE_PRINCIPAl);
        System.out.print("TELEFONE- " + tipoTelefone.getMensagem() + " CADASTRADO COM SUCESSO!\n");
        adicionarOutrosTelefones(contato);
        if (!contatos.contains(contato)) {
            contatos.add(contato);
        } else {
            System.out.print("CONTATO JÁ CADASTRADO.\n");
        }
    }

    public static void adicionarOutrosTelefones(Contato contato) {
        String mensagem = "Deseja adicionar outro telefone?\n 1- SIM\n0- NÃO ";
        System.out.println(mensagem);
        Integer opcao2 = teclado.nextInt();
        while (opcao2 != 0) {
            if (opcao2 == 1) {
                System.out.print("Informe o DDI: ");
                Integer ddi = teclado.nextInt();
                System.out.print("Informe o DDD: ");
                Integer ddd = teclado.nextInt();
                System.out.print("Informe o número: ");
                Long numero = teclado.nextLong();
                Telefone telefone = new Telefone(ddi, ddd, numero);
                contato.getTelefones().add(telefone);
                TipoTelefone tipoTelefone = TipoTelefone.TELEFONE_ADICIONAL;
                telefone.setTipoTelefone(TipoTelefone.TELEFONE_ADICIONAL);
                System.out.print("TELEFONE- " + tipoTelefone.getMensagem() + " ");
                System.out.print("Adicionado com sucesso. " + "\n");
            } else {
                System.out.println("Opção invalida.");
            }
            System.out.println(mensagem);
            opcao2 = teclado.nextInt();
        }

        teclado.nextLine();
    }

    public static void listarContatos() {
        System.out.println("LISTANDO CONTATOS");
        for (Contato contatos : contatos) {
            System.out.println(contatos);
        }

    }
    public static void listarContatos2() {
        System.out.println("CONTATOS: ");
        for (int i = 0; i < contatos.size(); i++) {
            Contato contato = contatos.get(i);
            System.out.println(i + ": " + contato);
        }
    }
    public static void listarTelefones(Contato contato) {
        System.out.println("TELEFONES: ");
        for (int i = 0; i < contato.getTelefones().size(); i++) {
            Telefone telefone = contato.getTelefones().get(i);
            System.out.println(i + ": " + telefone);
        }
    }

    public static void alterarTelefonePrincipal() {
        System.out.print("Escolha o contato para alterar o telefone principal: ");
        listarContatos2();

        System.out.println("Infome o indici do contato: ");
        int indiciContato = teclado.nextInt();

        if (indiciContato >= 0 && indiciContato < contatos.size()) {
            Contato contatoSelecionado = contatos.get(indiciContato);
            System.out.println("Telefones do contato selecionado: ");
            listarTelefones(contatoSelecionado);

            if (contatoSelecionado.getTelefones().size() > 1) {
                System.out.println("Informe o indice do telefone para ser alterado: ");
                int indiceTelefone = teclado.nextInt();
                if (indiceTelefone > 0 && indiceTelefone < contatoSelecionado.getTelefones().size()) {
                    Telefone telefoneSelecionado = contatoSelecionado.getTelefones().get(indiceTelefone);

                    if (telefoneSelecionado.getTipoTelefone() != TipoTelefone.TELEFONE_PRINCIPAl) {
                        contatoSelecionado.getTelefones().remove(indiceTelefone);
                        telefoneSelecionado.setTipoTelefone(TipoTelefone.TELEFONE_PRINCIPAl);
                        contatoSelecionado.getTelefones().add(0, telefoneSelecionado);
                        System.out.println("Telefone alterado com sucesso.");
                    } else {
                        System.out.println("Não é possível trocar um telefone principal por ele mesmo. ");
                    }
                } else {
                    System.out.println("Índici de telefone inválido. ");
                }
            } else {
                System.out.println("O contato selecionado possui apenas um telefone. ");
            }
            listarContatos2();
        } else {
            System.out.println("Índice de contato inválido. ");
        }


    }


}

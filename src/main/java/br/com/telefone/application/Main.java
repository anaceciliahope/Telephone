package br.com.telefone.application;

import br.com.telefone.model.Contato;
import br.com.telefone.model.Telefone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner teclado = new Scanner(System.in);
    static List<Contato> contatos = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("1- Cadastrar Contato\n2- Efetuar Ligação");
        Integer opcao = teclado.nextInt();

        while (opcao != 0) {
            if (opcao == 1) {
                cadastrarContatos();
            } else {
                System.out.println("Efetuando Ligação...");
            }
        }
        System.out.println("1- Cadastrar Contato\n2- Efetuar Ligação");
        opcao = teclado.nextInt();
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
        adicionarOutrosTelefones(contato);
        if (!contatos.contains(contato)) {
            contatos.add(contato);
            System.out.print("CONTATO CADASTRADO COM SUCESSO!\n");
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
                System.out.print("Adicionado com sucesso. ");
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

}

package br.com.telefone.program;

import br.com.telefone.model.Telefone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    static Scanner teclado = new Scanner(System.in);
   static List<Telefone> telefones = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("1- Cadastrar telefone\n2- Efetuar Ligação");
        Integer opcao = teclado.nextInt();
        while (opcao != 0) {
            if (opcao == 1) {
                cadastrarTelefone();
                listarNumeros();
            } else {
                System.out.println("Efetuando Ligação");
            }
            System.out.println("1- Cadastrar telefone\n2- Efetuar Ligação");
            opcao = teclado.nextInt();

        }

    }
    public static void cadastrarTelefone() {
        System.out.print("Informe o DDI: ");
        Integer ddi = teclado.nextInt();
        System.out.print("Informe o DDD: ");
        Integer ddd = teclado.nextInt();
        System.out.print("Informe o número: ");
        Long numero = teclado.nextLong();
        Telefone telefone = new Telefone(ddi, ddd, numero);
        if (!telefones.contains(telefone)) {
            telefones.add(telefone);
            System.out.println("NÚMERO CADASTRADO COM SUCESSO!");
        } else {
            System.out.print("NÚMERO JÁ CADASTRADO.\n1");
        }

    }
    public static void listarNumeros() {
        System.out.println("LISTANDO TELEFONES");
        for (Telefone telefone : telefones) {
            System.out.println(telefones);

        }

    }

}

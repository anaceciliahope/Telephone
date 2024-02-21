package br.com.telefone;

import br.com.telefone.model.Telefone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Quantos telefones? ");
        Integer quantidadeTelefone = teclado.nextInt();
        List<Telefone> telefones = new ArrayList<>();
        for (int i = 0; i < quantidadeTelefone; i++) {
            System.out.print("TELEFONE " + (i + 1) + ": ");
            System.out.print("Informe o DDI: ");
            Integer ddi = teclado.nextInt();
            System.out.print("Informe o DDD: ");
            Integer ddd = teclado.nextInt();
            System.out.print("Informe o número: ");
            Long numero = teclado.nextLong();

            telefones.add(new Telefone(ddi, ddd, numero));

        }
        System.out.println("Informe:\n 0- Para encerrar \n 1- Para efutuar a ligação");
        Integer opcao = teclado.nextInt();
        while (opcao != 0) {
            switch (opcao) {
                case 1:
                    System.out.print("Efetuando Ligação...");
                    break;
            }
            System.out.println("Informe:\n 0- Para encerrar \n 1- Para efuar a ligação");
            opcao = teclado.nextInt();
        }
        System.out.println("Programa encerrado.");
    }
}
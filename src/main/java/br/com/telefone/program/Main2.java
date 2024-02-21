package br.com.telefone.program;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("1- Cadastrar telefone\n2- Efetuar Ligação");
        Integer opcao = teclado.nextInt();
        while (opcao != 0) {
            if (opcao == 1) {
                System.out.print("Informe o DDI: ");
                Integer ddi = teclado.nextInt();
                System.out.print("Informe o DDD: ");
                Integer ddd = teclado.nextInt();
                System.out.print("Informe o número: ");
                Long numero = teclado.nextLong();
            } else {
                System.out.println("Efetuando Ligação");
            }
            System.out.println("1- Cadastrar telefone\n2- Efetuar Ligação");
            opcao = teclado.nextInt();
        }
    }
}

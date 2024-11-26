// 8) Leia um número até que o usuário digite 10

// Resolução:

package Estrutura_de_Repetição.Exercicio_8;

import java.util.Scanner;

public class LerNumero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero;

        System.out.println("Digite um número. Para sair, digite o número 10.");

        do {
            System.out.println("Digite o número: ");
            numero = scanner.nextInt();

            if (numero == 10) {
                System.out.println("------------------");
                System.out.println("Você digitou 10. O programa foi finalizado. Parabéns!!!");
            } else {
                System.out.println("------------------");
                System.out.println("Você digitou " + numero);
                System.out.println("------------------");
            }
        } while (numero != 10);
        scanner.close();
    }
}

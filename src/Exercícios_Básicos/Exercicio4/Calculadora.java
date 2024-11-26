// USAR SWITCH-CASE
/* 4) Implemente o programa da calculadora utilizando uma instrução
switch-case para determinar a operação que deve ser executada,
conforme o usuário escolheu no menu de opções. */


// Resolução:
package Exercícios_Básicos.Exercicio4;

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha uma operação:");
        System.out.println("1- Adição (+)");
        System.out.println("2- Subtração (-)");
        System.out.println("3- Multiplicação (*)");
        System.out.println("4- Divisão (/)");

        System.out.print("Digite o número da operação: ");
        int operacao = scanner.nextInt();

        if (operacao < 1 || operacao > 4) {
            System.out.println("--------------------------");
            System.out.println("Operação inválida");
            System.out.println("--------------------------");
        } else {
            System.out.print("Digite o primeiro número: ");
            double numero1 = scanner.nextDouble();

            System.out.print("Digite o segundo número: ");
            double numero2 = scanner.nextDouble();

            double resultado;

            switch (operacao) {
                case 1:
                    resultado = numero1 + numero2;
                    System.out.println("Resultado da adição: " + resultado);
                    break;
                case 2:
                    resultado = numero1 - numero2;
                    System.out.println("Resultado da subtração: " + resultado);
                    break;
                case 3:
                    resultado = numero1 * numero2;
                    System.out.println("Resultado da multiplicação: " + resultado);
                    break;
                case 4:
                    if (numero2 != 0) {
                        resultado = numero1 / numero2;
                        System.out.println("Resultado da divisão: " + resultado);
                    } else {
                        System.out.println("Erro: Não é possível dividir número por zero.");
                    }
                    break;
                default:
                    System.out.println("Operação inválida!");
                    break;
            }
        }
        scanner.close();
    }
}
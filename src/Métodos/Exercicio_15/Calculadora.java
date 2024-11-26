/* 15) Crie uma classe Calculadora que faça as operações de soma,
subtração, multiplicação, divisão e potenciação. Cada operação
deve ser um método e todos os métodos devem ser estáticos.
Para fazer a escolha das operações use como base o exercício 4 */

// Resolução:

package Métodos.Exercicio_15;

import java.util.Scanner;

public class Calculadora {

    private static double somar(double a, double b) {
        return a + b;
    }

    private static double subtrair(double a, double b) {
        return a - b;
    }

    private static double multiplicar(double a, double b) {
        return a * b;
    }

    private static double dividir(double a, double b) {
        if (b == 0) {
            System.out.println("Erro: não é possível dividir número por zero.");
            return Double.NaN;
        }
        return a / b;
    }

    private static double potencia(double a, double b) {
        return Math.pow(a, b);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha uma operação:");
        System.out.println("1- Soma");
        System.out.println("2- Subtração");
        System.out.println("3- Multiplicação");
        System.out.println("4- Divisão");
        System.out.println("5- Potenciação");
        System.out.println("Digite o número da operação: ");
        int operacao = scanner.nextInt();

        System.out.println("Digite o primeiro número: ");
        double num1 = scanner.nextDouble();

        System.out.println("Digite o segundo número: ");
        double num2 = scanner.nextDouble();

        double resultado;

        switch (operacao) {
            case 1:
                resultado = somar(num1, num2);
                System.out.println("Resultado da soma: " + resultado);
                break;
            case 2:
                resultado = subtrair(num1, num2);
                System.out.println("Resultado da subtração: " + resultado);
                break;
            case 3:
                resultado = multiplicar(num1, num2);
                System.out.println("Resultado da multiplicação: " + resultado);
                break;
            case 4:
                resultado = dividir(num1, num2);
                if (!Double.isNaN(resultado)) {
                    System.out.println("Resultado da divisão: " + resultado);
                }
                break;
            case 5:
                resultado = potencia(num1, num2);
                System.out.println("Resutlado da potenciação: " + resultado);
                break;
            default:
                System.out.println("Operação inválida! Escolha um número de 1 a 5.");
        }
        scanner.close();
    }
}

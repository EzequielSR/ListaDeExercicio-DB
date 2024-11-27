package Estrutura_de_Repetição.Exercicio_7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fibonacci {
    //Método que calcula sequência de Fibonacci até n
    public static List<Integer> calcularFibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Informe um número inteiro não negativo.");
        }

        //Lista e armazena a sequência
        List<Integer> serie = new ArrayList<>();

        //Adiciona os dois primeiros números da sequência de Fibonacci
        serie.add(0);
        if (n >= 1) serie.add(1);


        for (int i = 2; i <= n; i++) {
            int novoNumero = serie.get(i - 1) + serie.get(i - 2);
            serie.add(novoNumero);
        }
        return serie;
    }

    //Método para executar programa
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Bloco que garanti que o scanner seja fechado automaticamente
        try (scanner) {
            System.out.print("Informe um número inteiro não negativo: ");
            int numero = scanner.nextInt();
            List<Integer> serieFibonacci = calcularFibonacci(numero);

            //Exibe a sequência
            System.out.println("Série de Fibonacci até " + numero + ": " + serieFibonacci);
        } catch (IllegalArgumentException e) {
            //Captura e exibe a exceção se for inválido
            System.out.println(e.getMessage());
        }
    }
}

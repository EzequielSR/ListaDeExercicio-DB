package Estrutura_de_Repetição.Exercicio_7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fibonacci {

    public static List<Integer> calcularFibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Informe um número inteiro não negativo.");
        }

        List<Integer> serie = new ArrayList<>();

        if (n >= 0) serie.add(0);
        if (n >= 1) serie.add(1);

        for (int i = 2; i <= n; i++) {
            int novoNumero = serie.get(i - 1) + serie.get(i - 2);
            serie.add(novoNumero);
        }
        return serie;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe um número inteiro não negativo: ");
        int numero = scanner.nextInt();

        try {
            List<Integer> serieFibonacci = calcularFibonacci(numero);
            System.out.println("Série de Fibonacci até " + numero + ": " + serieFibonacci);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

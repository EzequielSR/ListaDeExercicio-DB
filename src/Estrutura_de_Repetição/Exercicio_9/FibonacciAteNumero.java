/* 9) Altere o exercício 7 para o algoritmo contar a série Fibonacci até
um determinado número. Por exemplo, caso declarado o número
25, o resultado seria: 0, 1, 1, 2, 3, 5, 8, 13, 21. */

// Resolução:

package Estrutura_de_Repetição.Exercicio_9;

import java.util.ArrayList;
import java.util.Scanner;

public class FibonacciAteNumero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número para calcular a série de Fibonnaci até esse número: ");
        int limite = scanner.nextInt();

        if (limite < 0) {
            System.out.println("Por favor, digite um número válido (não negativo).");
        } else {
            ArrayList<Integer> fibonnaci = calcularFibonacciAteNumero(limite);
            System.out.println("Série de Fibonacci até " + limite + ": " + fibonnaci);
        }
        scanner.close();
    }

    public static ArrayList<Integer> calcularFibonacciAteNumero(int limite) {
        ArrayList<Integer> fibonacci = new ArrayList<>();
        fibonacci.add(0);
        fibonacci.add(1);

        while (true) {
            int proximoNumero = fibonacci.get(fibonacci.size() - 1) + fibonacci.get(fibonacci.size() - 2);
            if (proximoNumero > limite) break;
            fibonacci.add(proximoNumero);
        }
        return fibonacci;
    }
}

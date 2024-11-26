/* 10) Leia uma matriz quadrada e determine a soma da diagonal
principal. */

// Resolução:

package Vetores_e_Matrizes.Exercicio_10;

import java.util.Scanner;

public class SomaDiagonalPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o tamanho da matriz quadrada: ");
        int tamanho = scanner.nextInt();

        int[][] matriz = new int[tamanho][tamanho];

        System.out.println("Digite os elementos da matriz:");
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                System.out.println("Elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }

        int somaDiagonal = calcularSomaNaDiagonalPrincipal(matriz);
        System.out.println("A soma da diagonal principal é: " + somaDiagonal);

        scanner.close();
    }

    public static int calcularSomaNaDiagonalPrincipal(int[][] matriz) {
        int soma = 0;
        for (int i = 0; i < matriz.length; i++) {
            soma += matriz[i][i];
        }
        return soma;
    }
}

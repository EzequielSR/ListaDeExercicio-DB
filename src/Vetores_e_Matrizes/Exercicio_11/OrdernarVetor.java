/* 11) Ordene um vetor de 100 números inteiros gerados
aleatoriamente. (Pesquisar sobre Bubble Sort) */

// Resolução:

package Vetores_e_Matrizes.Exercicio_11;

import java.util.Random;

public class OrdernarVetor {
    public static int[] gerarVetorAleatorio(int tamanho, int max) {
        int[] vetor = new int[tamanho];
        Random random = new Random();

        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt(max);
        }
        return vetor;
    }

    public static void bubbleSort(int[] vetor) {
        int n = vetor.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }
    }

    public static void imprimirVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int tamanho = 100;
        int max = 100;

        int[] vetor = gerarVetorAleatorio(tamanho, max);

        System.out.println("Vetor original:");
        imprimirVetor(vetor);

        bubbleSort(vetor);

        System.out.println("Vetor ordenado:");
        imprimirVetor(vetor);
    }
}

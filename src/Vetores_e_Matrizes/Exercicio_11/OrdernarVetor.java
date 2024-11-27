/* 11) Ordene um vetor de 100 números inteiros gerados
aleatoriamente. (Pesquisar sobre Bubble Sort) */

// Resolução:

package Vetores_e_Matrizes.Exercicio_11;

import java.util.Random;

public class OrdernarVetor {
    //Método que gera um vetor de números aleatórios
    public static int[] gerarVetorAleatorio(int tamanho, int max) {
        int[] vetor = new int[tamanho];
        Random random = new Random();

        //Preenche o vetor com números aleatórios entre 0 e 'max'
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt(max);
        }
        return vetor;
    }

    public static void bubbleSort(int[] vetor) {
        int n = vetor.length;
        //Laço para percorrer todos os elementos do vetor
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                //Se o elemento for maior que o próximo, troca-os de lugar
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }
    }
    //Método para imprimir o vetor
    public static void imprimirVetor(int[] vetor) {
        for (int j : vetor) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
    //Método que executa o código
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

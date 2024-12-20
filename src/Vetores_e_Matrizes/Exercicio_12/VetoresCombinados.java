/* 12) Crie dois vetores de 50 posições com valores inteiros aleatórios,
ordene cada vetor individualmente, e combine os dois vetores
gerando um novo vetor de 100 posições, ordenando esse novo. */

// Resolução:

package Vetores_e_Matrizes.Exercicio_12;

import java.util.Arrays;
import java.util.Random;

public class VetoresCombinados {
    //Método para gerar um vetor com números inteiros aleatórios e ordená-los
    public static int[] gerarEOrdernarVetor(int tamanho, int max) {
        Random random = new Random();
        int[] vetor = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt(max); //Gera número aleatório e insere no vetor
        }

        //Ordena o vetor
        Arrays.sort(vetor);
        return vetor;
    }


    public static void main(String[] args) {
        int tamanho = 50;
        int max = 100;

        //Gera e ordena o primeiro vetor
        int[] vetor1 = gerarEOrdernarVetor(tamanho, max);

        //Gera e ordena o segundo vetor
        int[] vetor2 = gerarEOrdernarVetor(tamanho, max);

        int[] vetorCombinado = new int[vetor1.length + vetor2.length];
        System.arraycopy(vetor1, 0, vetorCombinado, 0, vetor1.length);
        System.arraycopy(vetor2, 0, vetorCombinado, vetor1.length, vetor2.length);

        //Ordena o vetor combinado
        Arrays.sort(vetorCombinado);

        System.out.println("Vetor 1 ordenado: " + Arrays.toString(vetor1));
        System.out.println("Vetor 2 ordenado: " + Arrays.toString(vetor2));
        System.out.println("Vetor combinado e ordenado: " + Arrays.toString(vetorCombinado));
    }
}

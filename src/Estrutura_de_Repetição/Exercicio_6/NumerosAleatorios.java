/* 6) Gere 10 números aleatórios entre 0 e 100; mostre todos na tela
(em uma única linha); identifique o menor e o maior deles. */

// Resolução:

package Estrutura_de_Repetição.Exercicio_6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class NumerosAleatorios {

    public static void main(String[] args) {
        //Armazena os números aleatórios gerados
        List<Integer> numeros = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            //Gera o número aleatório de 0 a 100
            numeros.add(random.nextInt(101));
        }

        System.out.println("Números: " + numeros);

        int menor = Collections.min(numeros);
        int maior = Collections.max(numeros);

        System.out.println("Menor número: " + menor);
        System.out.println("Maior número: " + maior);
    }
}

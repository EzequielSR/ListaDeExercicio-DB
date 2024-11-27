/* 3) Implemente um jogo Jokenpo (Pedra, papel ou tesoura). Será o
jogador contra a máquina. O código tem que gerar as posições
aleatoriamente e comparar com o que escolhemos. */

// Resolução:

package Exercícios_Básicos.Exercicio_3;

import java.util.Random;
import java.util.Scanner;


public class Jokenpo {
    //Método para realizar a jogada, que compara a do jogador com a da máquina.
    public static String jogar(String escolhaJogador) {
        String[] opcoes = {"pedra", "papel", "tesoura"};

        Random random = new Random();
        String escolhaMaquina = opcoes[random.nextInt(opcoes.length)];

        System.out.println("Você escolheu " + escolhaJogador);
        System.out.println("A máquina escolheu: " + escolhaMaquina);

        if (escolhaJogador.equalsIgnoreCase(escolhaMaquina)) {
            return "Empate!";
        }

        //Verifica se o jogador ganhou
        if ((escolhaJogador.equalsIgnoreCase("pedra") && escolhaMaquina.equals("tesoura")) ||
                (escolhaJogador.equalsIgnoreCase("papel") && escolhaMaquina.equals("pedra")) ||
                (escolhaJogador.equalsIgnoreCase("tesoura") && escolhaMaquina.equals("papel"))) {
            return "Você ganhou!";
        }

        return "Você perdeu...";

    }

    // Método para executar o jogo
    public static void main(String[] args) {
        //Objeto que le a escolha do jogador
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha entre pedra, papel ou tesoura:");
        String escolhaJogador = scanner.nextLine();

        //Chama o método e exibe resultado
        System.out.println(jogar(escolhaJogador));

        scanner.close();
    }
}
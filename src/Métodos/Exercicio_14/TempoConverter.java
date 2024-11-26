/* 14) Leia do usuário o tempo em segundos e escreva em horas,
minutos e segundos. Utilize cinco métodos, para a leitura e escrita
de dados e para obtenção de horas, minutos e segundos a partir
do tempo em segundos.
Ex: 7023 segundos equivalem a 1h57min3seg */

// Resolução:

package Métodos.Exercicio_14;

import java.util.Scanner;

public class TempoConverter {
    private static int lerTempoSegundos(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o tempo em segundos: ");
        return scanner.nextInt();
    }

    private static int[] converterTempo(int segundos){
        int horas = segundos / 3600;
        int minutos = (segundos % 3600) / 60;
        int segundoRestantes = segundos % 60;
        return new int[]{horas, minutos, segundoRestantes};
    }

    private static void exibirResultado(int horas, int minutos, int segundos){
        System.out.println(horas + " hr " + minutos + " min " + segundos + " seg ");
    }

    public static void main(String[] args) {
        int tempoSegundos = lerTempoSegundos();

        int[] tempoConvertido = converterTempo(tempoSegundos);

        exibirResultado(tempoConvertido[0], tempoConvertido[1], tempoConvertido[2]);
    }
}

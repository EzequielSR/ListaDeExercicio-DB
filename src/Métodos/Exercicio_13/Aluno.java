// MÉTODOS

/* 13) Faça um método que calcule a média de um aluno de acordo
com o critério definido neste curso. Além disso, faça um outro
método que informe o status do aluno de acordo com a tabela a
seguir:
    - Nota acima de 6: “Aprovado”
- Nota entre 4 e 6: “Verificação Suplementar”
- Nota abaixo de 4: “Reprovado” */

package Métodos.Exercicio_13;

import java.util.Scanner;

public class Aluno {
    public static double calcularMedia(double[] notas){
        double soma = 0;
        for (double nota : notas){
            soma += nota;
        }
        return soma / notas.length;
    }

    public static String obterStatusAluno(double media){
        if(media > 6){
            return "Aprovado";
        }else if(media >= 4){
            return "Verificação Suplementar";
        }else{
            return "Reprovado";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantas notas você quer inserir? ");
        int numNotas = scanner.nextInt();

        double[] notas = new double[numNotas];

        for (int i = 0; i < numNotas; i++){
            System.out.print("Digite a nota " + (i + 1) + ": ");
            notas[i] = scanner.nextDouble();
        }

        double media = calcularMedia(notas);

        String status = obterStatusAluno(media);

        System.out.println("Média do aluno: " + String.format("%.2f", media));
        System.out.println("Status do aluno: " + status);

        scanner.close();
    }
}

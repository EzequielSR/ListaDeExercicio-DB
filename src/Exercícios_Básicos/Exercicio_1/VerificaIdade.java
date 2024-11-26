//USAR IF-ELSE NOS EXERCÍCIOS SEGUINTES
// 1) Definir a idade de uma pessoa e verificar se ela é maior de idade ou não.

//Resolução:
package Exercícios_Básicos.Exercicio_1;

import java.util.Scanner;

public class VerificaIdade {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Qual a sua idade: ");
        int idade = scanner.nextInt();

        if (idade >= 18) {
            System.out.println("Você é maior de idade");
        } else {
            System.out.println("Você ainda é menor de idade");
        }
        scanner.close();
    }
}

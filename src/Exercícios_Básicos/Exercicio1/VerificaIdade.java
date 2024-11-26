//USAR IF-ELSE NOS EXERCÍCIOS SEGUINTES
// 1) Definir a idade de uma pessoa e verificar se ela é maior de idade ou não.

//Resolução:
package Exercícios_Básicos.Exercicio1;

public class VerificaIdade {

    public static String verificarIdade(int idade) {
        if (idade >= 18) {
            return "Você é maior de idade";
        } else {
            return "Você ainda é menor de idade";
        }
    }

    // Teste da função
    public static void main(String[] args) {
        System.out.println(verificarIdade(17));
        System.out.println(verificarIdade(20));
        System.out.println(verificarIdade(18));
    }
}

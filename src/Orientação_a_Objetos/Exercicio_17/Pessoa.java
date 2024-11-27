/* 17) Faça um programa para representar a árvore genealógica de
uma família. Para tal crie uma classe Pessoa que permita indicar
além de nome e idade, o pai e a mãe. Tenha em mente que pai e
mãe também são do tipo Pessoa. */

//Resolução:

package Orientação_a_Objetos.Exercicio_17;

public class Pessoa {
    private final String nome;
    private final int idade;
    private final Pessoa pai;
    private final Pessoa mae;


    public Pessoa(String nome, int idade) {
        this(nome, idade, null, null);
    }


    public Pessoa(String nome, int idade, Pessoa pai, Pessoa mae) {
        this.nome = nome;
        this.idade = idade;
        this.pai = pai;
        this.mae = mae;
    }


    // Método para exibir detalhes da pessoa
    public void exibirDetalhes() {
        System.out.println("Nome: " + nome + ", Idade: " + idade);
        System.out.println("Pai: " + (pai != null ? pai.nome : "Desconhecido"));
        System.out.println("Mãe: " + (mae != null ? mae.nome : "Desconhecida"));
    }


    public static void main(String[] args) {
        Pessoa avoPaterno = new Pessoa("Rodolfo", 76);
        Pessoa avoMaterna = new Pessoa("Maria", 70);


        Pessoa pai = new Pessoa("Roberto", 40, avoPaterno, null);
        Pessoa mae = new Pessoa("Eduarda", 35, null, avoMaterna);


        Pessoa filho = new Pessoa("Pedro", 17, pai, mae);


        System.out.println("Detalhes do Filho:");
        filho.exibirDetalhes();


        System.out.println("\nDetalhes do Pai:");
        filho.pai.exibirDetalhes();


        System.out.println("\nDetalhes da Mãe:");
        filho.mae.exibirDetalhes();
    }
}


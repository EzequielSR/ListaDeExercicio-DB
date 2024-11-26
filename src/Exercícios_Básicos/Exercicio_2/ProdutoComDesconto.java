/* 2) Para cada produto informado (nome, preço e quantidade), escreva o
nome do produto comprado e o valor total a ser pago, considerando
que são oferecidos descontos pelo número de unidades compradas,
segundo a tabela abaixo:
    a. Até 10 unidades: valor total
    b. De 11 a 20 unidades: 10% de desconto
    c. De 21 a 50 unidades: 20% de desconto
    d. Acima de 50 unidades: 25% de desconto */

// Resolução:

package Exercícios_Básicos.Exercicio_2;

import java.util.ArrayList;
import java.util.List;

class Produto {
    String nome;
    int quantidade;
    double preco;


    public Produto(String nome, int quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }
}

public class ProdutoComDesconto {
    static List<Produto> produtos = new ArrayList<>();

    static {
        produtos.add(new Produto("Lápis", 10, 3.00));
        produtos.add(new Produto("Mochila", 21, 6.00));
        produtos.add(new Produto("Estojo", 50, 10.00));
        produtos.add(new Produto("Boné", 20, 20.00));

    }

    public static String calcularDesconto(String nome, int quantidade) {
        Produto produtoEncontrado = null;

        for (Produto produto : produtos) {
            if (produto.nome.equalsIgnoreCase(nome)) {
                produtoEncontrado = produto;
                break;
            }
        }
        if (produtoEncontrado == null) {
            return "Produto \"" + nome + "\" não foi encontrado.";
        }
        if (quantidade > produtoEncontrado.quantidade) {
            return "Quantidade solicitada para " + produtoEncontrado.nome +
                    " excede o número disponível de " + produtoEncontrado.quantidade + " unidades.";
        }

        double valorTotal = produtoEncontrado.preco * quantidade;
        double
                desconto = 0;

        if (quantidade == 10) {
            desconto = 0;
        } else if (quantidade >= 11 && quantidade <= 20) {
            desconto = 0.10;
        } else if (quantidade >= 21 && quantidade <= 50) {
            desconto = 0.20;
        } else if (quantidade > 50) {
            desconto = 0.25;
        }

        double valorComDesconto = valorTotal * (1 - desconto);

        return "Produto: " + produtoEncontrado.nome + ", Quantidade: " + quantidade +
                ", Valor Total: R$ " + String.format("%.2f", valorComDesconto);

    }

    // Teste de produtos
    public static void main(String[] args) {
        System.out.println(calcularDesconto("Lápis", 9));
        System.out.println(calcularDesconto("Mochila", 21));
        System.out.println(calcularDesconto("Estojo", 60));
    }
}

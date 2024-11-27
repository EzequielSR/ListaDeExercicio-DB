// PROVA

/* 20) O projeto SuperMercadoProva simula o sistema de
gerenciamento de vendas de um supermercado, com controle de
estoque, verificação da existência produtos escolhidos no pedido
e demais funcionalidades descritas no diagrama de classes do
mesmo. A prova consiste na resolução de três tarefas, são elas:

a. Corrigir o bug. (fácil)
b. Desenvolver um método onde receba um valor e retorne o
troco. (médio)
c. Desenvolver um método onde recebe o valor do troco e
calcule a menor quantidade de notas. (difícil) */

// Resolução:

package Orientação_a_Objetos.Prova_20;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Produto {
    private final int id;
    private final String nome;
    private final double preco;
    private int quantidadeEmEstoque;

    public Produto(int id, String nome, double preco, int QuantidadeEmEstoque) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = QuantidadeEmEstoque;
    }

    public boolean reduzirEstoque(int quantidade) {
        if (quantidade <= this.quantidadeEmEstoque) {
            this.quantidadeEmEstoque -= quantidade;
            return true;
        } else {
            return false;
        }
    }

    public void exibirDetalhes() {
        System.out.printf("Produto: %s | Preço: R$%.2f | Em estoque: %d%n", nome, preco, quantidadeEmEstoque);
    }

    public int getId() {
        return id;
    }

    public double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }
}

class Estoque {
    private final List<Produto> listaDeProdutos;

    public Estoque() {
        this.listaDeProdutos = new ArrayList<>();
        inicializarEstoque();
    }

    private void inicializarEstoque() {
        listaDeProdutos.add(new Produto(1, "Arroz", 5.50, 50));
        listaDeProdutos.add(new Produto(2, "Feijão", 4.75, 30));
        listaDeProdutos.add(new Produto(3, "Açúcar", 3.00, 20));
    }

    public Produto encontrarProdutoPeloId(int id) {
        return listaDeProdutos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public void mostrarEstoque() {
        System.out.println("---------- Estoque ----------");
        listaDeProdutos.forEach(Produto::exibirDetalhes);
        System.out.println("-----------------------------");

    }
}

class Item {
    private final Produto produto;
    private final int quantidade;
    private final double valorDoItem;

    public Item(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorDoItem = produto.getPreco() * quantidade;
    }

    public void exibirDetalhes() {
        System.out.printf("%s | Quantidade: %d | Valor do Item: R$%.2f%n", produto.getNome(), quantidade, valorDoItem);
    }

    public double getValorDoItem() {
        return valorDoItem;
    }
}

class Pedido {
    private final List<Item> listaDeItens;
    private double valorTotalDoPedido;

    public Pedido() {
        this.listaDeItens = new ArrayList<>();
        this.valorTotalDoPedido = 0;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        if (produto.reduzirEstoque(quantidade)) {
            Item item = new Item(produto, quantidade);
            listaDeItens.add(item);
            valorTotalDoPedido += item.getValorDoItem();
            System.out.println("\n✅ Produto adicionado com sucesso!");
        } else {
            System.out.printf("❌ Quantidade insuficiente em estoque para o produto: %s%n", produto.getNome());
        }
    }

    public void exibirPedido() {
        System.out.println("---------- Pedido ----------");
        listaDeItens.forEach(Item::exibirDetalhes);
        System.out.printf("\n🛒 Valor Total do Pedido: R$%.2f%n", valorTotalDoPedido);
        System.out.println("----------------------------");
    }

    public double calcularTroco(double valorPago) {
        if (valorPago < valorTotalDoPedido) {
            System.out.println("\n❌ Valor insuficiente para completar o pedido.");
            return 0;
        }
        return valorPago - valorTotalDoPedido;
    }

    public void calcularMenorQuantidadeDeNotas(double troco) {
        int[] notas = {100, 50, 20, 10, 5, 2, 1};
        int[] quantidadeDeNotas = new int[notas.length];

        int valorEmInteiro = (int) troco;

        for (int i = 0; i < notas.length; i++) {
            if (valorEmInteiro >= notas[i]) {
                quantidadeDeNotas[i] = valorEmInteiro / notas[i];
                valorEmInteiro %= notas[i];
            }
        }

        System.out.printf("\n💵 Troco: R$%.2f%n", troco);
        for (int i = 0; i < notas.length; i++) {
            if (quantidadeDeNotas[i] >= 0) {
                System.out.printf("Nota de R$%d: %d%n", notas[i], quantidadeDeNotas[i]);
            }
        }

    }
}

public class SuperMercadoProva {
    private final Estoque estoque;
    private final Pedido pedido;

    public SuperMercadoProva() {
        this.estoque = new Estoque();
        this.pedido = new Pedido();
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Mostrar Estoque");
            System.out.println("2. Adicionar Produto ao Pedido");
            System.out.println("3. Exibir Pedido");
            System.out.println("4. Finalizar Pedido e Calcular Troco");
            System.out.println("5. Sair");
            System.out.println("\n==========================");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    estoque.mostrarEstoque();
                    break;
                case 2:
                    System.out.print("\nDigite o ID do produto: ");
                    int id = scanner.nextInt();
                    Produto produto = estoque.encontrarProdutoPeloId(id);
                    if (produto != null) {
                        System.out.print("Digite a quantidade: ");
                        int quantidade = scanner.nextInt();
                        pedido.adicionarItem(produto, quantidade);
                    } else {
                        System.out.println("❌ Produto não encontrado.");
                    }
                    break;
                case 3:
                    pedido.exibirPedido();
                    break;
                case 4:
                    System.out.print("Digite o valor pago pelo cliente: R$");
                    double valorPago = scanner.nextDouble();
                    double troco = pedido.calcularTroco(valorPago);

                    if (troco > 0) {
                        System.out.printf("Troco a ser devolvido: R$%.2f%n", troco);
                        pedido.calcularMenorQuantidadeDeNotas(troco);
                    }
                    break;
                case 5:
                    System.out.println("👋 Obrigado por usar o sistema! Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("❌ Opção inválida.");
            }
        }
    }

    public static void main(String[] args) {
        SuperMercadoProva supermercado = new SuperMercadoProva();
        supermercado.iniciar();
    }
}

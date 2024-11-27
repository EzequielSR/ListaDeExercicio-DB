// ORIENTAÇÃO A OBJETOS

/* 16) Faça um programa para controle de empréstimo de livros, com
as classes Emprestimo, Livro e Pessoa. */

// Resolução:

package Orientação_a_Objetos.Exercicio_16;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


class Emprestimo {
    private final Pessoa pessoa;
    private final Livro livro;
    private final Date dataEmprestimo;


    public Emprestimo(Pessoa pessoa, Livro livro) {
        this.pessoa = pessoa;
        this.livro = livro;
        this.dataEmprestimo = new Date();
    }


    public void realizarEmprestimo() {
        if (this.livro.emprestar()) {
            this.pessoa.emprestarLivro(this.livro);
            System.out.println("--------------------");
            System.out.println("Empréstimo realizado com sucesso para " + this.pessoa.getNome() + ": " +
                    this.livro.getTitulo() + " de " + this.livro.getAutor());
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println("Data do empréstimo: " + sdf.format(this.dataEmprestimo));
        } else {
            System.out.println("--------------------");
            System.out.println("O livro " + this.livro.getTitulo() + " de " + this.livro.getAutor() +
                    " não está disponível para empréstimo");
        }
    }


    public void realizarDevolucao() {
        if (this.pessoa.temLivroEmprestado(this.livro)) {
            this.livro.devolver();
            this.pessoa.devolverLivro(this.livro.getIsbn());
            System.out.println("------------------------");
            System.out.println("O livro " + this.livro.getTitulo() + " de " + this.livro.getAutor() +
                    " foi devolvido com sucesso");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println("Data do empréstimo foi: " + sdf.format(this.dataEmprestimo));
        } else {
            System.out.println("------------------------");
            System.out.println("O livro " + this.livro.getTitulo() + " de " + this.livro.getAutor() +
                    " não foi encontrado entre os livros emprestados.");
        }
    }
}


class Livro {
    private final String titulo;
    private final String autor;
    private final String isbn;
    private boolean disponivel;


    public Livro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponivel = true;
    }


    public boolean emprestar() {
        if (this.disponivel) {
            this.disponivel = false;
            return true;
        } else {
            return false;
        }
    }


    public void devolver() {
        this.disponivel = true;
    }


    public String getTitulo() {
        return titulo;
    }


    public String getAutor() {
        return autor;
    }


    public String getIsbn() {
        return isbn;
    }
}


class Pessoa {
    private final String nome;
    private final ArrayList<Livro> livrosEmprestados;


    public Pessoa(String nome) {
        this.nome = nome;
        this.livrosEmprestados = new ArrayList<>();
    }


    public void emprestarLivro(Livro livro) {
        this.livrosEmprestados.add(livro);
    }


    public void devolverLivro(String isbn) {
        this.livrosEmprestados.removeIf(livro -> livro.getIsbn().equals(isbn));
    }


    public String getNome() {
        return nome;
    }


    public ArrayList<Livro> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public boolean temLivroEmprestado(Livro livro) {
        for (Livro livroEmprestado : livrosEmprestados) {
            if (livroEmprestado.getIsbn().equals(livro.getIsbn())) {
                return true;
            }
        }
        return false;
    }
}


public class Biblioteca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Livro livro1 = new Livro("Clean Code", "Robert Cecil Martin", "123456");
        Livro livro2 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", "654321");


        System.out.print("Digite o nome da pessoa: ");
        String nomePessoa = scanner.nextLine();
        Pessoa pessoa1 = new Pessoa(nomePessoa);


        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1 - Realizar empréstimo");
            System.out.println("2 - Realizar devolução");
            System.out.println("3 - Ver livros emprestados");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();


            switch (opcao) {
                case 1:
                    System.out.println("\nEscolha um livro para empréstimo:");
                    System.out.println("1 - " + livro1.getTitulo() + " de " + livro1.getAutor());
                    System.out.println("2 - " + livro2.getTitulo() + " de " + livro2.getAutor());
                    System.out.print("Escolha uma opção: ");
                    int escolhaLivro = scanner.nextInt();
                    scanner.nextLine();


                    Emprestimo emprestimo;
                    if (escolhaLivro == 1) {
                        emprestimo = new Emprestimo(pessoa1, livro1);
                    } else {
                        emprestimo = new Emprestimo(pessoa1, livro2);
                    }
                    emprestimo.realizarEmprestimo();
                    break;


                case 2:
                    System.out.println("\nEscolha um livro para devolução:");
                    System.out.println("1 - " + livro1.getTitulo() + " de " + livro1.getAutor());
                    System.out.println("2 - " + livro2.getTitulo() + " de " + livro2.getAutor());
                    System.out.print("Escolha uma opção: ");
                    int escolhaDevolucao = scanner.nextInt();
                    scanner.nextLine();


                    Emprestimo devolucao;
                    if (escolhaDevolucao == 1) {
                        devolucao = new Emprestimo(pessoa1, livro1);
                    } else {
                        devolucao = new Emprestimo(pessoa1, livro2);
                    }
                    devolucao.realizarDevolucao();
                    break;


                case 3:
                    System.out.println("\nLivros emprestados por " + pessoa1.getNome() + ":");
                    for (Livro livro : pessoa1.getLivrosEmprestados()) {
                        System.out.println(livro.getTitulo() + " de " + livro.getAutor());
                    }
                    break;


                case 4:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;


                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}


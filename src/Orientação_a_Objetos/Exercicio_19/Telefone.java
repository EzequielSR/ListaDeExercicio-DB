/* 19) Implemente um sistema de agenda telefônica. Faça (ao menos)
as interações de adicionar e deletar números. */

// Resolução:

package Orientação_a_Objetos.Exercicio_19;

import java.util.ArrayList;
import java.util.List;

class Contato {
    private final String nome;
    private final String telefone;

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }


    @Override
    public String toString() {
        return nome + " - " + telefone;
    }
}

class AgendaTelefonica {
    private final List<Contato> contatos;

    public AgendaTelefonica() {
        this.contatos = new ArrayList<>();
    }

    public void adicionarContato(String nome, String telefone) {
        Contato novoContato = new Contato(nome, telefone);
        contatos.add(novoContato);
        System.out.println("Contato adicionado: " + novoContato);
    }

    public void deletarContato(String nome) {
        Contato contatoEncontrado = null;
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                contatoEncontrado = contato;
                break;
            }
        }

        if (contatoEncontrado != null) {
            contatos.remove(contatoEncontrado);
            System.out.println("Contato removido: " + contatoEncontrado);
        } else {
            System.out.println("Contato com nome \"" + nome + "\" não foi encontrado.");
        }
    }

    public void listarContatos() {
        System.out.println("\n---------- Lista de Contatos ----------");
        if (contatos.isEmpty()) {
            System.out.println("A agenda está vazia.");
        } else {
            int index = 1;
            for (Contato contato : contatos) {
                System.out.println(index++ + ". " + contato);
            }
        }
        System.out.println("---------------------------------------");
    }
}

public class Telefone {
    public static void main(String[] args) {
        AgendaTelefonica minhaAgenda = new AgendaTelefonica();

        minhaAgenda.adicionarContato("Juliana", "1234-5678");
        minhaAgenda.adicionarContato("Felipe", "9876-5432");

        minhaAgenda.listarContatos();

        minhaAgenda.deletarContato("Juliana");
        minhaAgenda.deletarContato("Roberta");

        minhaAgenda.listarContatos();
    }
}



package Orientação_a_Objetos.Exercicio_18;

abstract class Automovel {
    private final String marca;
    private final String modelo;
    private final int ano;
    private boolean ligado;


    public Automovel(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.ligado = false;
    }


    public void ligar() {
        if (!ligado) {
            ligado = true;
            System.out.println(modelo + " está ligado.");
        } else {
            System.out.println(modelo + " já está ligado.");
        }
    }


    public void desligar() {
        if (ligado) {
            ligado = false;
            System.out.println(modelo + " está desligado.");
        } else {
            System.out.println(modelo + " já está desligado.");
        }
    }


    public void exibirDetalhes() {
        System.out.println("Marca: " + marca + ", Modelo: " + modelo + ", Ano: " + ano);
    }


    public String getModelo() {
        return modelo;
    }
}


class Carro extends Automovel {
    private final int numeroPortas;


    public Carro(String marca, String modelo, int ano, int numeroPortas) {
        super(marca, modelo, ano);
        this.numeroPortas = numeroPortas;
    }


    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Portas: " + numeroPortas);
    }
}


class CarroAutomatico extends Carro {
    private boolean freioPressionado;


    public CarroAutomatico(String marca, String modelo, int ano, int numeroPortas) {
        super(marca, modelo, ano, numeroPortas);
        this.freioPressionado = false;
    }


    public void pressionarFreio() {
        this.freioPressionado = true;
        System.out.println("Freio pressionado.");
    }


    @Override
    public void ligar() {
        if (freioPressionado) {
            super.ligar();
        } else {
            System.out.println("Não é possível ligar o carro. Pressione o freio.");
        }
    }
}


class Moto extends Automovel {
    public Moto(String marca, String modelo, int ano) {
        super(marca, modelo, ano);
    }
}


class MotoPartidaPedal extends Moto {
    private boolean aceleradorPuxado;


    public MotoPartidaPedal(String marca, String modelo, int ano) {
        super(marca, modelo, ano);
        this.aceleradorPuxado = false;
    }


    public void puxarAcelerador() {
        this.aceleradorPuxado = true;
        System.out.println("Acelerador puxado.");
    }


    @Override
    public void ligar() {
        if (aceleradorPuxado) {
            super.ligar();
        } else {
            System.out.println("Não é possível ligar a moto. Puxe o acelerador.");
        }
    }
}


class Guincho extends Automovel {
    private final int capacidade;


    public Guincho(String marca, String modelo, int ano, int capacidade) {
        super(marca, modelo, ano);
        this.capacidade = capacidade;
    }


    public void carregar(Automovel veiculo) {
        if (veiculo != null) {
            System.out.println(veiculo.getModelo() + " foi carregado pelo guincho.");
        } else {
            System.out.println("Somente automóveis podem ser carregados.");
        }
    }


    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Capacidade do guincho: " + capacidade + " toneladas.");
    }
}


public class Automoveis {
    public static void main(String[] args) {
        System.out.println("---------- Carro ----------");
        CarroAutomatico meuCarro = new CarroAutomatico("Toyota", "Corolla", 2022, 4);
        meuCarro.ligar();
        meuCarro.pressionarFreio();
        meuCarro.ligar();
        meuCarro.desligar();


        System.out.println("\n---------- Moto ----------");
        MotoPartidaPedal minhaMoto = new MotoPartidaPedal("Yamaha", "MT-07", 2021);
        minhaMoto.ligar();
        minhaMoto.puxarAcelerador();
        minhaMoto.ligar();
        minhaMoto.desligar();


        System.out.println("\n---------- Guincho ----------");
        Guincho oGuincho = new Guincho("Volvo", "FH16", 2020, 15);
        oGuincho.carregar(meuCarro);
        oGuincho.carregar(minhaMoto);
        oGuincho.ligar();
        oGuincho.desligar();
    }
}


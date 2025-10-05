package org.example;

public class Plano {

    private String nome;
    private String descricao;
    private double velocidade;
    private double preco;

    public Plano(String nome, String descricao, double velocidade, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.velocidade = velocidade;
        this.preco = preco;
    }

    public void atualizarPreco(double novoPreco) {
        this.preco = novoPreco;
    }

    public void atualizarVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    public String detalhesPlano() {
        return String.format("Plano: %s\nVelocidade: %.2f Mbps\nPreço: R$ %.2f",
                nome, velocidade, preco);
    }

}

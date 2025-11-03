package org.example.controller;

import java.util.Scanner;

public class Plano {

    private String nome;
    private String descricao;
    private double velocidade;
    private double preco;

    public Plano() {

    }

    public Plano(String nome, String descricao, double velocidade, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.velocidade = velocidade;
        this.preco = preco;
    }

    public void cadastrar() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Nome: ");
        this.nome = sc.nextLine();

        System.out.println("Descrição: ");
        this.descricao = sc.nextLine();

        System.out.println("Velocidade: ");
        this.velocidade = sc.nextDouble();

        System.out.println("Preço: ");
        this.preco = sc.nextDouble();

    }

    public void atualizarPreco(double novoPreco) {
        this.preco = novoPreco;
    }

    public void atualizarVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    public static void atualizarDados() {

        System.out.println("Selecione o plano: ");
        System.out.println("Nome: ");

        Scanner sc = new Scanner(System.in);

        String nome = sc.nextLine();

        // LÓGICA PARA PESQUISAR O PLANO

        // Dados mockados ---------------
        Plano plano = new Plano("Teste", "Teste", 1, 1);
        // ------------------------------

        System.out.println("Dados do plano selecionado");
        System.out.println(plano);

        System.out.println("Nome: ");
        plano.nome = sc.nextLine();
        System.out.println("Descrição: ");
        plano.descricao = sc.nextLine();
        System.out.println("Velocidade: ");
        plano.velocidade = sc.nextDouble();
        System.out.println("Preço: ");
        plano.preco = sc.nextDouble();

        // LÓGICA DO BANCO DE DADOS
    }

    public String detalhesPlano() {
        return String.format("Plano: %s\nVelocidade: %.2f Mbps\nPreço: R$ %.2f",
                nome, velocidade, preco);
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return String.format("%nNome: %s %nDescrição: %s %nVelocidade: %.2f %nPreço: %.2f%n", nome, descricao, velocidade, preco);
    }
}

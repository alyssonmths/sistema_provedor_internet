package org.example.Controller;

import java.util.List;
import java.util.Scanner;

public class Cliente {

    private String nome;
    private String endereco;
    private String contato;
    private Plano plano;
    private List<Equipamento> equipamentos;

    public Cliente() {

    }

    public Cliente(String nome, String endereco, String contato, Plano plano) {
        this.nome = nome;
        this.endereco = endereco;
        this.contato = contato;
        this.plano = plano;
    }

    public void cadastrar() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Nome: ");
        this.nome = sc.nextLine();

        System.out.println("Endereço: ");
        this.endereco = sc.nextLine();

        System.out.println("Contato: ");
        this.contato = sc.nextLine();

        System.out.println("Plano: ");
        this.plano = new Plano("Teste", "Teste", 1, 1);

        // LOGICA DO BANCO DE DADOS


    }

    public void atualizarContato(String novoContato) {
        this.contato = novoContato;
    }

    public void atualizarEndereco(String novoEndereco) {
        this.endereco = novoEndereco;
    }

    public void associarPlano(Plano plano) {
        this.plano = plano;
    }

    public void adicionarEquipamento(Equipamento equipamento) {
        equipamentos.add(equipamento);
    }

    public void removerEquipamento(Equipamento equipamento) {
        equipamentos.remove(equipamento);
    }

    public void listarEquipamentos() {
        //
    }

    public static void atualizarDados() {

        System.out.println("Selecione o cliente: ");
        System.out.println("Nome: ");

        Scanner sc = new Scanner(System.in);

        String nomeCliente = sc.nextLine();

        // LÓGICA PARA PESQUISAR O CLIENTE

        Plano plano = new Plano("Teste", "Teste", 1, 1);
        Cliente cliente = new Cliente("José", "Rua Tereza", "28913822", plano);

        System.out.println("Dados do cliente selecionado");

        System.out.println(cliente);

        System.out.println("Nome: ");
        cliente.nome = sc.nextLine();

        System.out.println("Endereço: ");
        cliente.endereco = sc.nextLine();

        System.out.println("Contato: ");
        cliente.contato = sc.nextLine();

        System.out.println("Plano: ");
        cliente.plano = new Plano("Teste", "Teste", 1, 1);

        // LÓGICA DO BANCO DE DADOS


    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return String.format("%nNome: %s %nEndereço: %s %nContato: %s %nPlano: %s%n", nome, endereco, contato, plano.getNome());
    }
}

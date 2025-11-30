package org.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque {

    private String nome;
    private String descricao;
    private int quantidade;
    private List<Equipamento> equipamentos = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void consultar() {

        System.out.printf("+----+------------------------------+------------------------------------------+%n");
        System.out.printf("| %-2s | %-28s | %-40s |%n", "ID", "Tipo", "Disponível?");
        System.out.printf("+----+------------------------------+------------------------------------------+%n");

        int id = 1;
        for (Equipamento equipamento : this.equipamentos) {
            System.out.printf("| %-2d | %-28s | %-40s |%n",
                    id++,
                    equipamento.tipo,
                    equipamento.estaDisponivel() ? "Sim" : "Não"
            );
        }

        System.out.printf("+----+------------------------------+------------------------------------------+%n");

    }

    public void adicionarEquipamento(Equipamento e) {
        equipamentos.add(e);
        atualizarQuantidade();
    }

    public void removerEquipamento(int id) {
        equipamentos.removeIf(e -> e.id == id);
        atualizarQuantidade();
    }

    public void atualizarQuantidade() {
        this.quantidade = equipamentos.size();
    }

    public int verificarQuantidade() {
        return this.quantidade;
    }

    public void registrarSaida() {
        if (equipamentos.isEmpty()) {
            System.out.println("\nNenhum equipamento cadastrado no estoque.");
            return;
        }

        // Filtrar apenas equipamentos disponíveis
        List<Equipamento> equipamentosDisponiveis = new ArrayList<>();
        for (Equipamento equipamento : this.equipamentos) {
            if (equipamento.estaDisponivel()) {
                equipamentosDisponiveis.add(equipamento);
            }
        }

        if (equipamentosDisponiveis.isEmpty()) {
            System.out.println("\nNenhum equipamento disponível para saída.");
            return;
        }

        System.out.println("\nEquipamentos disponíveis para saída:");
        System.out.printf("+----+------------------------------+------------------------------------------+%n");
        System.out.printf("| %-2s | %-28s | %-40s |%n", "ID", "Tipo", "Disponível?");
        System.out.printf("+----+------------------------------+------------------------------------------+%n");

        int indice = 1;
        for (Equipamento equipamento : equipamentosDisponiveis) {
            System.out.printf("| %-2d | %-28s | %-40s |%n",
                    indice++,
                    equipamento.tipo,
                    equipamento.estaDisponivel() ? "Sim" : "Não"
            );
        }
        System.out.printf("+----+------------------------------+------------------------------------------+%n");

        System.out.println("\nSelecione o equipamento pelo número da lista: ");
        int escolha = sc.nextInt();
        sc.nextLine();

        if (escolha < 1 || escolha > equipamentosDisponiveis.size()) {
            System.out.println("Número inválido!");
            return;
        }

        Equipamento equipamentoSelecionado = equipamentosDisponiveis.get(escolha - 1);
        equipamentoSelecionado.marcarComoEntregue();

        System.out.println("\nSaída registrada com sucesso!");
        System.out.println("Equipamento: " + equipamentoSelecionado.tipo);
        System.out.println("Status: Não disponível (entregue)");
    }

}

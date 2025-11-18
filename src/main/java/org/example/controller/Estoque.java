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

}

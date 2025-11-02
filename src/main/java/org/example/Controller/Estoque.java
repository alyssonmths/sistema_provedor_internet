package org.example.Controller;

import java.util.List;
import java.util.Scanner;

public class Estoque {

    private String nome;
    private String descricao;
    private int quantidade;
    private List<Equipamento> equipamentos;
    Scanner sc = new Scanner(System.in);

    public void consultarEstoque() {

        System.out.printf("+----+------------------------------+------------------------------------------+--------------------------+%n");
        System.out.printf("| %-2s | %-28s | %-40s | %-24s |%n", "ID", "Nome", "Descrição", "Quantidade");
        System.out.printf("+----+------------------------------+------------------------------------------+--------------------------+%n");

        for (Equipamento equipamento : this.equipamentos) {
            System.out.println(equipamento);
        }

        System.out.printf("+----+------------------------------+------------------------------------------+--------------------------+%n");

    }

    public void adicionarEquipamento() {

        Equipamento e = new Equipamento();

        System.out.println("ID: ");
        e.id = sc.nextInt();

        System.out.println("Tipo: ");
        e.tipo = sc.nextLine();

        System.out.println("Entregue: ");
        e.entregue = sc.nextBoolean();

        equipamentos.add(e);
        atualizarQuantidade();
    }

    public void removerEquipamento(Equipamento e) {
        equipamentos.remove(e);
        atualizarQuantidade();
    }

    public void atualizarQuantidade() {
        this.quantidade = equipamentos.size();
    }

    public int verificarQuantidade() {
        return this.quantidade;
    }

}

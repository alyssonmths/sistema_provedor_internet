package org.example;

import java.util.List;

public class Estoque {
    private String nome;
    private String descricao;
    private int quantidade;
    private List<Equipamento> equipamentos;

    public void adicionarEquipamento(Equipamento e) {
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

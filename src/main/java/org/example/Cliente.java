package org.example;

import java.util.List;

public class Cliente {

    private String nome;
    private String endereco;
    private String contato;
    private Plano plano;
    private List<Equipamento> equipamentos;

    public Cliente(String nome, String endereco, String contato, Plano plano) {
        this.nome = nome;
        this.endereco = endereco;
        this.contato = contato;
        this.plano = plano;
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

    public String resumoCliente() {
        return "a";
    }

}

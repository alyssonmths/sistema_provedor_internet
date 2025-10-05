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

    public Plano getPlano() {
        return plano;
    }
}

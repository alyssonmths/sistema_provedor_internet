package org.example.Controller;

public class Equipamento {

    public int id;
    public String tipo;
    public boolean entregue;

    public Equipamento() {

    }

    public Equipamento(int id, String tipo, boolean entregue) {
        this.id = id;
        this.tipo = tipo;
        this.entregue = entregue;
    }

    public void marcarComoEntregue() {
        this.entregue = true;
    }

    public void marcarComoDisponivel() {
        this.entregue = false;
    }

    public boolean estaDisponivel() {
        return !entregue;
    }

    public String detalhesEquipamento() {
        return String.format("Equipamento #%d - Tipo: %s - Disponível: %s",
                id, tipo, estaDisponivel() ? "Sim" : "Não");
    }

}

package org.example;

public class Equipamento {

    private int id;
    private String tipo;
    private boolean entregue;

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

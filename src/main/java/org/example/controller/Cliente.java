package org.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.controller.Plano.carregarPlanosDoArquivo;

public class Cliente {

    private String nome;
    private String endereco;
    private String contato;
    private Plano plano;
    private List<Equipamento> equipamentos = new ArrayList<>();

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

        // Carregar planos do arquivo
        List<Plano> planosDisponiveis = carregarPlanosDoArquivo();

        System.out.println("\nPlanos disponíveis:");
        System.out.println("+----+----------------+------------------------------------------+-------------+----------+");
        System.out.printf("| %-2s | %-14s | %-40s | %-11s | %-8s |%n", "ID", "Nome", "Descrição", "Velocidade", "Preço");
        System.out.println("+----+----------------+------------------------------------------+-------------+----------+");

        for (Plano plano : planosDisponiveis) {
            System.out.printf("| %-2d | %-14s | %-40s | %-11.0f Mbps | R$ %-6.2f |%n",
                    plano.getId(),
                    plano.getNome(),
                    plano.getDescricao().length() > 40 ? plano.getDescricao().substring(0, 37) + "..." : plano.getDescricao(),
                    plano.getVelocidade(),
                    plano.getPreco());
        }
        System.out.println("+----+----------------+------------------------------------------+-------------+----------+");

        System.out.println("\nSelecione o ID do plano desejado: ");
        int idPlanoEscolhido = sc.nextInt();
        sc.nextLine();

        Plano planoEscolhido = null;
        for (Plano plano : planosDisponiveis) {
            if (plano.getId() == idPlanoEscolhido) {
                planoEscolhido = plano;
                break;
            }
        }

        if (planoEscolhido != null) {
            this.plano = planoEscolhido;
            System.out.println("Plano " + planoEscolhido.getNome() + " selecionado com sucesso!");
        }

    }

    public static void atualizarDados(List<Cliente> clientes) {

        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado no sistema.");
            return;
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("\nClientes cadastrados:");
        System.out.println("+----+------------------------------+");
        System.out.printf("| %-2s | %-28s |%n", "ID", "Nome");
        System.out.println("+----+------------------------------+");
        
        for (int i = 0; i < clientes.size(); i++) {
            System.out.printf("| %-2d | %-28s |%n", i + 1, clientes.get(i).getNome());
        }
        System.out.println("+----+------------------------------+");

        System.out.println("\nSelecione o cliente pelo ID: ");
        int idCliente = sc.nextInt();
        sc.nextLine();

        if (idCliente < 1 || idCliente > clientes.size()) {
            System.out.println("ID de cliente inválido!");
            return;
        }

        Cliente cliente = clientes.get(idCliente - 1);

        System.out.println("\nDados atuais do cliente selecionado:");
        System.out.println(cliente);

        System.out.println("\nDigite os novos dados (pressione Enter para manter o valor atual):");

        System.out.println("Nome [" + cliente.getNome() + "]: ");
        String novoNome = sc.nextLine();
        if (!novoNome.trim().isEmpty()) {
            cliente.nome = novoNome;
        }

        System.out.println("Endereço [" + cliente.getEndereco() + "]: ");
        String novoEndereco = sc.nextLine();
        if (!novoEndereco.trim().isEmpty()) {
            cliente.endereco = novoEndereco;
        }

        System.out.println("Contato [" + cliente.getContato() + "]: ");
        String novoContato = sc.nextLine();
        if (!novoContato.trim().isEmpty()) {
            cliente.contato = novoContato;
        }

        System.out.println("\nDeseja alterar o plano? (s/n): ");
        String alterarPlano = sc.nextLine();

        if (alterarPlano.equalsIgnoreCase("s")) {
            List<Plano> planosDisponiveis = carregarPlanosDoArquivo();

            System.out.println("\nPlanos disponíveis:");
            System.out.println("+----+----------------+------------------------------------------+-------------+----------+");
            System.out.printf("| %-2s | %-14s | %-40s | %-11s | %-8s |%n", "ID", "Nome", "Descrição", "Velocidade", "Preço");
            System.out.println("+----+----------------+------------------------------------------+-------------+----------+");

            for (Plano plano : planosDisponiveis) {
                System.out.printf("| %-2d | %-14s | %-40s | %-11.0f Mbps | R$ %-6.2f |%n",
                        plano.getId(),
                        plano.getNome(),
                        plano.getDescricao().length() > 40 ? plano.getDescricao().substring(0, 37) + "..." : plano.getDescricao(),
                        plano.getVelocidade(),
                        plano.getPreco());
            }
            System.out.println("+----+----------------+------------------------------------------+-------------+----------+");

            System.out.println("\nSelecione o ID do novo plano: ");
            int idPlanoEscolhido = sc.nextInt();
            sc.nextLine();

            Plano planoEscolhido = null;
            for (Plano plano : planosDisponiveis) {
                if (plano.getId() == idPlanoEscolhido) {
                    planoEscolhido = plano;
                    break;
                }
            }

            if (planoEscolhido != null) {
                cliente.plano = planoEscolhido;
                System.out.println("Plano " + planoEscolhido.getNome() + " atualizado com sucesso!");
            } else {
                System.out.println("ID de plano inválido. Plano não alterado.");
            }
        }

        System.out.println("\nDados do cliente atualizados com sucesso!");
        System.out.println(cliente);

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
        if (equipamentos.isEmpty()) {
            System.out.println("Nenhum equipamento associado.");
            return;
        }

        System.out.println("Equipamentos do cliente " + nome + ":");
        for (Equipamento e : equipamentos) {
            System.out.println("- " + e);
        }
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getContato() {
        return contato;
    }

    public Plano getPlano() {
        return plano;
    }

    @Override
    public String toString() {
        return String.format("%nNome: %s %nEndereço: %s %nContato: %s %nPlano: %s%n", nome, endereco, contato, plano.getNome());
    }
}

package org.example.view;

import org.example.controller.Cliente;
import org.example.controller.Equipamento;
import org.example.controller.Estoque;
import org.example.controller.Plano;

import java.util.Scanner;

public class Menu {

    private static final Scanner sc = new Scanner(System.in);

    public static void principal() {

        System.out.println("O que deseja fazer? ");

        System.out.println("1. Gerenciar clientes");
        System.out.println("2. Gerenciar planos");
        System.out.println("3. Gerenciar estoque");

        int escolha = sc.nextInt();

        switch (escolha) {
            case 1:
                menuClientes();
                break;
            case 2:
                menuPlanos();
                break;
            case 3:
                menuEstoque();
                break;
        }
    }

    public static void menuClientes() {
        System.out.println("GERENCIAR CLIENTES");
        System.out.println("1. Fazer cadastro");
        System.out.println("2. Atualizar dados");

        int escolha = sc.nextInt();

        if (escolha == 1) {

            System.out.println("CADASTRO DE CLIENTE");

            Cliente cliente = new Cliente();
            cliente.cadastrar();

            System.out.printf("Cliente %s cadastrado com sucesso", cliente.getNome());

        } else if (escolha == 2) {

            System.out.println("ATUALIZAÇÃO DE CLIENTE");

            Cliente.atualizarDados();

        }
    }

    public static void menuPlanos() {
        System.out.println("GERENCIAR PLANOS");
        System.out.println("1. Cadastrar novo");
        System.out.println("2. Atualizar dados");

        int escolha = sc.nextInt();

        if (escolha == 1) {

            System.out.println("CADASTRO DE PLANO");

            Plano plano = new Plano();
            plano.cadastrar();

            System.out.printf("Plano %s cadastrado com sucesso", plano.getNome());

        } else if (escolha == 2) {

            System.out.println("ATUALIZAÇÃO DE PLANO");

            Plano.atualizarDados();

            System.out.println("Plano atualizado com sucesso");

        }

    }

    public static void menuEstoque() {

        System.out.println("GERENCIAR ESTOQUE");

        System.out.println("1. Consultar estoque");
        System.out.println("2. Adicionar equipamento");
        System.out.println("3. Registrar saída");

        int escolha = sc.nextInt();
        Estoque estoque = new Estoque();

        // Dados mockados ------------
        for (int i = 0; i < 5; i++) {
            Equipamento e = new Equipamento(1, "Roteador TP-LINK", false);
            estoque.adicionarEquipamento(e);
        }
        // --------------------------

        if (escolha == 1) {

            System.out.println("CONSULTA DE ESTOQUE");
            estoque.consultarEstoque();

        } else if (escolha == 2) {

            System.out.println("ADICIONAR EQUIPAMENTO");

            System.out.println("REGISTRAR SAÍDA");

            System.out.println("ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.println("Tipo: ");
            String tipo = sc.nextLine();

            System.out.println("Já foi entregue? s/n: ");
            boolean entregue = sc.nextLine().equalsIgnoreCase("s");

            Equipamento e = new Equipamento(id, tipo, entregue);
            estoque.adicionarEquipamento(e);

            System.out.printf("Equipamento %s adicionado com sucesso", e.tipo);

        } else if (escolha == 3) {

            Equipamento e = new Equipamento();
            estoque.removerEquipamento(e);

        }

    }

}

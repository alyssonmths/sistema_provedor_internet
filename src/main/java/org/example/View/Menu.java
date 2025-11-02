package org.example.View;

import org.example.Controller.Cliente;
import org.example.Controller.Equipamento;
import org.example.Controller.Estoque;
import org.example.Controller.Plano;

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

        }
        else if (escolha == 2) {

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

        }
        else if (escolha == 2) {

            System.out.println("ATUALIZAÇÃO DE PLANO");

            Plano.atualizarDados();

        }

    }

    public static void menuEstoque() {

        System.out.println("GERENCIAR ESTOQUE");

        System.out.println("1. Consultar estoque");
        System.out.println("2. Adicionar equipamento");
        System.out.println("3. Registrar saída");

        int escolha = sc.nextInt();
        Estoque estoque = new Estoque();

        if (escolha == 1) {

            System.out.println("CONSULTA DE ESTOQUE");

            estoque.consultarEstoque();

        }
        else if (escolha == 2) {

            System.out.println("ADICIONAR EQUIPAMENTO");

            estoque.adicionarEquipamento();

        }
        else if (escolha == 3) {

            System.out.println("REGISTRAR SAÍDA");

            Equipamento e = new Equipamento();
            estoque.removerEquipamento(e);

        }

    }

}

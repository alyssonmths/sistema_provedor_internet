package org.example.view;

import org.example.controller.Cliente;
import org.example.controller.Equipamento;
import org.example.controller.Estoque;
import org.example.controller.Plano;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private static final Scanner sc = new Scanner(System.in);
    private static Estoque estoque = new Estoque();
    private static List<Cliente> clientes = new ArrayList<>();

    public static void principal() {

        int escolha = -1;

        while (escolha != 0) {

            System.out.println("\nO que deseja fazer? ");

            System.out.println("1. Gerenciar clientes");
            System.out.println("2. Gerenciar planos");
            System.out.println("3. Gerenciar estoque");
            System.out.println("0. Sair do sistema");

            try {
                escolha = sc.nextInt();

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
                    case 0:
                        System.out.println("Obrigado por utilizar o sistema!");
                        return;
                    default:
                        System.out.println("Escolha uma opção válida");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Escolha uma opção válida");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    public static void menuClientes() {
        System.out.println("GERENCIAR CLIENTES");
        System.out.println("1. Fazer cadastro");
        System.out.println("2. Atualizar dados");
        System.out.println("3. Consultar clientes");

        int escolha = sc.nextInt();

        if (escolha == 1) {

            System.out.println("CADASTRO DE CLIENTE");

            Cliente cliente = new Cliente();
            cliente.cadastrar();

            clientes.add(cliente);

            System.out.printf("Cliente %s cadastrado com sucesso %n", cliente.getNome());

        } else if (escolha == 2) {

            System.out.println("ATUALIZAÇÃO DE CLIENTE");

            Cliente.atualizarDados();

        } else if (escolha == 3) {

            System.out.println("CONSULTAR CLIENTES");

            System.out.printf("+----------+------------------------------+---------------------------+-----------+%n");
            System.out.printf("| %-20s | %-28s | %-15s | %-10s |%n", "Nome", "Endereço", "Contato", "Plano");
            System.out.printf("+----------+------------------------------+----------------------------+----------+%n");

            for (Cliente cliente : clientes) {
                System.out.printf("| %-20s | %-28s | %-15s | %-10s |%n",
                        cliente.getNome(),
                        cliente.getEndereco(),
                        cliente.getContato(),
                        cliente.getPlano().getNome()
                );
            }

            System.out.printf("+----------+------------------------------+---------------------------+-----------+%n");

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

            System.out.printf("Plano %s cadastrado com sucesso %n", plano.getNome());

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
        System.out.println("3. Remover equipamento");
        System.out.println("4. Registrar saída");

        int escolha = sc.nextInt();

        if (escolha == 1) {

            System.out.println("CONSULTA DE ESTOQUE");
            estoque.consultar();

        } else if (escolha == 2) {

            System.out.println("ADICIONAR EQUIPAMENTO");

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

            estoque.consultar();

            System.out.println("Digite o ID do equipamento que deseja remover: ");
            int idEquipamento = sc.nextInt();
            estoque.removerEquipamento(idEquipamento);

        } else if (escolha == 4) {

            System.out.println("Registrar saída");

        }

    }

}

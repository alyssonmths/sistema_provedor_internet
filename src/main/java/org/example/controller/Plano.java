package org.example.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Plano {

    private int id;
    private String nome;
    private String descricao;
    private double velocidade;
    private double preco;

    public Plano() {

    }

    public Plano(int id, String nome, String descricao, double velocidade, double preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.velocidade = velocidade;
        this.preco = preco;
    }

    public void cadastrar() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Nome: ");
        this.nome = sc.nextLine();

        System.out.println("Descrição: ");
        this.descricao = sc.nextLine();

        System.out.println("Velocidade: ");
        this.velocidade = sc.nextDouble();

        System.out.println("Preço: ");
        this.preco = sc.nextDouble();

        this.id = gerarProximoId();

        salvarPlanoNoArquivo();

    }

    private int gerarProximoId() {
        List<Plano> planosExistentes = carregarPlanosDoArquivo();
        
        if (planosExistentes.isEmpty()) {
            return 1;
        }
        
        int maiorId = 0;
        for (Plano plano : planosExistentes) {
            if (plano.getId() > maiorId) {
                maiorId = plano.getId();
            }
        }
        
        return maiorId + 1;
    }

    private void salvarPlanoNoArquivo() {
        String caminhoArquivo = "C:\\Users\\alyss\\OneDrive\\Desktop\\Faculdade\\Projeto de software\\sistema_provedor_internet\\src\\main\\java\\org\\example\\arquivos\\planos.txt";
        
        try {
            Path caminho = Paths.get(caminhoArquivo);
            boolean arquivoExiste = Files.exists(caminho);
            List<String> linhasExistentes = arquivoExiste ? Files.readAllLines(caminho) : new ArrayList<>();
            
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo, true))) {

                if (!linhasExistentes.isEmpty() && !linhasExistentes.get(linhasExistentes.size() - 1).trim().isEmpty()) {
                    bw.newLine();
                }
                
                String linha = String.format(Locale.US, "%d;%s;%s;%.2f;%.2f", 
                        this.id, 
                        this.nome, 
                        this.descricao, 
                        this.velocidade, 
                        this.preco);
                bw.write(linha);
                System.out.println("\nPlano salvo no arquivo com sucesso!");
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar plano no arquivo: " + e.getMessage());
        }
    }

    public static List<Plano> carregarPlanosDoArquivo() {
        List<Plano> planos = new ArrayList<>();
        String caminhoArquivo = "C:\\Users\\alyss\\OneDrive\\Desktop\\Faculdade\\Projeto de software\\sistema_provedor_internet\\src\\main\\java\\org\\example\\arquivos\\planos.txt";

        try {
            Path caminho = Paths.get(caminhoArquivo);
            List<String> linhas = Files.readAllLines(caminho);

            for (String linha : linhas) {
                linha = linha.trim();
                if (!linha.isEmpty()) {
                    String[] dados = linha.split(";");

                    if (dados.length == 5) {
                        int id = Integer.parseInt(dados[0]);
                        String nome = dados[1];
                        String descricao = dados[2];
                        double velocidade = Double.parseDouble(dados[3]);
                        double preco = Double.parseDouble(dados[4]);

                        planos.add(new Plano(id, nome, descricao, velocidade, preco));
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Erro ao carregar planos do arquivo: " + e.getMessage());
        }

        return planos;
    }

    public static void exibirPlanos() {
        List<Plano> planos = carregarPlanosDoArquivo();

        if (planos.isEmpty()) {
            System.out.println("\nNenhum plano cadastrado no sistema.");
            return;
        }

        System.out.println("\nPlanos cadastrados:");
        System.out.println("+----+----------------+------------------------------------------+-------------+----------+");
        System.out.printf("| %-2s | %-14s | %-40s | %-11s | %-8s |%n", "ID", "Nome", "Descrição", "Velocidade", "Preço");
        System.out.println("+----+----------------+------------------------------------------+-------------+----------+");

        for (Plano plano : planos) {
            String descricaoFormatada = plano.getDescricao().length() > 40 
                    ? plano.getDescricao().substring(0, 37) + "..." 
                    : plano.getDescricao();
            
            System.out.printf("| %-2d | %-14s | %-40s | %-11.0f Mbps | R$ %-6.2f |%n",
                    plano.getId(),
                    plano.getNome(),
                    descricaoFormatada,
                    plano.getVelocidade(),
                    plano.getPreco());
        }
        System.out.println("+----+----------------+------------------------------------------+-------------+----------+");
    }

    public void atualizarPreco(double novoPreco) {
        this.preco = novoPreco;
    }

    public void atualizarVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    public static void atualizarDados() {
        List<Plano> planos = carregarPlanosDoArquivo();

        if (planos.isEmpty()) {
            System.out.println("\nNenhum plano cadastrado no sistema.");
            return;
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("\nPlanos cadastrados:");
        System.out.println("+----+----------------+------------------------------------------+-------------+----------+");
        System.out.printf("| %-2s | %-14s | %-40s | %-11s | %-8s |%n", "ID", "Nome", "Descrição", "Velocidade", "Preço");
        System.out.println("+----+----------------+------------------------------------------+-------------+----------+");

        for (Plano plano : planos) {
            String descricaoFormatada = plano.getDescricao().length() > 40 
                    ? plano.getDescricao().substring(0, 37) + "..." 
                    : plano.getDescricao();
            
            System.out.printf("| %-2d | %-14s | %-40s | %-11.0f Mbps | R$ %-6.2f |%n",
                    plano.getId(),
                    plano.getNome(),
                    descricaoFormatada,
                    plano.getVelocidade(),
                    plano.getPreco());
        }
        System.out.println("+----+----------------+------------------------------------------+-------------+----------+");

        System.out.println("\nSelecione o plano pelo ID: ");
        int idPlano = sc.nextInt();
        sc.nextLine();

        Plano planoSelecionado = null;
        for (Plano plano : planos) {
            if (plano.getId() == idPlano) {
                planoSelecionado = plano;
                break;
            }
        }

        if (planoSelecionado == null) {
            System.out.println("ID de plano inválido!");
            return;
        }

        System.out.println("\nDados atuais do plano selecionado:");
        System.out.println(planoSelecionado);

        System.out.println("\nDigite os novos dados (pressione Enter para manter o valor atual):");

        System.out.println("Nome [" + planoSelecionado.getNome() + "]: ");
        String novoNome = sc.nextLine();
        if (!novoNome.trim().isEmpty()) {
            planoSelecionado.nome = novoNome;
        }

        System.out.println("Descrição [" + planoSelecionado.getDescricao() + "]: ");
        String novaDescricao = sc.nextLine();
        if (!novaDescricao.trim().isEmpty()) {
            planoSelecionado.descricao = novaDescricao;
        }

        System.out.println("Velocidade [" + String.format(Locale.US, "%.2f", planoSelecionado.getVelocidade()) + "]: ");
        String novaVelocidadeStr = sc.nextLine();
        if (!novaVelocidadeStr.trim().isEmpty()) {
            try {
                planoSelecionado.velocidade = Double.parseDouble(novaVelocidadeStr);
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido para velocidade. Mantendo valor atual.");
            }
        }

        System.out.println("Preço [" + String.format(Locale.US, "%.2f", planoSelecionado.getPreco()) + "]: ");
        String novoPrecoStr = sc.nextLine();
        if (!novoPrecoStr.trim().isEmpty()) {
            try {
                planoSelecionado.preco = Double.parseDouble(novoPrecoStr);
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido para preço. Mantendo valor atual.");
            }
        }

        // Atualizar o plano na lista
        for (int i = 0; i < planos.size(); i++) {
            if (planos.get(i).getId() == planoSelecionado.getId()) {
                planos.set(i, planoSelecionado);
                break;
            }
        }

        // Salvar todas as alterações no arquivo
        salvarTodosPlanosNoArquivo(planos);

        System.out.println("\nDados do plano atualizados com sucesso!");
        System.out.println(planoSelecionado);
    }

    private static void salvarTodosPlanosNoArquivo(List<Plano> planos) {
        String caminhoArquivo = "C:\\Users\\alyss\\OneDrive\\Desktop\\Faculdade\\Projeto de software\\sistema_provedor_internet\\src\\main\\java\\org\\example\\arquivos\\planos.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo, false))) {
            for (int i = 0; i < planos.size(); i++) {
                Plano plano = planos.get(i);
                String linha = String.format(Locale.US, "%d;%s;%s;%.2f;%.2f",
                        plano.getId(),
                        plano.getNome(),
                        plano.getDescricao(),
                        plano.getVelocidade(),
                        plano.getPreco());
                bw.write(linha);
                if (i < planos.size() - 1) {
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar planos no arquivo: " + e.getMessage());
        }
    }

    public String detalhesPlano() {
        return String.format("Plano: %s\nVelocidade: %.2f Mbps\nPreço: R$ %.2f",
                nome, velocidade, preco);
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return String.format("%nNome: %s %nDescrição: %s %nVelocidade: %.2f %nPreço: %.2f%n", nome, descricao, velocidade, preco);
    }
}

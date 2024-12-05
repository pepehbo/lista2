package exercicio21;

import exercicio21.dao.*;
import exercicio21.model.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

/**
 * Classe principal do sistema.
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final FornecedorDAO fornecedorDAO = new FornecedorDAO();
    private static final ProdutoDAO produtoDAO = new ProdutoDAO();
    private static final IdentificacaoDAO identificacaoDAO = new IdentificacaoDAO();
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        criarTabelas();

        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (opcao) {
                case 1 -> cadastrarFornecedor();
                case 2 -> cadastrarProduto();
                case 3 -> cadastrarIdentificacao();
                case 4 -> listarProdutosPorFornecedor();
                case 5 -> atualizarFornecedor();
                case 6 -> atualizarProduto();
                case 7 -> atualizarIdentificacao();
                case 8 -> excluirFornecedor();
                case 9 -> excluirProduto();
                case 10 -> excluirIdentificacao();
                case 11 -> listarTodosProdutos();
                case 0 -> System.out.println("Programa encerrado.");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void criarTabelas() {
        fornecedorDAO.criarTabela();
        produtoDAO.criarTabela();
        identificacaoDAO.criarTabela();
    }

    private static void exibirMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1 - Cadastrar Fornecedor");
        System.out.println("2 - Cadastrar Produto");
        System.out.println("3 - Cadastrar Identificação");
        System.out.println("4 - Listar Produtos por Fornecedor");
        System.out.println("5 - Atualizar Fornecedor");
        System.out.println("6 - Atualizar Produto");
        System.out.println("7 - Atualizar Identificação");
        System.out.println("8 - Excluir Fornecedor");
        System.out.println("9 - Excluir Produto");
        System.out.println("10 - Excluir Identificação");
        System.out.println("11 - Listar Todos os Produtos");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarFornecedor() {
        System.out.println("\n=== CADASTRO DE FORNECEDOR ===");
        Fornecedor fornecedor = new Fornecedor();
        
        System.out.print("Nome: ");
        fornecedor.setNome(scanner.nextLine());
        
        System.out.print("Telefone: ");
        fornecedor.setTelefone(scanner.nextLine());
        
        System.out.print("Endereço: ");
        fornecedor.setEndereco(scanner.nextLine());

        if (fornecedorDAO.inserir(fornecedor)) {
            System.out.println("Fornecedor cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar fornecedor.");
        }
    }

    private static void cadastrarProduto() {
        System.out.println("\n=== CADASTRO DE PRODUTO ===");
        Produto produto = new Produto();
        
        System.out.print("ID do Fornecedor: ");
        produto.setIdFornecedor(scanner.nextInt());
        scanner.nextLine(); // Consume newline
        
        System.out.print("Nome: ");
        produto.setNome(scanner.nextLine());
        
        System.out.print("Preço: ");
        produto.setPreco(scanner.nextDouble());
        scanner.nextLine(); // Consume newline
        
        System.out.print("Validade (dd/mm/aaaa): ");
        produto.setValidade(LocalDate.parse(scanner.nextLine(), dateFormatter));

        if (produtoDAO.inserir(produto)) {
            System.out.println("Produto cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar produto.");
        }
    }

    private static void cadastrarIdentificacao() {
        System.out.println("\n=== CADASTRO DE IDENTIFICAÇÃO ===");
        Identificacao identificacao = new Identificacao();
        
        System.out.print("ID do Produto: ");
        identificacao.setId(scanner.nextInt());
        scanner.nextLine(); // Consume newline
        
        System.out.print("Nome: ");
        identificacao.setNome(scanner.nextLine());
        
        System.out.print("Descrição: ");
        identificacao.setDescricao(scanner.nextLine());

        if (identificacaoDAO.inserir(identificacao)) {
            System.out.println("Identificação cadastrada com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar identificação.");
        }
    }

    private static void listarProdutosPorFornecedor() {
        System.out.print("\nID do Fornecedor: ");
        int idFornecedor = scanner.nextInt();

        List<Produto> produtos = produtoDAO.listarPorFornecedor(idFornecedor);
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto encontrado para este fornecedor.");
            return;
        }

        System.out.println("\n=== PRODUTOS DO FORNECEDOR ===");
        for (Produto produto : produtos) {
            System.out.println("\n" + produto);
            System.out.println("---------------------------");
        }
    }

    private static void atualizarFornecedor() {
        System.out.println("\n=== ATUALIZAÇÃO DE FORNECEDOR ===");
        System.out.print("ID do Fornecedor: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(id);
        
        System.out.print("Novo nome: ");
        fornecedor.setNome(scanner.nextLine());
        
        System.out.print("Novo telefone: ");
        fornecedor.setTelefone(scanner.nextLine());
        
        System.out.print("Novo endereço: ");
        fornecedor.setEndereco(scanner.nextLine());

        if (fornecedorDAO.atualizar(fornecedor)) {
            System.out.println("Fornecedor atualizado com sucesso!");
        } else {
            System.out.println("Erro ao atualizar fornecedor.");
        }
    }

    private static void atualizarProduto() {
        System.out.println("\n=== ATUALIZAÇÃO DE PRODUTO ===");
        System.out.print("ID do Produto: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Produto produto = new Produto();
        produto.setId(id);
        
        System.out.print("Novo ID do Fornecedor: ");
        produto.setIdFornecedor(scanner.nextInt());
        scanner.nextLine(); // Consume newline
        
        System.out.print("Novo nome: ");
        produto.setNome(scanner.nextLine());
        
        System.out.print("Novo preço: ");
        produto.setPreco(scanner.nextDouble());
        scanner.nextLine(); // Consume newline
        
        System.out.print("Nova validade (dd/mm/aaaa): ");
        produto.setValidade(LocalDate.parse(scanner.nextLine(), dateFormatter));

        if (produtoDAO.atualizar(produto)) {
            System.out.println("Produto atualizado com sucesso!");
        } else {
            System.out.println("Erro ao atualizar produto.");
        }
    }

    private static void atualizarIdentificacao() {
        System.out.println("\n=== ATUALIZAÇÃO DE IDENTIFICAÇÃO ===");
        System.out.print("ID da Identificação: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Identificacao identificacao = new Identificacao();
        identificacao.setId(id);
        
        System.out.print("Novo nome: ");
        identificacao.setNome(scanner.nextLine());
        
        System.out.print("Nova descrição: ");
        identificacao.setDescricao(scanner.nextLine());

        if (identificacaoDAO.atualizar(identificacao)) {
            System.out.println("Identificação atualizada com sucesso!");
        } else {
            System.out.println("Erro ao atualizar identificação.");
        }
    }

    private static void excluirFornecedor() {
        System.out.println("\n=== EXCLUSÃO DE FORNECEDOR ===");
        System.out.print("ID do Fornecedor: ");
        int id = scanner.nextInt();

        if (fornecedorDAO.excluir(id)) {
            System.out.println("Fornecedor excluído com sucesso!");
        } else {
            System.out.println("Erro ao excluir fornecedor.");
        }
    }

    private static void excluirProduto() {
        System.out.println("\n=== EXCLUSÃO DE PRODUTO ===");
        System.out.print("ID do Produto: ");
        int id = scanner.nextInt();

        if (produtoDAO.excluir(id)) {
            System.out.println("Produto excluído com sucesso!");
        } else {
            System.out.println("Erro ao excluir produto.");
        }
    }

    private static void excluirIdentificacao() {
        System.out.println("\n=== EXCLUSÃO DE IDENTIFICAÇÃO ===");
        System.out.print("ID da Identificação: ");
        int id = scanner.nextInt();

        if (identificacaoDAO.excluir(id)) {
            System.out.println("Identificação excluída com sucesso!");
        } else {
            System.out.println("Erro ao excluir identificação.");
        }
    }

    private static void listarTodosProdutos() {
        List<Produto> produtos = produtoDAO.listarTodos();
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        System.out.println("\n=== TODOS OS PRODUTOS ===");
        for (Produto produto : produtos) {
            System.out.println("\n" + produto);
            System.out.println("---------------------------");
        }
    }
}
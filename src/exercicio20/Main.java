package exercicio20;

import exercicio20.dao.VeiculoDAO;
import exercicio20.model.Veiculo;
import java.util.List;
import java.util.Scanner;

/**
 * Classe principal para gerenciamento de veículos.
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final VeiculoDAO veiculoDAO = new VeiculoDAO();

    public static void main(String[] args) {
        veiculoDAO.criarTabela();

        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (opcao) {
                case 1 -> cadastrarVeiculo();
                case 2 -> consultarVeiculos();
                case 3 -> atualizarVeiculo();
                case 4 -> excluirVeiculo();
                case 0 -> System.out.println("Programa encerrado.");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1 - Cadastrar veículo");
        System.out.println("2 - Consultar veículos");
        System.out.println("3 - Atualizar veículo");
        System.out.println("4 - Excluir veículo");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarVeiculo() {
        Veiculo veiculo = new Veiculo();
        
        System.out.println("\n=== CADASTRO DE VEÍCULO ===");
        System.out.print("Marca: ");
        veiculo.setMarca(scanner.nextLine());
        
        System.out.print("Modelo: ");
        veiculo.setModelo(scanner.nextLine());
        
        System.out.print("Número do Chassi: ");
        veiculo.setNumeroChassi(scanner.nextLine());
        
        System.out.print("Placa: ");
        veiculo.setPlaca(scanner.nextLine());
        
        System.out.print("Cor: ");
        veiculo.setCor(scanner.nextLine());

        if (veiculoDAO.inserir(veiculo)) {
            System.out.println("Veículo cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar veículo.");
        }
    }

    private static void consultarVeiculos() {
        System.out.println("\n=== VEÍCULOS CADASTRADOS ===");
        List<Veiculo> veiculos = veiculoDAO.listarTodos();
        
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }

        for (Veiculo veiculo : veiculos) {
            System.out.println("\n" + veiculo);
            System.out.println("---------------------------");
        }
    }

    private static void atualizarVeiculo() {
        System.out.println("\n=== ATUALIZAÇÃO DE VEÍCULO ===");
        System.out.print("Digite o ID do veículo: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Veiculo veiculo = new Veiculo();
        veiculo.setId(id);
        
        System.out.print("Nova marca: ");
        veiculo.setMarca(scanner.nextLine());
        
        System.out.print("Novo modelo: ");
        veiculo.setModelo(scanner.nextLine());
        
        System.out.print("Novo número do chassi: ");
        veiculo.setNumeroChassi(scanner.nextLine());
        
        System.out.print("Nova placa: ");
        veiculo.setPlaca(scanner.nextLine());
        
        System.out.print("Nova cor: ");
        veiculo.setCor(scanner.nextLine());

        if (veiculoDAO.atualizar(veiculo)) {
            System.out.println("Veículo atualizado com sucesso!");
        } else {
            System.out.println("Erro ao atualizar veículo.");
        }
    }

    private static void excluirVeiculo() {
        System.out.println("\n=== EXCLUSÃO DE VEÍCULO ===");
        System.out.print("Digite o ID do veículo: ");
        int id = scanner.nextInt();

        if (veiculoDAO.excluir(id)) {
            System.out.println("Veículo excluído com sucesso!");
        } else {
            System.out.println("Erro ao excluir veículo.");
        }
    }
}
package exercicio13.questao1;

import java.util.Scanner;

/**
 * Classe principal para testar o cadastro de veículos.
 */
public class MainVeiculos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CadastroVeiculos cadastro = new CadastroVeiculos();

        while (true) {
            System.out.print("\nDeseja cadastrar um novo veículo? (S/N): ");
            String resposta = scanner.nextLine().toUpperCase();
            
            if (!resposta.equals("S")) {
                break;
            }

            Veiculo veiculo = new Veiculo();
            
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

            cadastro.cadastrarVeiculo(veiculo);
        }

        cadastro.imprimirCadastro();
        scanner.close();
    }
}
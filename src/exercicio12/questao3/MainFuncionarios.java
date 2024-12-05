package exercicio12.questao3;

import java.util.Scanner;

/**
 * Classe principal para testar o cadastro de funcionários.
 */
public class MainFuncionarios {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cadastro cadastro = new Cadastro();

        System.out.print("Quantos funcionários deseja cadastrar? ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < quantidade; i++) {
            System.out.println("\nCadastro do funcionário " + (i + 1) + ":");
            
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            
            System.out.print("Idade: ");
            int idade = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            System.out.print("Cargo: ");
            String cargo = scanner.nextLine();
            
            System.out.print("Salário: ");
            double salario = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            
            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();
            
            System.out.print("Endereço: ");
            String endereco = scanner.nextLine();

            Funcionario funcionario = new Funcionario(nome, idade, cargo, 
                                                    salario, telefone, endereco);
            cadastro.cadastrarFuncionario(funcionario);
        }

        System.out.println("\nListagem de todos os funcionários cadastrados:");
        cadastro.imprimirCadastro();

        scanner.close();
    }
}
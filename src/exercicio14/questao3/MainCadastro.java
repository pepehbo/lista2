package exercicio14.questao3;

import java.util.Scanner;

/**
 * Classe principal para testar o cadastro de pessoas.
 */
public class MainCadastro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cadastro cadastro = new Cadastro();

        while (true) {
            System.out.println("\nTipo de pessoa:");
            System.out.println("1 - Pessoa Física");
            System.out.println("2 - Pessoa Jurídica");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            if (opcao == 0) {
                break;
            }

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            if (opcao == 1) {
                PessoaFisica pessoaFisica = new PessoaFisica();
                pessoaFisica.setNome(nome);
                System.out.print("CPF: ");
                pessoaFisica.setCPF(scanner.nextLine());
                cadastro.cadastrarPessoa(pessoaFisica);
            } else if (opcao == 2) {
                PessoaJuridica pessoaJuridica = new PessoaJuridica();
                pessoaJuridica.setNome(nome);
                System.out.print("CNPJ: ");
                pessoaJuridica.setCNPJ(scanner.nextLine());
                cadastro.cadastrarPessoa(pessoaJuridica);
            }
        }

        cadastro.imprimirCadastro();
        scanner.close();
    }
}
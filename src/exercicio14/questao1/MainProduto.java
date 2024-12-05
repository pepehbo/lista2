package exercicio14.questao1;

import java.util.Scanner;

/**
 * Classe principal para testar as funcionalidades da classe Produto.
 */
public class MainProduto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Produto[] produtos = new Produto[2];

        for (int i = 0; i < produtos.length; i++) {
            System.out.println("\nCadastro do produto " + (i + 1) + ":");
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            
            System.out.print("Preço: R$ ");
            double preco = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            produtos[i] = new Produto(nome, preco);
            System.out.println("\nProduto cadastrado:");
            System.out.println(produtos[i].exibe());
        }

        System.out.print("\nInforme o percentual de reajuste: ");
        double percentual = scanner.nextDouble();

        System.out.println("\nProdutos após reajuste:");
        for (Produto produto : produtos) {
            produto.reajustaPreco(percentual);
            System.out.println("\n" + produto.exibe());
        }

        System.out.println("\nÚltimo ID gerado: " + Produto.getUltimoId());
        
        scanner.close();
    }
}
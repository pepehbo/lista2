package exercicio10;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Classe principal para testar os algoritmos de ordenação.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ordenacao ordenacao = new Ordenacao();
        
        do {
            // Leitura do vetor
            int[] vetor = new int[10];
            System.out.println("\nDigite 10 números para ordenar:");
            for (int i = 0; i < 10; i++) {
                System.out.printf("Número %d: ", i + 1);
                vetor[i] = scanner.nextInt();
            }
            
            // Menu de opções
            System.out.println("\nEscolha o método de ordenação:");
            System.out.println("1 - Bubble Sort (Bolha)");
            System.out.println("2 - Selection Sort (Seleção)");
            System.out.println("3 - Insertion Sort (Inserção)");
            System.out.println("4 - Quick Sort");
            System.out.println("5 - Merge Sort");
            System.out.print("Opção: ");
            
            int opcao = scanner.nextInt();
            
            // Cria uma cópia do vetor para não modificar o original
            int[] vetorOrdenado = Arrays.copyOf(vetor, vetor.length);
            
            // Aplica o método de ordenação escolhido
            switch (opcao) {
                case 1:
                    ordenacao.bolha(vetorOrdenado);
                    System.out.println("Método Bubble Sort aplicado!");
                    break;
                case 2:
                    ordenacao.selecao(vetorOrdenado);
                    System.out.println("Método Selection Sort aplicado!");
                    break;
                case 3:
                    ordenacao.insercao(vetorOrdenado);
                    System.out.println("Método Insertion Sort aplicado!");
                    break;
                case 4:
                    ordenacao.quickSort(vetorOrdenado);
                    System.out.println("Método Quick Sort aplicado!");
                    break;
                case 5:
                    ordenacao.mergeSort(vetorOrdenado);
                    System.out.println("Método Merge Sort aplicado!");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    continue;
            }
            
            // Exibe os resultados
            System.out.println("\nVetor original: " + Arrays.toString(vetor));
            System.out.println("Vetor ordenado: " + Arrays.toString(vetorOrdenado));
            
            // Pergunta se deseja continuar
            System.out.print("\nDeseja ordenar outro vetor? (S/N): ");
            String continuar = scanner.next();
            if (!continuar.equalsIgnoreCase("S")) {
                break;
            }
            
        } while (true);
        
        scanner.close();
        System.out.println("Programa encerrado.");
    }
}
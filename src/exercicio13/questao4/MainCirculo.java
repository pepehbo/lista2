package exercicio13.questao4;

import java.util.Scanner;

/**
 * Classe principal para testar as funcionalidades do Círculo.
 */
public class MainCirculo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite as coordenadas e o raio do círculo:");
        System.out.print("Coordenada X: ");
        int x = scanner.nextInt();
        System.out.print("Coordenada Y: ");
        int y = scanner.nextInt();
        System.out.print("Raio: ");
        double raio = scanner.nextDouble();

        Circulo circulo = new Circulo(x, y, raio);

        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Mover");
            System.out.println("2 - Aumentar");
            System.out.println("3 - Imprimir");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Deslocamento X: ");
                    int dx = scanner.nextInt();
                    System.out.print("Deslocamento Y: ");
                    int dy = scanner.nextInt();
                    circulo.moveX(dx);
                    circulo.moveY(dy);
                    break;
                    
                case 2:
                    System.out.print("Fator de aumento: ");
                    double fator = scanner.nextDouble();
                    circulo.aumenta(fator);
                    break;
                    
                case 3:
                    System.out.println("\nInformações do círculo:");
                    System.out.println(circulo.exibe());
                    break;
                    
                case 4:
                    System.out.println("Programa encerrado.");
                    break;
                    
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);

        scanner.close();
    }
}
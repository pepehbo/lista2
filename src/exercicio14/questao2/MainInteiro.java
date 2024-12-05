package exercicio14.questao2;

import java.util.Scanner;

/**
 * Classe principal para testar as operações da classe Inteiro.
 */
public class MainInteiro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inteiro inteiro = new Inteiro();
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Multiplicação");
            System.out.println("2 - Potência");
            System.out.println("3 - Divisão");
            System.out.println("4 - Par");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Digite o primeiro número: ");
                        int a = scanner.nextInt();
                        System.out.print("Digite o segundo número: ");
                        int b = scanner.nextInt();
                        System.out.println("Resultado: " + inteiro.multiplicacao(a, b));
                        break;

                    case 2:
                        System.out.print("Digite a base: ");
                        int base = scanner.nextInt();
                        System.out.print("Digite o expoente: ");
                        int exp = scanner.nextInt();
                        System.out.println("Resultado: " + inteiro.potencia(base, exp));
                        break;

                    case 3:
                        System.out.print("Digite o dividendo: ");
                        int dividendo = scanner.nextInt();
                        System.out.print("Digite o divisor: ");
                        int divisor = scanner.nextInt();
                        System.out.println("Quociente: " + inteiro.divisao(dividendo, divisor));
                        System.out.println("Resto: " + inteiro.resto(dividendo, divisor));
                        break;

                    case 4:
                        System.out.print("Digite um número: ");
                        int num = scanner.nextInt();
                        System.out.println(num + " é " + (inteiro.par(num) ? "par" : "ímpar"));
                        break;

                    case 5:
                        System.out.println("Programa encerrado.");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (opcao != 5);

        scanner.close();
    }
}
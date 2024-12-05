package exercicio15.questao1;

import java.util.Scanner;

/**
 * Classe principal que implementa a divisão com tratamento de exceção.
 */
public class MainDivisao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite o dividendo: ");
            int dividendo = scanner.nextInt();

            System.out.print("Digite o divisor: ");
            int divisor = scanner.nextInt();

            int resultado = dividendo / divisor;
            System.out.printf("Resultado da divisão: %d\n", resultado);
        } catch (ArithmeticException e) {
            System.out.println("Erro: Divisão por zero não é permitida!");
        } finally {
            scanner.close();
        }
    }
}
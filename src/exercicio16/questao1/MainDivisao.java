package exercicio16.questao1;

import java.util.Scanner;

/**
 * Classe principal para testar a divisão com tratamento de exceções.
 */
public class MainDivisao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculadora calculadora = new Calculadora();

        try {
            System.out.print("Digite o dividendo: ");
            int dividendo = scanner.nextInt();

            System.out.print("Digite o divisor: ");
            int divisor = scanner.nextInt();

            int resultado = calculadora.dividir(dividendo, divisor);
            System.out.printf("Resultado da divisão: %d\n", resultado);
        } catch (DivisaoException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
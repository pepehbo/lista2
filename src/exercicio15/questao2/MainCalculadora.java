package exercicio15.questao2;

import java.util.Scanner;

/**
 * Classe principal que realiza o tratamento de exceções da divisão.
 */
public class MainCalculadora {
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
        } catch (ArithmeticException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
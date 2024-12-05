package exercicio16.questao2;

import java.util.Scanner;

/**
 * Classe principal que realiza o tratamento de exceções da divisão.
 */
public class MainDivisao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Divisao divisao = new Divisao();

        try {
            System.out.print("Digite o dividendo: ");
            int dividendo = scanner.nextInt();

            System.out.print("Digite o divisor: ");
            int divisor = scanner.nextInt();

            int resultado = divisao.dividir(dividendo, divisor);
            System.out.printf("Resultado da divisão: %d\n", resultado);
        } catch (ArithmeticException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
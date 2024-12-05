package exercicio12.questao1;

import java.util.Scanner;

/**
 * Classe principal para testar as funcionalidades da ContaCorrente.
 */
public class MainBanco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContaCorrente contaCorrente = new ContaCorrente();

        System.out.print("Informe o número da conta: ");
        int numero = scanner.nextInt();
        System.out.print("Informe o número da agência: ");
        int agencia = scanner.nextInt();

        contaCorrente.iniciarContaCorrente(numero, agencia);

        System.out.print("Informe o valor para depósito: ");
        double valorDeposito = scanner.nextDouble();
        contaCorrente.depositar(valorDeposito);
        System.out.println("\nDados da conta após depósito:");
        System.out.println(contaCorrente.exibe());

        System.out.print("\nInforme o valor para saque: ");
        double valorSaque = scanner.nextDouble();
        if (contaCorrente.sacar(valorSaque)) {
            System.out.println("\nDados da conta após saque:");
            System.out.println(contaCorrente.exibe());
        }

        scanner.close();
    }
}
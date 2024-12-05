package exercicio12.questao1;

/**
 * Classe que representa uma conta corrente bancária.
 * Permite operações básicas como saque, depósito e consulta de saldo.
 */
public class ContaCorrente {
    private int numero, agencia;
    private double saldo;

    /**
     * Inicializa uma nova conta corrente com número e agência específicos.
     * @param n Número da conta
     * @param ag Número da agência
     */
    public void iniciarContaCorrente(int n, int ag) {
        numero = n;
        agencia = ag;
        saldo = 0;
    }

    /**
     * Realiza um saque na conta se houver saldo suficiente.
     * @param valor Valor a ser sacado
     * @return true se o saque foi realizado com sucesso, false caso contrário
     */
    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo = saldo - valor;
            return true;
        }
        System.out.println("Erro: Saldo insuficiente para realizar o saque.");
        return false;
    }

    /**
     * Realiza um depósito na conta.
     * @param valor Valor a ser depositado
     */
    public void depositar(double valor) {
        saldo = saldo + valor;
    }

    /**
     * Consulta o saldo atual da conta.
     * @return Saldo atual
     */
    public double consultarSaldo() {
        return saldo;
    }

    /**
     * Exibe os dados da conta formatados.
     * @return String contendo os dados formatados da conta
     */
    public String exibe() {
        return String.format("Agência: %d\nConta: %d\nSaldo: R$ %.2f", 
            agencia, numero, saldo);
    }
}
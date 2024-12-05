package exercicio16.questao2;

/**
 * Classe secundária que implementa a operação de divisão.
 */
public class Divisao {
    /**
     * Realiza a divisão entre dois números inteiros.
     * @param dividendo Número a ser dividido
     * @param divisor Número pelo qual se divide
     * @return Resultado da divisão
     * @throws ArithmeticException Se houver erro na divisão
     */
    public int dividir(int dividendo, int divisor) throws ArithmeticException {
        if (divisor == 0) {
            throw new ArithmeticException("Divisão por zero não é permitida!");
        }
        if (dividendo < 0) {
            throw new ArithmeticException("O dividendo não pode ser negativo!");
        }
        return dividendo / divisor;
    }
}
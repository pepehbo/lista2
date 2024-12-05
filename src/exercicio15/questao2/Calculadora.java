package exercicio15.questao2;

/**
 * Classe que implementa a operação de divisão com validações.
 */
public class Calculadora {
    /**
     * Realiza a divisão entre dois números inteiros com validações.
     * @param dividendo Número a ser dividido
     * @param divisor Número pelo qual se divide
     * @return Resultado da divisão
     * @throws ArithmeticException Se o divisor for zero ou o dividendo for negativo
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
package exercicio16.questao1;

/**
 * Classe que implementa operações matemáticas com tratamento de exceções.
 */
public class Calculadora {
    /**
     * Realiza a divisão entre dois números inteiros.
     * @param dividendo Número a ser dividido
     * @param divisor Número pelo qual se divide
     * @return Resultado da divisão
     * @throws DivisaoException Se houver erro na divisão
     */
    public int dividir(int dividendo, int divisor) throws DivisaoException {
        if (divisor == 0) {
            throw new DivisaoException("Divisão por zero não é permitida!");
        }
        if (dividendo < 0) {
            throw new DivisaoException("O dividendo não pode ser negativo!");
        }
        return dividendo / divisor;
    }
}
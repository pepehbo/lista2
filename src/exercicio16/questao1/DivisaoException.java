package exercicio16.questao1;

/**
 * Exceção personalizada para erros de divisão.
 */
public class DivisaoException extends Exception {
    public DivisaoException(String message) {
        super(message);
    }
}
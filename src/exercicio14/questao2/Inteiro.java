package exercicio14.questao2;

/**
 * Classe para manipulação de valores inteiros usando operações básicas.
 */
public class Inteiro {
    /**
     * Calcula a multiplicação de dois números usando soma.
     * @param a Primeiro número
     * @param b Segundo número
     * @return Resultado da multiplicação
     */
    public int multiplicacao(int a, int b) {
        int resultado = 0;
        boolean negativo = (a < 0 && b > 0) || (a > 0 && b < 0);
        a = Math.abs(a);
        b = Math.abs(b);
        
        for (int i = 0; i < b; i++) {
            resultado += a;
        }
        
        return negativo ? -resultado : resultado;
    }

    /**
     * Calcula a potência de um número usando multiplicação.
     * @param a Base
     * @param b Expoente
     * @return Resultado da potência
     */
    public int potencia(int a, int b) {
        if (b < 0) {
            throw new IllegalArgumentException("Expoente deve ser não negativo");
        }
        if (b == 0) {
            return 1;
        }
        
        int resultado = 1;
        for (int i = 0; i < b; i++) {
            resultado = multiplicacao(resultado, a);
        }
        return resultado;
    }

    /**
     * Calcula a divisão inteira usando subtração.
     * @param a Dividendo
     * @param b Divisor
     * @return Quociente da divisão
     */
    public int divisao(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Divisão por zero");
        }

        boolean negativo = (a < 0 && b > 0) || (a > 0 && b < 0);
        a = Math.abs(a);
        b = Math.abs(b);
        
        int quociente = 0;
        while (a >= b) {
            a -= b;
            quociente++;
        }
        
        return negativo ? -quociente : quociente;
    }

    /**
     * Calcula o resto da divisão usando subtração.
     * @param a Dividendo
     * @param b Divisor
     * @return Resto da divisão
     */
    public int resto(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Divisão por zero");
        }

        a = Math.abs(a);
        b = Math.abs(b);
        
        while (a >= b) {
            a -= b;
        }
        
        return a;
    }

    /**
     * Verifica se um número é par usando o método resto.
     * @param a Número a verificar
     * @return true se for par, false caso contrário
     */
    public boolean par(int a) {
        return resto(a, 2) == 0;
    }
}
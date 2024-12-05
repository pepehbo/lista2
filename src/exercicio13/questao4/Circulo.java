package exercicio13.questao4;

/**
 * Classe que representa um círculo e suas operações.
 */
public class Circulo {
    private int x;
    private int y;
    private double raio;

    /**
     * Construtor padrão que inicializa o círculo na origem com raio 0.
     */
    public Circulo() {
        this(0, 0, 0);
    }

    /**
     * Construtor que inicializa o círculo com coordenadas e raio específicos.
     * @param x Coordenada X do centro
     * @param y Coordenada Y do centro
     * @param raio Raio do círculo
     */
    public Circulo(int x, int y, double raio) {
        this.x = x;
        this.y = y;
        this.raio = raio;
    }

    /**
     * Move o círculo horizontalmente.
     * @param x1 Deslocamento horizontal
     */
    public void moveX(int x1) {
        x += x1;
    }

    /**
     * Move o círculo verticalmente.
     * @param y1 Deslocamento vertical
     */
    public void moveY(int y1) {
        y += y1;
    }

    /**
     * Aumenta o raio do círculo.
     * @param n Fator de multiplicação
     */
    public void aumenta(double n) {
        raio *= n;
    }

    /**
     * Calcula a área do círculo.
     * @return Área do círculo
     */
    public double calculaArea() {
        return Math.PI * Math.pow(raio, 2);
    }

    /**
     * Calcula o perímetro do círculo.
     * @return Perímetro do círculo
     */
    public double calculaPerimetro() {
        return 2 * Math.PI * raio;
    }

    /**
     * Retorna as informações do círculo formatadas.
     * @return String com as informações do círculo
     */
    public String exibe() {
        return String.format(
            "Centro: (%d, %d)\nRaio: %.2f\nÁrea: %.2f\nPerímetro: %.2f",
            x, y, raio, calculaArea(), calculaPerimetro()
        );
    }
}
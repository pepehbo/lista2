package exercicio12.questao2;

/**
 * Classe que representa um retângulo e suas operações básicas.
 */
public class Retangulo {
    private float altura, largura;

    /**
     * Construtor padrão que inicializa altura e largura com zero.
     */
    public Retangulo() {
        altura = 0;
        largura = 0;
    }

    /**
     * Obtém a altura do retângulo.
     * @return Altura do retângulo
     */
    public float getAltura() {
        return altura;
    }

    /**
     * Define a altura do retângulo.
     * @param alt Nova altura
     */
    public void setAltura(float alt) {
        altura = alt;
    }

    /**
     * Obtém a largura do retângulo.
     * @return Largura do retângulo
     */
    public float getLargura() {
        return largura;
    }

    /**
     * Define a largura do retângulo.
     * @param larg Nova largura
     */
    public void setLargura(float larg) {
        largura = larg;
    }

    /**
     * Calcula a área do retângulo.
     * @return Área do retângulo
     */
    public float calculaArea() {
        return altura * largura;
    }

    /**
     * Calcula o perímetro do retângulo.
     * @return Perímetro do retângulo
     */
    public float calculaPerimetro() {
        return 2 * altura + 2 * largura;
    }

    /**
     * Exibe as informações do retângulo formatadas.
     * @return String contendo as informações do retângulo
     */
    public String exibe() {
        return String.format("Altura: %.2f\nLargura: %.2f\nÁrea: %.2f\nPerímetro: %.2f",
            altura, largura, calculaArea(), calculaPerimetro());
    }
}
package exercicio13.questao1;

/**
 * Classe que representa um veículo com suas propriedades básicas.
 */
public class Veiculo {
    private String marca;
    private String modelo;
    private String numeroChassi;
    private String placa;
    private String cor;

    /**
     * Obtém a marca do veículo.
     * @return Marca do veículo
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Define a marca do veículo.
     * @param marca Nova marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Obtém o modelo do veículo.
     * @return Modelo do veículo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Define o modelo do veículo.
     * @param modelo Novo modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Obtém o número do chassi do veículo.
     * @return Número do chassi
     */
    public String getNumeroChassi() {
        return numeroChassi;
    }

    /**
     * Define o número do chassi do veículo.
     * @param numeroChassi Novo número do chassi
     */
    public void setNumeroChassi(String numeroChassi) {
        this.numeroChassi = numeroChassi;
    }

    /**
     * Obtém a placa do veículo.
     * @return Placa do veículo
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * Define a placa do veículo.
     * @param placa Nova placa
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * Obtém a cor do veículo.
     * @return Cor do veículo
     */
    public String getCor() {
        return cor;
    }

    /**
     * Define a cor do veículo.
     * @param cor Nova cor
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return String.format("Marca: %s\nModelo: %s\nChassi: %s\nPlaca: %s\nCor: %s",
            marca, modelo, numeroChassi, placa, cor);
    }
}
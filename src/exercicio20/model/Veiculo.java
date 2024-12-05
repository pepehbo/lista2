package exercicio20.model;

/**
 * Classe que representa um veículo com suas propriedades básicas.
 */
public class Veiculo {
    private int id;
    private String marca;
    private String modelo;
    private String numeroChassi;
    private String placa;
    private String cor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumeroChassi() {
        return numeroChassi;
    }

    public void setNumeroChassi(String numeroChassi) {
        this.numeroChassi = numeroChassi;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return String.format("ID: %d\nMarca: %s\nModelo: %s\nChassi: %s\nPlaca: %s\nCor: %s",
            id, marca, modelo, numeroChassi, placa, cor);
    }
}
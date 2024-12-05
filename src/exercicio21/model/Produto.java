package exercicio21.model;

import java.time.LocalDate;

/**
 * Classe que representa um produto.
 */
public class Produto {
    private int id;
    private int idFornecedor;
    private String nome;
    private double preco;
    private LocalDate validade;
    private String fornecedorNome; // Para relatórios

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public String getFornecedorNome() {
        return fornecedorNome;
    }

    public void setFornecedorNome(String fornecedorNome) {
        this.fornecedorNome = fornecedorNome;
    }

    @Override
    public String toString() {
        return String.format("ID: %d\nNome: %s\nPreço: R$ %.2f\nValidade: %s\nFornecedor: %s",
            id, nome, preco, validade, fornecedorNome);
    }
}
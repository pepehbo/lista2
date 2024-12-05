package exercicio21.model;

/**
 * Classe que representa a identificação de um produto.
 */
public class Identificacao {
    private int id;
    private String nome;
    private String descricao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return String.format("ID: %d\nNome: %s\nDescrição: %s",
            id, nome, descricao);
    }
}
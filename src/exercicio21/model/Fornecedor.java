package exercicio21.model;

/**
 * Classe que representa um fornecedor.
 */
public class Fornecedor {
    private int id;
    private String nome;
    private String telefone;
    private String endereco;

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return String.format("ID: %d\nNome: %s\nTelefone: %s\nEndereço: %s",
            id, nome, telefone, endereco);
    }
}
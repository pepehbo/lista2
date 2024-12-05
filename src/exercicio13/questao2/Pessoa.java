package exercicio13.questao2;

/**
 * Classe base que representa uma pessoa.
 */
public class Pessoa {
    private String nome;

    /**
     * Obtém o nome da pessoa.
     * @return Nome da pessoa
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da pessoa.
     * @param nome Novo nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Nome: " + nome;
    }
}
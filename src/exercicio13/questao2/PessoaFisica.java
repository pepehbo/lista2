package exercicio13.questao2;

/**
 * Classe que representa uma pessoa física, estendendo a classe Pessoa.
 */
public class PessoaFisica extends Pessoa {
    private String cpf;

    /**
     * Obtém o CPF da pessoa física.
     * @return CPF
     */
    public String getCPF() {
        return cpf;
    }

    /**
     * Define o CPF da pessoa física.
     * @param cpf Novo CPF
     */
    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCPF: " + cpf;
    }
}
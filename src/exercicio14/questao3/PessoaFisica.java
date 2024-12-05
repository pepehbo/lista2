package exercicio14.questao3;

/**
 * Classe que representa uma pessoa física.
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
}
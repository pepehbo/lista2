package exercicio13.questao2;

/**
 * Classe que representa uma pessoa jurídica, estendendo a classe Pessoa.
 */
public class PessoaJuridica extends Pessoa {
    private String cnpj;

    /**
     * Obtém o CNPJ da pessoa jurídica.
     * @return CNPJ
     */
    public String getCNPJ() {
        return cnpj;
    }

    /**
     * Define o CNPJ da pessoa jurídica.
     * @param cnpj Novo CNPJ
     */
    public void setCNPJ(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCNPJ: " + cnpj;
    }
}
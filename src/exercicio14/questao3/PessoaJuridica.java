package exercicio14.questao3;

/**
 * Classe que representa uma pessoa jurídica.
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
}
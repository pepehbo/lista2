package exercicio12.questao3;

/**
 * Classe que representa um funcionário com seus dados básicos.
 */
public class Funcionario {
    private String nome;
    private int idade;
    private String cargo;
    private double salario;
    private String telefone;
    private String endereco;

    /**
     * Construtor que inicializa todos os dados do funcionário.
     */
    public Funcionario(String nome, int idade, String cargo, double salario, 
                      String telefone, String endereco) {
        this.nome = nome;
        this.idade = idade;
        this.cargo = cargo;
        this.salario = salario;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    /**
     * Exibe os dados do funcionário formatados.
     * @return String contendo os dados do funcionário
     */
    public String exibe() {
        return String.format("Nome: %s\nIdade: %d\nCargo: %s\n" +
                           "Salário: R$ %.2f\nTelefone: %s\nEndereço: %s",
            nome, idade, cargo, salario, telefone, endereco);
    }
}
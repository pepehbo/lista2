package exercicio13.questao2;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pelo cadastro e gerenciamento de pessoas.
 */
public class CadastroPessoas {
    private List<Pessoa> pessoas;

    /**
     * Construtor que inicializa a lista de pessoas.
     */
    public CadastroPessoas() {
        pessoas = new ArrayList<>();
    }

    /**
     * Adiciona uma nova pessoa ao cadastro.
     * @param pessoa Pessoa a ser cadastrada
     */
    public void cadastrarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    /**
     * Imprime todas as pessoas cadastradas.
     */
    public void imprimirCadastro() {
        System.out.println("\n=== PESSOAS CADASTRADAS ===");
        for (int i = 0; i < pessoas.size(); i++) {
            System.out.println("\nPessoa " + (i + 1) + ":");
            System.out.println(pessoas.get(i));
            System.out.println("---------------------------");
        }
    }
}
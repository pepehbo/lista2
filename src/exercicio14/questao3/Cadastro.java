package exercicio14.questao3;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pelo cadastro e gerenciamento de pessoas.
 */
public class Cadastro {
    private List<Pessoa> pessoas;

    /**
     * Construtor que inicializa a lista de pessoas.
     */
    public Cadastro() {
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
            Pessoa p = pessoas.get(i);
            System.out.println("Nome: " + p.getNome());
            
            if (p instanceof PessoaFisica) {
                System.out.println("CPF: " + ((PessoaFisica) p).getCPF());
            } else if (p instanceof PessoaJuridica) {
                System.out.println("CNPJ: " + ((PessoaJuridica) p).getCNPJ());
            }
            
            System.out.println("---------------------------");
        }
    }
}
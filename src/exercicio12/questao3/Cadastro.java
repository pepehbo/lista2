package exercicio12.questao3;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pelo cadastro e gerenciamento de funcionários.
 */
public class Cadastro {
    private List<Funcionario> funcionarios;

    /**
     * Construtor que inicializa a lista de funcionários.
     */
    public Cadastro() {
        funcionarios = new ArrayList<>();
    }

    /**
     * Cadastra um novo funcionário no sistema.
     * @param funcionario Funcionário a ser cadastrado
     */
    public void cadastrarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    /**
     * Imprime os dados de todos os funcionários cadastrados.
     */
    public void imprimirCadastro() {
        System.out.println("=== LISTA DE FUNCIONÁRIOS ===");
        for (int i = 0; i < funcionarios.size(); i++) {
            System.out.println("\nFuncionário " + (i + 1) + ":");
            System.out.println(funcionarios.get(i).exibe());
            System.out.println("---------------------------");
        }
    }
}
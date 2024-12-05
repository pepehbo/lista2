package exercicio13.questao1;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pelo cadastro e gerenciamento de veículos.
 */
public class CadastroVeiculos {
    private List<Veiculo> veiculos;

    /**
     * Construtor que inicializa a lista de veículos.
     */
    public CadastroVeiculos() {
        veiculos = new ArrayList<>();
    }

    /**
     * Adiciona um novo veículo ao cadastro.
     * @param veiculo Veículo a ser cadastrado
     */
    public void cadastrarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    /**
     * Imprime todos os veículos cadastrados.
     */
    public void imprimirCadastro() {
        System.out.println("\n=== VEÍCULOS CADASTRADOS ===");
        for (int i = 0; i < veiculos.size(); i++) {
            System.out.println("\nVeículo " + (i + 1) + ":");
            System.out.println(veiculos.get(i));
            System.out.println("---------------------------");
        }
    }
}
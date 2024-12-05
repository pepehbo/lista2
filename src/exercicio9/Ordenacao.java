package exercicio9;

/**
 * Classe que implementa algoritmos básicos de ordenação.
 */
public class Ordenacao {
    /**
     * Implementa o algoritmo Bubble Sort (Bolha).
     * @param vetor Vetor a ser ordenado
     */
    public void bolha(int[] vetor) {
        int n = vetor.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    // Troca os elementos
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Implementa o algoritmo Selection Sort (Seleção).
     * @param vetor Vetor a ser ordenado
     */
    public void selecao(int[] vetor) {
        int n = vetor.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (vetor[j] < vetor[minIndex]) {
                    minIndex = j;
                }
            }
            // Troca o elemento encontrado com o primeiro elemento
            int temp = vetor[minIndex];
            vetor[minIndex] = vetor[i];
            vetor[i] = temp;
        }
    }

    /**
     * Implementa o algoritmo Insertion Sort (Inserção).
     * @param vetor Vetor a ser ordenado
     */
    public void insercao(int[] vetor) {
        int n = vetor.length;
        for (int i = 1; i < n; i++) {
            int chave = vetor[i];
            int j = i - 1;
            while (j >= 0 && vetor[j] > chave) {
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = chave;
        }
    }
}
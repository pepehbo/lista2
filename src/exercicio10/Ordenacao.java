package exercicio10;

/**
 * Classe que implementa diferentes algoritmos de ordenação.
 */
public class Ordenacao {
    /**
     * Implementa o algoritmo Bubble Sort.
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
     * Implementa o algoritmo Selection Sort.
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
     * Implementa o algoritmo Insertion Sort.
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

    /**
     * Método público para iniciar o Quick Sort.
     * @param vetor Vetor a ser ordenado
     */
    public void quickSort(int[] vetor) {
        quickSort(vetor, 0, vetor.length - 1);
    }

    /**
     * Implementação recursiva do Quick Sort.
     * @param vetor Vetor a ser ordenado
     * @param inicio Índice inicial
     * @param fim Índice final
     */
    private void quickSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int pi = particionar(vetor, inicio, fim);
            quickSort(vetor, inicio, pi - 1);
            quickSort(vetor, pi + 1, fim);
        }
    }

    /**
     * Método auxiliar do Quick Sort para particionar o vetor.
     * @param vetor Vetor a ser particionado
     * @param inicio Índice inicial
     * @param fim Índice final
     * @return Índice do pivô
     */
    private int particionar(int[] vetor, int inicio, int fim) {
        int pivo = vetor[fim];
        int i = (inicio - 1);
        
        for (int j = inicio; j < fim; j++) {
            if (vetor[j] <= pivo) {
                i++;
                int temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
            }
        }
        
        int temp = vetor[i + 1];
        vetor[i + 1] = vetor[fim];
        vetor[fim] = temp;
        
        return i + 1;
    }

    /**
     * Método público para iniciar o Merge Sort.
     * @param vetor Vetor a ser ordenado
     */
    public void mergeSort(int[] vetor) {
        mergeSort(vetor, 0, vetor.length - 1);
    }

    /**
     * Implementação recursiva do Merge Sort.
     * @param vetor Vetor a ser ordenado
     * @param inicio Índice inicial
     * @param fim Índice final
     */
    private void mergeSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(vetor, inicio, meio);
            mergeSort(vetor, meio + 1, fim);
            merge(vetor, inicio, meio, fim);
        }
    }

    /**
     * Método auxiliar do Merge Sort para combinar as partes ordenadas.
     * @param vetor Vetor a ser combinado
     * @param inicio Índice inicial
     * @param meio Índice do meio
     * @param fim Índice final
     */
    private void merge(int[] vetor, int inicio, int meio, int fim) {
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = vetor[inicio + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = vetor[meio + 1 + j];
        }

        int i = 0, j = 0, k = inicio;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                vetor[k] = L[i];
                i++;
            } else {
                vetor[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            vetor[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            vetor[k] = R[j];
            j++;
            k++;
        }
    }
}
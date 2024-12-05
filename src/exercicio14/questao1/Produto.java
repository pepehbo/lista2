package exercicio14.questao1;

/**
 * Classe que representa um produto com identificador único.
 */
public class Produto {
    private int id;
    private String nome;
    private double preco;
    private static int ultimo_id = 0;

    /**
     * Construtor padrão que inicializa o produto com valores default.
     */
    public Produto() {
        this("Nome não informado", 0);
    }

    /**
     * Construtor que inicializa o produto com nome e preço específicos.
     * @param nome Nome do produto
     * @param preco Preço do produto
     */
    public Produto(String nome, double preco) {
        this.id = ++ultimo_id;
        this.nome = nome;
        setPreco(preco);
    }

    /**
     * Obtém o ID do produto.
     * @return ID do produto
     */
    public int getId() {
        return id;
    }

    /**
     * Obtém o nome do produto.
     * @return Nome do produto
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do produto.
     * @param nome Novo nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o preço do produto.
     * @return Preço do produto
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Define o preço do produto, validando que não seja negativo.
     * @param preco Novo preço
     */
    public void setPreco(double preco) {
        this.preco = preco >= 0 ? preco : 0;
    }

    /**
     * Obtém o último ID gerado.
     * @return Último ID
     */
    public static int getUltimoId() {
        return ultimo_id;
    }

    /**
     * Reajusta o preço do produto pelo percentual informado.
     * @param percentual Percentual de reajuste
     */
    public void reajustaPreco(double percentual) {
        preco *= (1 + percentual / 100);
    }

    /**
     * Retorna as informações do produto formatadas.
     * @return String com as informações do produto
     */
    public String exibe() {
        return String.format("Produto: %s\nId: %d\nNome: %s\nPreço: R$ %.2f",
            nome, id, nome, preco);
    }
}
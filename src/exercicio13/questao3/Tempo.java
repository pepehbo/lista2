package exercicio13.questao3;

/**
 * Classe que representa um tempo no formato hora:minuto:segundo.
 */
public class Tempo {
    private int hora;
    private int minuto;
    private int segundo;

    /**
     * Construtor padrão que inicializa o tempo como 0:0:0.
     */
    public Tempo() {
        this(0, 0, 0);
    }

    /**
     * Construtor que inicializa apenas a hora.
     * @param hora Hora inicial
     */
    public Tempo(int hora) {
        this(hora, 0, 0);
    }

    /**
     * Construtor que inicializa hora e minuto.
     * @param hora Hora inicial
     * @param minuto Minuto inicial
     */
    public Tempo(int hora, int minuto) {
        this(hora, minuto, 0);
    }

    /**
     * Construtor que inicializa hora, minuto e segundo.
     * @param hora Hora inicial
     * @param minuto Minuto inicial
     * @param segundo Segundo inicial
     */
    public Tempo(int hora, int minuto, int segundo) {
        setTime(hora, minuto, segundo);
    }

    /**
     * Define o tempo completo.
     * @param hora Nova hora
     * @param minuto Novo minuto
     * @param segundo Novo segundo
     */
    public void setTime(int hora, int minuto, int segundo) {
        setHora(hora);
        setMinuto(minuto);
        setSegundo(segundo);
    }

    /**
     * Define a hora.
     * @param hora Nova hora (0-23)
     */
    public void setHora(int hora) {
        if (hora >= 0 && hora <= 23) {
            this.hora = hora;
        } else {
            throw new IllegalArgumentException("Hora deve estar entre 0 e 23");
        }
    }

    /**
     * Define o minuto.
     * @param minuto Novo minuto (0-59)
     */
    public void setMinuto(int minuto) {
        if (minuto >= 0 && minuto <= 59) {
            this.minuto = minuto;
        } else {
            throw new IllegalArgumentException("Minuto deve estar entre 0 e 59");
        }
    }

    /**
     * Define o segundo.
     * @param segundo Novo segundo (0-59)
     */
    public void setSegundo(int segundo) {
        if (segundo >= 0 && segundo <= 59) {
            this.segundo = segundo;
        } else {
            throw new IllegalArgumentException("Segundo deve estar entre 0 e 59");
        }
    }

    /**
     * Obtém a hora atual.
     * @return Hora (0-23)
     */
    public int getHora() {
        return hora;
    }

    /**
     * Obtém o minuto atual.
     * @return Minuto (0-59)
     */
    public int getMinuto() {
        return minuto;
    }

    /**
     * Obtém o segundo atual.
     * @return Segundo (0-59)
     */
    public int getSegundo() {
        return segundo;
    }

    @Override
    public String toString() {
        return String.format("%d:%d:%d", hora, minuto, segundo);
    }
}
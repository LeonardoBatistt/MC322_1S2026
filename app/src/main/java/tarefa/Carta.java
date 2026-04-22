/**
 * Classe abstrata que representa uma carta do jogo.
 * Cada carta possui nome, descrição e custo de energia.
 * As subclasses devem implementar o comportamento da carta.
 */
public abstract class Carta {

    protected String nome;
    protected String descricao;
    protected int custo;

    /**
     * Construtor da carta.
     * 
     * @param nome nome da carta
     * @param descricao descrição do efeito da carta
     * @param custo custo de energia para usar a carta
     */
    public Carta(String nome, String descricao, int custo) {
        this.nome = nome;
        this.descricao = descricao;
        this.custo = custo;
    }

    /**
     * Retorna o custo da carta.
     * 
     * @return custo de energia
     */
    public int getCusto() {
        return custo;
    }

    /**
     * Retorna o nome da carta.
     * 
     * @return nome da carta
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna a descrição da carta.
     * 
     * @return descrição da carta
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Executa o efeito da carta.
     * 
     * @param heroi jogador que está usando a carta
     * @param inimigo alvo da carta
     */
    public abstract void usar(Heroi heroi, Inimigo inimigo);
}
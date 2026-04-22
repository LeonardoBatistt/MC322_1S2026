/**
 * Representa o herói controlado pelo jogador.
 * Possui vida, escudo, energia e efeitos como veneno e duplo ataque.
 */
public class Heroi extends Entidade {

    private int energia;
    private int energiaMax;
    private int veneno;
    private boolean duploAtivo;

    /**
     * Construtor do herói.
     * 
     * @param nome nome do herói
     * @param vida vida inicial
     * @param energiaMax energia máxima por turno
     */
    public Heroi(String nome, int vida, int energiaMax) {
        super(nome, vida);
        this.energiaMax = energiaMax;
        this.energia = energiaMax;
        this.veneno = 0;
        this.duploAtivo = false;
    }

    /**
     * Recupera a energia ao máximo no início do turno.
     */
    public void recuperarEnergia() {
        energia = energiaMax;
    }

    /**
     * Gasta energia ao usar uma carta.
     * 
     * @param custo custo da carta
     * @return true se conseguiu gastar, false caso contrário
     */
    public boolean gastarEnergia(int custo) {
        if (energia >= custo) {
            energia -= custo;
            return true;
        }
        return false;
    }

    /**
     * Aplica cura ao herói.
     * 
     * @param valor quantidade de vida recuperada
     */
    public void receberCura(int valor) {
        vida += valor;
        System.out.println(nome + " recuperou " + valor + " de vida!");
    }

    /**
     * Aplica efeito de veneno ao herói.
     * 
     * @param valor quantidade de veneno
     */
    public void aplicarVeneno(int valor) {
        veneno += valor;
    }
    public void adicionarEscudo(int valor) {
        escudo += valor;
    }
    /**
     * Aplica o dano de veneno no início do turno.
     */
    public void sofrerVeneno() {
        if (veneno > 0) {
            System.out.println(nome + " sofre " + veneno + " de dano por veneno!");
            receberDano(veneno);
        }
    }

    /**
     * Ativa efeito de carta dupla.
     */
    public void ativarDuplo() {
        duploAtivo = true;
        System.out.println(nome + " ativou efeito duplo!");
    }

    /**
     * Verifica se o efeito duplo está ativo.
     * 
     * @return true se ativo
     */
    public boolean isDuploAtivo() {
        return duploAtivo;
    }

    /**
     * Desativa o efeito duplo após uso.
     */
    public void desativarDuplo() {
        duploAtivo = false;
    } 

    /**
     * Retorna energia atual.
     * 
     * @return energia
     */
    public int getEnergia() {
        return energia;
    }

    /**
     * Retorna energia máxima.
     * 
     * @return energia máxima
     */
    public int getEnergiaMax() {
        return energiaMax;
    }
}
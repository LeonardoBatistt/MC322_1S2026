/**
 * Carta que ativa o efeito de ataque duplo.
 */
public class CartaFuria extends Carta {

    public CartaFuria(String nome, String descricao, int custo) {
        super(nome, descricao, custo);
    }

    @Override
    public void usar(Heroi heroi, Inimigo inimigo) {
        heroi.ativarDuplo();
    }
}
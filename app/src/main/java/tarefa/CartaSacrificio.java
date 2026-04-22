/**
 * Carta que causa alto dano ao custo de vida do herói.
 */
public class CartaSacrificio extends Carta {

    private int dano;
    private int custoVida;

    public CartaSacrificio(String nome, String descricao, int custo, int dano, int custoVida) {
        super(nome, descricao, custo);
        this.dano = dano;
        this.custoVida = custoVida;
    }

    @Override
    public void usar(Heroi heroi, Inimigo inimigo) {
        System.out.println(heroi.getNome() + " sacrificou " + custoVida + " de vida!");
        heroi.receberDano(custoVida);

        System.out.println("Causou " + dano + " de dano!");
        inimigo.receberDano(dano);
    }
}
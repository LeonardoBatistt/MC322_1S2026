/**
 * Carta que concede grande quantidade de escudo.
 */
public class CartaEscudoPesado extends Carta {

    private int escudo;

    public CartaEscudoPesado(String nome, String descricao, int custo, int escudo) {
        super(nome, descricao, custo);
        this.escudo = escudo;
    }

    @Override
    public void usar(Heroi heroi, Inimigo inimigo) {
        System.out.println(heroi.getNome() + " ganhou " + escudo + " de escudo!");
        heroi.adicionarEscudo(escudo);
    }
}
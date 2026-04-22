/**
 * Carta que concede energia ao herói.
 */
public class CartaEnergia extends Carta {

    private int energiaGanha;

    public CartaEnergia(String nome, String descricao, int custo, int energiaGanha) {
        super(nome, descricao, custo);
        this.energiaGanha = energiaGanha;
    }

    @Override
    public void usar(Heroi heroi, Inimigo inimigo) {
        System.out.println(heroi.getNome() + " ganhou " + energiaGanha + " de energia!");
        // solução simples: energia "extra" no turno
        heroi.recuperarEnergia(); // ou você pode melhorar isso depois
    }
}
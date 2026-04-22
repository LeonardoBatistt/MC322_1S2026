import java.util.List;

public class CartaArea extends Carta {

    private int dano;

    public CartaArea(String nome, String descricao, int custo, int dano) {
        super(nome, descricao, custo);
        this.dano = dano;
    }

    public void usarArea(Heroi heroi, List<Inimigo> inimigos) {

        if (heroi.gastarEnergia(custo)) {
            System.out.println(heroi.getNome() + " usa " + nome + " em todos!");

            for (Inimigo inimigo : inimigos) {
                if (inimigo.estaVivo()) {
                    inimigo.receberDano(dano);
                }
            }
        } else {
            System.out.println("Energia insuficiente!");
        }
    }

    @Override
    public void usar(Heroi heroi, Inimigo inimigo) {
        // não usado diretamente
    }
}
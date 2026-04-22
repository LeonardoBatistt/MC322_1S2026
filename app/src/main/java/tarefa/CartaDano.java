public class CartaDano extends Carta {

    private int dano;

    public CartaDano(String nome, String descricao, int custo, int dano) {
        super(nome, descricao, custo);
        this.dano = dano;
    }

    @Override
    public void usar(Heroi heroi, Inimigo inimigo) {

        if (heroi.gastarEnergia(custo)) {
            System.out.println(heroi.getNome() + " usa " + nome);
            inimigo.receberDano(dano);
        } else {
            System.out.println("Energia insuficiente!");
        }
    }
}
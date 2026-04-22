public class CartaCura extends Carta {

    private int cura;

    public CartaCura(String nome, String descricao, int custo, int cura) {
        super(nome, descricao, custo);
        this.cura = cura;
    }

    @Override
    public void usar(Heroi heroi, Inimigo inimigo) {

        if (heroi.gastarEnergia(custo)) {
            System.out.println(heroi.getNome() + " usa " + nome);
            heroi.receberCura(cura);
        } else {
            System.out.println("Energia insuficiente!");
        }
    }
}
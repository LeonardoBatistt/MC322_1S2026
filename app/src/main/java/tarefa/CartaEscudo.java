public class CartaEscudo extends Carta {

    private int escudo;

    public CartaEscudo(String nome, String descricao, int custo, int escudo) {
        super(nome, descricao, custo);
        this.escudo = escudo;
    }

    @Override
    public void usar(Heroi heroi, Inimigo inimigo) {

        if (heroi.gastarEnergia(custo)) {
            System.out.println(heroi.getNome() + " usa " + nome);
            heroi.ganharEscudo(escudo);
        } else {
            System.out.println("Energia insuficiente!");
        }
    }
}
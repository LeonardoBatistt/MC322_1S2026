public class CartaDupla extends Carta {

    public CartaDupla(String nome, String descricao, int custo) {
        super(nome, descricao, custo);
    }

    @Override
    public void usar(Heroi heroi, Inimigo inimigo) {

        if (heroi.gastarEnergia(custo)) {
            System.out.println(heroi.getNome() + " usou " + nome);
            heroi.ativarDuplo();
        } else {
            System.out.println("Energia insuficiente!");
        }
    }
}
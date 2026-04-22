
public class CartaVeneno extends Carta {

    private int veneno;

    public CartaVeneno(String nome, String descricao, int custo, int veneno) {
        super(nome, descricao, custo);
        this.veneno = veneno;
    }

    @Override
    public void usar(Heroi heroi, Inimigo inimigo) {

        if (heroi.gastarEnergia(custo)) {
            System.out.println(heroi.getNome() + " envenena " + inimigo.getNome());
            inimigo.aplicarVeneno(veneno);
        } else {
            System.out.println("Energia insuficiente!");
        }
    }
}
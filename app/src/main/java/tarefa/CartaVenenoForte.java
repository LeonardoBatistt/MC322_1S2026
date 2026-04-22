/**
 * Carta que aplica veneno forte ao inimigo.
 */
public class CartaVenenoForte extends Carta {

    private int veneno;

    public CartaVenenoForte(String nome, String descricao, int custo, int veneno) {
        super(nome, descricao, custo);
        this.veneno = veneno;
    }

    @Override
    public void usar(Heroi heroi, Inimigo inimigo) {
        System.out.println("Aplicando " + veneno + " de veneno!");
        inimigo.aplicarVeneno(veneno);
    }
}
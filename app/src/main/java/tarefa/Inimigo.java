public class Inimigo extends Entidade {

    private int dano;
    private int intencaoDano;

    public Inimigo(String nome, int vida, int dano) {
        super(nome, vida);
        this.dano = dano;
    }

    // anuncia o ataque do turno
    public void anunciarIntencao() {
        intencaoDano = dano;
        System.out.println(nome + " pretende causar " + intencaoDano + " de dano!");
    }

    // executa o ataque anunciado
    public void atacar(Heroi heroi) {
        System.out.println(nome + " ataca causando " + intencaoDano + " de dano!");
        heroi.receberDano(intencaoDano);
    }

    private int veneno = 0;

    public void aplicarVeneno(int valor) {
        veneno += valor;
    }

    public void sofrerVeneno() {
        if (veneno > 0) {
            System.out.println(getNome() + " sofre " + veneno + " de veneno!");
            receberDano(veneno);
        }
    }
}   
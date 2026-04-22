public abstract class Entidade {

    protected String nome;
    protected int vida;
    protected int escudo;

    public Entidade(String nome, int vida) {
        this.nome = nome;
        this.vida = vida;
        this.escudo = 0;
    }

    public void receberDano(int dano) {

        int danoRestante = dano - escudo;

        if (danoRestante > 0) {
            vida -= danoRestante;
            escudo = 0;
        } else {
            escudo -= dano;
        }

        if (vida < 0) {
            vida = 0;
        }
    }

    public void ganharEscudo(int valor) {
        escudo += valor;
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void zerarEscudo() {
        escudo = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public int getEscudo() {
        return escudo;
    }
}
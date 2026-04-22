/**
 * Representa o herói controlado pelo jogador.
 */
public class Heroi extends Entidade {

    private int energia;
    private int energiaMax;
    private int veneno;
    private boolean duploAtivo;

    public Heroi(String nome, int vida, int energiaMax) {
        super(nome, vida);
        this.energiaMax = energiaMax;
        this.energia = energiaMax;
        this.veneno = 0;
        this.duploAtivo = false;
    }

    public void recuperarEnergia() {
        energia = energiaMax;
    }

    public boolean gastarEnergia(int custo) {
        if (energia >= custo) {
            energia -= custo;
            return true;
        }
        System.out.println("Energia insuficiente!");
        return false;
    }

    public void receberCura(int valor) {
        vida += valor;
        System.out.println(nome + " recuperou " + valor + " de vida!");
    }

    public void aplicarVeneno(int valor) {
        veneno += valor;
    }

    public void adicionarEscudo(int valor) {
        escudo += valor;
        System.out.println(nome + " ganhou " + valor + " de escudo!");
    }

    public void sofrerVeneno() {
        if (veneno > 0) {
            System.out.println(nome + " sofre " + veneno + " de dano por veneno!");
            receberDano(veneno);

            //  diminui o veneno ao longo do tempo
            veneno--;
        }
    }

    public void ativarDuplo() {
        duploAtivo = true;
        System.out.println(nome + " ativou efeito duplo!");
    }

    public boolean isDuploAtivo() {
        return duploAtivo;
    }

    public void desativarDuplo() {
        duploAtivo = false;
    }

    public int getEnergia() {
        return energia;
    }

    public int getEnergiaMax() {
        return energiaMax;
    }
}
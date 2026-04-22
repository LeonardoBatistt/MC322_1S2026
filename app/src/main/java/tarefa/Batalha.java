public class Batalha {

    private Heroi heroi;
    private Inimigo inimigo;
    private UI ui;

    public Batalha(Heroi heroi, Inimigo inimigo, UI ui) {
        this.heroi = heroi;
        this.inimigo = inimigo;
        this.ui = ui;
    }

    public boolean executar() {
        // loop de combate (move do Jogo pra cá)

        while (heroi.getVida() > 0 && inimigo.getVida() > 0) {

            ui.mostrarStatus(heroi, inimigo);

            // turno do jogador
            heroi.jogarTurno(inimigo);

            if (inimigo.getVida() <= 0) return true;

            // turno do inimigo
            inimigo.atacar(heroi);

            heroi.resetarTurno(); // energia/efeitos temporários
        }

        return heroi.getVida() > 0;
    }
}
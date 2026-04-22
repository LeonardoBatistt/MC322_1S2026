import java.util.*;

/**
 * Classe responsável por executar uma batalha completa.
 */
public class Batalha {

    private Heroi heroi;
    private List<Inimigo> inimigos;
    private Baralho baralho;
    private Scanner sc;

    public Batalha(Heroi heroi, List<Inimigo> inimigos, Baralho baralho, Scanner sc) {
        this.heroi = heroi;
        this.inimigos = inimigos;
        this.baralho = baralho;
        this.sc = sc;
    }

    public boolean executar() {

        System.out.println(UI.VERMELHO + " Inimigos apareceram!" + UI.RESET);
        UI.pausa(800);

        while (heroi.estaVivo() && !inimigos.isEmpty()) {
            executarTurno();
        }

        return heroi.estaVivo();
    }

    private void executarTurno() {

        UI.limparTela();

        System.out.println(UI.CIANO + "=========================");
        System.out.println("   NOVO TURNO   ");
        System.out.println("=========================" + UI.RESET);

        UI.pausa(500);

        heroi.recuperarEnergia();
        heroi.zerarEscudo();

        for (Inimigo i : inimigos)
            i.sofrerVeneno();

        for (Inimigo i : inimigos)
            i.anunciarIntencao();

        baralho.comprarCartas(5);

        boolean turno = true;

        while (turno) {

            mostrarEstado();

            int escolha = lerInt(" Escolha carta (-1 termina turno):");

            if (escolha == -1) {
                turno = false;
                continue;
            }

            ArrayList<Carta> mao = baralho.getMao();

            if (escolha < 0 || escolha >= mao.size()) {
                System.out.println(" Escolha inválida!");
                continue;
            }

            Carta carta = mao.get(escolha);

            if (heroi.getEnergia() < carta.getCusto()) {
                System.out.println(" Energia insuficiente!");
                continue;
            }

            int alvo = lerInt(" Escolha o alvo:");

            if (alvo < 0 || alvo >= inimigos.size()) {
                System.out.println(" Alvo inválido!");
                continue;
            }

            System.out.println(UI.AMARELO + "\n Usando " + carta.getNome() + "..." + UI.RESET);
            UI.pausa(400);

            baralho.usarCarta(escolha, heroi, inimigos.get(alvo));

            inimigos.removeIf(i -> !i.estaVivo());

            if (inimigos.isEmpty())
                break;
        }

        baralho.descartarMao();

        System.out.println(UI.VERMELHO + "\n Turno dos inimigos..." + UI.RESET);
        UI.pausa(700);

        for (Inimigo i : inimigos) {
            if (i.estaVivo()) {
                i.atacar(heroi);
                UI.pausa(500);
            }
        }
    }

    private void mostrarEstado() {

        System.out.println(UI.VERDE + "\n HEROI" + UI.RESET);
        System.out.println("HP: " + UI.barra(heroi.getVida(), 50) + " " + heroi.getVida());
        System.out.println(" Escudo: " + heroi.getEscudo());
        System.out.println(" Energia: " + heroi.getEnergia());

        System.out.println(UI.VERMELHO + "\n INIMIGOS" + UI.RESET);
        for (int i = 0; i < inimigos.size(); i++) {
            Inimigo inimigo = inimigos.get(i);

            System.out.println(i + " - " + inimigo.getNome());
            System.out.println("HP: " + UI.barra(inimigo.getVida(), 120) + " " + inimigo.getVida());
            System.out.println(" Escudo: " + inimigo.getEscudo());
        }

        System.out.println(UI.AZUL + "\n🃏 CARTAS" + UI.RESET);

        ArrayList<Carta> mao = baralho.getMao();

        for (int i = 0; i < mao.size(); i++) {
            Carta c = mao.get(i);

            System.out.println(i + " - "
                    + UI.AMARELO + c.getNome() + UI.RESET
                    + " |  " + c.getCusto());

            System.out.println("   → " + c.getDescricao());
        }
    }

    private int lerInt(String msg) {
        System.out.println(msg);

        while (!sc.hasNextInt()) {
            System.out.println("❌ Entrada inválida!");
            sc.next();
        }

        return sc.nextInt();
    }
}
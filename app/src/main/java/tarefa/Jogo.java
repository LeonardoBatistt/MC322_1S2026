import java.util.*;

/**
 * Classe responsável por controlar o fluxo do jogo.
 */
public class Jogo {

    private Heroi heroi;
    private List<Inimigo> inimigos;
    private Baralho baralho;
    private Scanner sc;

    public Jogo() {
        sc = new Scanner(System.in);
        heroi = new Heroi("Guerreiro", 50, 3);
        inimigos = gerarInimigos();
        baralho = criarBaralho();
    }

    private List<Inimigo> gerarInimigos() {
        List<Inimigo> lista = new ArrayList<>();
        Random r = new Random();

        int qtd = r.nextInt(2) + 1;

        for (int i = 0; i < qtd; i++) {
            int tipo = r.nextInt(3);

            if (tipo == 0)
                lista.add(new Inimigo("Goblin", 40, 6));
            else if (tipo == 1)
                lista.add(new Inimigo("Ogro", 70, 10));
            else
                lista.add(new Inimigo("Dragão", 120, 18));
        }

        return lista;
    }

    private Baralho criarBaralho() {
        List<Carta> cartas = new ArrayList<>();

        for (int i = 0; i < 5; i++)
            cartas.add(new CartaDano("Ataque", "Causa 6 de dano", 1, 6));

        for (int i = 0; i < 5; i++)
            cartas.add(new CartaEscudo("Defesa", "Ganha 5 de escudo", 1, 5));

        for (int i = 0; i < 3; i++)
            cartas.add(new CartaCura("Cura", "Recupera 5 de vida", 1, 5));

        for (int i = 0; i < 2; i++)
            cartas.add(new CartaDupla("Duplo", "Próxima carta duas vezes", 1));

        for (int i = 0; i < 2; i++)
            cartas.add(new CartaVeneno("Veneno", "Aplica 3 de veneno", 1, 3));

        for (int i = 0; i < 2; i++)
            cartas.add(new CartaArea("Explosão", "Causa 4 de dano em todos", 2, 4));

        // novas cartas
        cartas.add(new CartaEnergia("Energizar", "Recupera energia", 0, 2));
        cartas.add(new CartaSacrificio("Sacrifício", "Perde 5 HP, causa 15 dano", 1, 15, 5));
        cartas.add(new CartaFuria("Fúria", "Ativa ataque duplo", 1));
        cartas.add(new CartaVenenoForte("Veneno+", "Aplica 6 veneno", 2, 6));
        cartas.add(new CartaEscudoPesado("Defesa+", "Ganha 12 escudo", 2, 12));

        return new Baralho(cartas);
    }

    public void iniciar() {
        System.out.println(UI.VERMELHO + " Inimigos apareceram!" + UI.RESET);
        UI.pausa(800);

        while (heroi.estaVivo() && !inimigos.isEmpty()) {
            executarTurno();
        }

        if (heroi.estaVivo())
            System.out.println(UI.VERDE + "\n VOCÊ VENCEU!" + UI.RESET);
        else
            System.out.println(UI.VERMELHO + "\n VOCÊ PERDEU!" + UI.RESET);

        sc.close();
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
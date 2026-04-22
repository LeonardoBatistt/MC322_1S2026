import java.util.*;

/**
 * Classe responsável por controlar o fluxo do jogo com mapa e progressão.
 */
public class Jogo {

    private Heroi heroi;
    private Baralho baralho;
    private Scanner sc;
    private UI ui;

    private Mapa mapa;

    public Jogo() {
        sc = new Scanner(System.in);
        ui = new UI();

        heroi = new Heroi("Guerreiro", 50, 3);
        baralho = criarBaralho();
    }

    public void iniciar() {

        System.out.println(UI.CIANO + " Iniciando aventura..." + UI.RESET);
        UI.pausa(800);

        mapa = criarMapa();

        while (true) {

            NoMapa atual = mapa.getAtual();

            System.out.println(UI.AMARELO + "\n Nova batalha!" + UI.RESET);

            boolean venceu = atual.getBatalha().executar();

            if (!venceu) {
                System.out.println(UI.VERMELHO + "\n VOCÊ PERDEU!" + UI.RESET);
                break;
            }

            atual.setVisitado(true);

            if (atual.getProximos().isEmpty()) {
                System.out.println(UI.VERDE + "\n VOCÊ VENCEU O JOGO!" + UI.RESET);
                break;
            }

            int escolha = escolherCaminho(atual.getProximos());
            mapa.avancar(escolha);
        }

        sc.close();
    }

    /**
     * Cria o mapa do jogo (estrutura em árvore)
     */
    private Mapa criarMapa() {

        // criar nós com batalhas diferentes
        NoMapa n1 = new NoMapa(criarBatalha());
        NoMapa n2 = new NoMapa(criarBatalha());
        NoMapa n3 = new NoMapa(criarBatalha());
        NoMapa n4 = new NoMapa(criarBatalha());

        // estrutura de árvore
        n1.adicionarProximo(n2);
        n1.adicionarProximo(n3);

        n2.adicionarProximo(n4);
        n3.adicionarProximo(n4);

        return new Mapa(n1);
    }

    /**
     * Cria uma batalha com inimigos aleatórios
     */
    private Batalha criarBatalha() {
        List<Inimigo> inimigos = gerarInimigos();
        return new Batalha(heroi, inimigos, baralho, sc);
    }

    /**
     * Escolha de caminho
     */
    private int escolherCaminho(List<NoMapa> opcoes) {

        System.out.println(UI.CIANO + "\n Escolha o próximo caminho:" + UI.RESET);

        for (int i = 0; i < opcoes.size(); i++) {
            System.out.println(i + " - Caminho " + (i + 1));
        }

        int escolha;

        while (true) {
            escolha = lerInt("Digite sua escolha:");

            if (escolha >= 0 && escolha < opcoes.size())
                break;

            System.out.println("❌ Opção inválida!");
        }

        return escolha;
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

        cartas.add(new CartaEnergia("Energizar", "Recupera energia", 0, 2));
        cartas.add(new CartaSacrificio("Sacrifício", "Perde 5 HP, causa 15 dano", 1, 15, 5));
        cartas.add(new CartaFuria("Fúria", "Ativa ataque duplo", 1));
        cartas.add(new CartaVenenoForte("Veneno+", "Aplica 6 veneno", 2, 6));
        cartas.add(new CartaEscudoPesado("Defesa+", "Ganha 12 escudo", 2, 12));

        return new Baralho(cartas);
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
import java.util.*;

public class Baralho {

    private Stack<Carta> compra = new Stack<>();
    private ArrayList<Carta> mao = new ArrayList<>();
    private Stack<Carta> descarte = new Stack<>();

    public Baralho(List<Carta> cartasIniciais) {

        compra.addAll(cartasIniciais);
        Collections.shuffle(compra);
    }

    public void comprarCartas(int quantidade) {

        for (int i = 0; i < quantidade; i++) {

            if (compra.isEmpty()) {
                reciclarDescarte();
            }

            if (!compra.isEmpty()) {
                mao.add(compra.pop());
            }
        }
    }
    public void usarCarta(int index, Heroi heroi, Inimigo inimigo) {

        Carta carta = mao.remove(index);

        // verifica efeito duplo
        if (heroi.isDuploAtivo()) {

            System.out.println("Efeito duplo ativado!");

            carta.usar(heroi, inimigo);
            carta.usar(heroi, inimigo);

            heroi.desativarDuplo();

        } else {
            carta.usar(heroi, inimigo);
        }

    descarte.push(carta);
    }

    private void reciclarDescarte() {

        if (descarte.isEmpty()) {
            return;
        }

        System.out.println("Baralho vazio. Embaralhando descarte.");

        compra.addAll(descarte);
        descarte.clear();

        Collections.shuffle(compra);
    }

    public ArrayList<Carta> getMao() {
        return mao;
    }

   

    public void descartarMao() {

        descarte.addAll(mao);

        mao.clear();
    }
}
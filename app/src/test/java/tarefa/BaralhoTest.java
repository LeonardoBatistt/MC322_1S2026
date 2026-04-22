import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class BaralhoTest {
    @Test
    public void baralhoFluxoCompleto() {
        List<Carta> cartas = new ArrayList<>();

        cartas.add(new CartaDano("Atk", "dano", 1, 5));
        cartas.add(new CartaEscudo("Def", "escudo", 1, 5));

        Baralho b = new Baralho(cartas);

        b.comprarCartas(2);
        assertEquals(2, b.getMao().size());

        Heroi h = new Heroi("Teste", 20, 3);
        Inimigo i = new Inimigo("Dummy", 20, 0);

        b.usarCarta(0, h, i);

        assertTrue(b.getMao().size() <= 1);
}
    @Test
    public void compraCartas() {

        List<Carta> cartas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            cartas.add(new CartaDano("Atk", "Dano", 1, 5));
        }

        Baralho baralho = new Baralho(cartas);

        baralho.comprarCartas(5);

        assertEquals(5, baralho.getMao().size());
    }

    @Test
    public void descartarMaoFunciona() {

        List<Carta> cartas = new ArrayList<>();
        cartas.add(new CartaDano("Atk", "Dano", 1, 5));

        Baralho baralho = new Baralho(cartas);

        baralho.comprarCartas(1);
        baralho.descartarMao();

        assertEquals(0, baralho.getMao().size());
    }

    @Test
    public void usarCartaRemoveDaMao() {

        List<Carta> cartas = new ArrayList<>();
        cartas.add(new CartaDano("Atk", "Dano", 1, 5));

        Baralho baralho = new Baralho(cartas);
        Heroi h = new Heroi("Teste", 20, 3);
        Inimigo i = new Inimigo("Dummy", 20, 0);

        baralho.comprarCartas(1);
        baralho.usarCarta(0, h, i);

        assertEquals(0, baralho.getMao().size());
    }
}
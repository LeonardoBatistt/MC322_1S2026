import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class MapaTest {

    @Test
    public void mapaAvanca() {
        Heroi h = new Heroi("Teste", 20, 3);
        Baralho b = new Baralho(new ArrayList<>());
        Scanner sc = new Scanner(System.in);

        Batalha b1 = new Batalha(h, new ArrayList<>(), b, sc);
        Batalha b2 = new Batalha(h, new ArrayList<>(), b, sc);

        NoMapa n1 = new NoMapa(b1);
        NoMapa n2 = new NoMapa(b2);

        n1.adicionarProximo(n2);

        Mapa mapa = new Mapa(n1);

        mapa.avancar(0);

        assertEquals(n2, mapa.getAtual());
    }
}
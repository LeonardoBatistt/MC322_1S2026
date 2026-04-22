import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class BatalhaTest {

    @Test
    public void batalhaExecuta() {
        Heroi h = new Heroi("Teste", 30, 5);

        // baralho simples
        List<Carta> cartas = new ArrayList<>();
        cartas.add(new CartaDano("Atk", "dano", 1, 5));

        Baralho b = new Baralho(cartas);

        // inimigo fraco
        List<Inimigo> inimigos = new ArrayList<>();
        inimigos.add(new Inimigo("Dummy", 5, 0));

        // simula input:
        // 0 = escolhe carta
        // 0 = escolhe alvo
        // -1 = termina turno
        Scanner sc = new Scanner("0\n0\n-1\n");

        Batalha batalha = new Batalha(h, inimigos, b, sc);

        boolean resultado = batalha.executar();

        assertTrue(resultado);
    }
}
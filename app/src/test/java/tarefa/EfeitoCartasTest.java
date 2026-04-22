import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EfeitoCartasTest {

    @Test
    public void cartaVenenoAplica() {
        Heroi h = new Heroi("Teste", 20, 3);
        Inimigo i = new Inimigo("Dummy", 20, 0);

        Carta c = new CartaVeneno("Veneno", "Teste", 1, 3);

        c.usar(h, i);
        i.sofrerVeneno();

        assertEquals(17, i.getVida());
    }
}
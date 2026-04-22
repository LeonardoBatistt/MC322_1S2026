import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HeroiTest {

    @Test
    public void danoComEscudo() {
        Heroi h = new Heroi("Teste", 20, 3);

        h.ganharEscudo(5);
        h.receberDano(3);

        assertEquals(20, h.getVida());
        assertEquals(2, h.getEscudo());
    }

    @Test
    public void danoSemEscudo() {
        Heroi h = new Heroi("Teste", 20, 3);

        h.receberDano(5);

        assertEquals(15, h.getVida());
    }

    @Test
    public void energiaResetaCorretamente() {
        Heroi h = new Heroi("Teste", 20, 3);

        h.gastarEnergia(2);
        h.recuperarEnergia();

        assertEquals(3, h.getEnergia());
    }
}
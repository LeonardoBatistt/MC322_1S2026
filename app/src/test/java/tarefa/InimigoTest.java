import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InimigoTest {

    @Test
    public void inimigoRecebeDano() {
        Inimigo i = new Inimigo("Goblin", 30, 5);

        i.receberDano(10);

        assertEquals(20, i.getVida());
    }

    @Test
    public void venenoFunciona() {
        Inimigo i = new Inimigo("Goblin", 30, 5);

        i.aplicarVeneno(3);
        i.sofrerVeneno();

        assertEquals(27, i.getVida());
    }

    @Test
    public void inimigoMorre() {
        Inimigo i = new Inimigo("Goblin", 10, 5);

        i.receberDano(20);

        assertFalse(i.estaVivo());
    }
}
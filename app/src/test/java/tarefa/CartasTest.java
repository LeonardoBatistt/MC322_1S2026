
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CartasTest {

    @Test
    public void cartaDanoFunciona() {
        Heroi h = new Heroi("Teste", 20, 3);
        Inimigo i = new Inimigo("Dummy", 20, 0);

        Carta c = new CartaDano("Atk", "Dano", 1, 5);

        c.usar(h, i);

        assertEquals(15, i.getVida());
    
        
        new CartaEscudo("Def", "escudo", 1, 5).usar(h, i);
        new CartaCura("Cura", "cura", 1, 5).usar(h, i);
        new CartaEnergia("Energia", "energia", 0, 2).usar(h, i);

        assertTrue(h.getVida() > 0);
    }
}
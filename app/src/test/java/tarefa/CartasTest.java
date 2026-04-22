
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
    @Test
    public void cartasAvancadasFuncionam() {
        Heroi h = new Heroi("Teste", 30, 5);
        Inimigo i = new Inimigo("Dummy", 30, 0);

        new CartaSacrificio("Sac", "sac", 1, 10, 5).usar(h, i);
        new CartaEscudoPesado("Def+", "def", 2, 10).usar(h, i);
        new CartaVenenoForte("Veneno+", "ven", 2, 5).usar(h, i);
        new CartaFuria("Furia", "furia", 1).usar(h, i);

        assertTrue(h.getVida() > 0);
    }
}
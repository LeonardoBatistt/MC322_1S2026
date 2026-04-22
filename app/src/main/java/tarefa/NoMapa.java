
import java.util.ArrayList;
import java.util.List;

public class NoMapa {

    private Batalha batalha;
    private List<NoMapa> proximos;
    private boolean visitado;

    public NoMapa(Batalha batalha) {
        this.batalha = batalha;
        this.proximos = new ArrayList<>();
        this.visitado = false;
    }

    public void adicionarProximo(NoMapa no) {
        proximos.add(no);
    }

    public List<NoMapa> getProximos() {
        return proximos;
    }

    public Batalha getBatalha() {
        return batalha;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }
}
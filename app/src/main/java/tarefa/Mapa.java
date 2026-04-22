import java.util.List;

public class Mapa {

    private NoMapa atual;

    public Mapa(NoMapa raiz) {
        this.atual = raiz;
    }

    public NoMapa getAtual() {
        return atual;
    }

    public void avancar(int escolha) {
        List<NoMapa> opcoes = atual.getProximos();
        atual = opcoes.get(escolha);
    }
}
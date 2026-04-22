public class UI {

    public static final String RESET = "\u001B[0m";
    public static final String VERMELHO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARELO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";
    public static final String ROXO = "\u001B[35m";
    public static final String CIANO = "\u001B[36m";

    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pausa(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static String barra(int atual, int max) {
        int total = 20;
        int preenchido = (int) ((double) atual / max * total);

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < total; i++) {
            if (i < preenchido) sb.append("#");
            else sb.append(" ");
        }
        sb.append("]");

        return sb.toString();
    }
}
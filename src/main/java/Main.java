import service.jogo.JogoServiceImpl;
import service.tabuleiro.TabuleiroServiceImpl;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello wolrd!");
        TabuleiroServiceImpl tabuleiroService = new TabuleiroServiceImpl();
        JogoServiceImpl jogoService = new JogoServiceImpl(tabuleiroService);
        jogoService.iniciarJogo();
    }
}

package service.tabuleiro;

import model.Tabuleiro;

public interface TabuleiroServiceInterface {
    public void iniciarTabuleiro();
    public Boolean TentarMarcarPosicao(int[] tentativa, int jogador);
    public int verificarTabuleiro();
    public void exibeTabuleiro();
    public boolean tabuleiroCompleto();
    public boolean tabuleiroZerado();
}

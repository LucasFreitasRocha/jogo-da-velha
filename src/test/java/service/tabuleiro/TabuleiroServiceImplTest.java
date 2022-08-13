package service.tabuleiro;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class TabuleiroServiceImplTest {

    @Spy
    @InjectMocks
    private TabuleiroServiceImpl service;


    // ao iniciar o tabuleiro ele deve vim zerado;
    @Test
    void iniciarTabuleiro() {
        service.iniciarTabuleiro();
        assertTrue(service.tabuleiroZerado());

    }

    // tentar colocar x ou o em um posicao já utilizada
    @Test
    void tentativaFail() {
        service.iniciarTabuleiro();

        service.TentarMarcarPosicao(buildTentativa(), 1);

        assertTrue(!service.TentarMarcarPosicao(buildTentativa(), 1));
    }

    private int[] buildTentativa() {
        int[] tentativa = new int[2];
        tentativa[0] = 0;
        tentativa[1] = 0;
        return tentativa;
    }

    @Test
    void tentativaSucesso() {
        service.iniciarTabuleiro();
        assertTrue(service.TentarMarcarPosicao(buildTentativa(), 1));
    }

    // vai colocando posições na linha 1 (0 da matriz) para ganhar
    @Test
    void linhaUmCompletaGanhador() {
        int[] posicao = new int[2];
        service.iniciarTabuleiro();
        assertTrue(service.tabuleiroZerado());
        posicao[0] = 0;
        posicao[1] = 0;
        service.TentarMarcarPosicao(posicao, 1);
        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 1;
        posicao[1] = 0;
        service.TentarMarcarPosicao(posicao, -1);
        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 0;
        posicao[1] = 1;
        service.TentarMarcarPosicao(posicao, 1);
        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 1;
        posicao[1] = 1;
        service.TentarMarcarPosicao(posicao, -1);
        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 0;
        posicao[1] = 2;
        service.TentarMarcarPosicao(posicao, 1);

        System.out.println("linha 1 completa");
        service.exibeTabuleiro();
        assertEquals(1, service.verificarTabuleiro());

    }

    // vai colocando posições na linha 2 (1 da matriz) para ganhar
    @Test
    void linhaDoisCompletaGanhador() {
        int[] posicao = new int[2];
        service.iniciarTabuleiro();
        assertTrue(service.tabuleiroZerado());

        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 1;
        posicao[1] = 0;
        service.TentarMarcarPosicao(posicao, 1);

        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 0;
        posicao[1] = 0;
        service.TentarMarcarPosicao(posicao, -1);
        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 1;
        posicao[1] = 1;
        service.TentarMarcarPosicao(posicao, 1);

        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 2;
        posicao[1] = 0;
        service.TentarMarcarPosicao(posicao, -1);
        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 1;
        posicao[1] = 2;
        service.TentarMarcarPosicao(posicao, 1);
        System.out.println("linha 2 completa");
        service.exibeTabuleiro();
        assertEquals(1, service.verificarTabuleiro());
    }

    // vai colocando posições na linha 3 (2 da matriz) para ganhar
    @Test
    void linha3CompletaGanhador() {
        int[] posicao = new int[2];
        service.iniciarTabuleiro();
        assertTrue(service.tabuleiroZerado());
        posicao[0] = 2;
        posicao[1] = 0;
        service.TentarMarcarPosicao(posicao, 1);
        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 0;
        posicao[1] = 0;
        service.TentarMarcarPosicao(posicao, -1);

        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 2;
        posicao[1] = 1;
        service.TentarMarcarPosicao(posicao, 1);

        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 0;
        posicao[1] = 1;
        service.TentarMarcarPosicao(posicao, -1);
        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 2;
        posicao[1] = 2;
        service.TentarMarcarPosicao(posicao, 1);
        System.out.println("linha 3 completa");
        service.exibeTabuleiro();
        assertEquals(1, service.verificarTabuleiro());
    }

    // vai colocando posições na coluna 1 (0 da matriz) para ganhar
    @Test
    void colunaUmCompletaGanhador() {
        int[] posicao = new int[2];
        service.iniciarTabuleiro();
        assertTrue(service.tabuleiroZerado());

        posicao[0] = 0;
        posicao[1] = 0;
        service.TentarMarcarPosicao(posicao, -1);
        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 2;
        posicao[1] = 1;
        service.TentarMarcarPosicao(posicao, 1);

        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 1;
        posicao[1] = 0;
        service.TentarMarcarPosicao(posicao, -1);
        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 2;
        posicao[1] = 2;
        service.TentarMarcarPosicao(posicao, 1);
        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 2;
        posicao[1] = 0;
        service.TentarMarcarPosicao(posicao, -1);
        System.out.println("coluna 1 completa");
        service.exibeTabuleiro();
        assertEquals(-1, service.verificarTabuleiro());
    }

    // vai colocando posições na coluna 2 (1 da matriz) para ganhar
    @Test
    void colunaDoisCompletaGanhador() {
        int[] posicao = new int[2];
        service.iniciarTabuleiro();
        assertTrue(service.tabuleiroZerado());

        posicao[0] = 0;
        posicao[1] = 1;
        service.TentarMarcarPosicao(posicao, -1);
        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 0;
        posicao[1] = 2;
        service.TentarMarcarPosicao(posicao, 1);
        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 1;
        posicao[1] = 1;
        service.TentarMarcarPosicao(posicao, -1);

        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 0;
        posicao[1] = 0;
        service.TentarMarcarPosicao(posicao, 1);
        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 2;
        posicao[1] = 1;
        service.TentarMarcarPosicao(posicao, -1);
        System.out.println("coluna 2 completa");
        service.exibeTabuleiro();
        assertEquals(-1, service.verificarTabuleiro());
    }

    // vai colocando posições na coluna 3 (2 da matriz) para ganhar
    @Test
    void colunaTresCompletaGanhador() {
        int[] posicao = new int[2];
        service.iniciarTabuleiro();
        assertTrue(service.tabuleiroZerado());

        posicao[0] = 0;
        posicao[1] = 2;
        service.TentarMarcarPosicao(posicao, -1);
        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 0;
        posicao[1] = 1;
        service.TentarMarcarPosicao(posicao, 1);
        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 1;
        posicao[1] = 2;
        service.TentarMarcarPosicao(posicao, -1);
        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 0;
        posicao[1] = 0;
        service.TentarMarcarPosicao(posicao, 1);
        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 2;
        posicao[1] = 2;
        service.TentarMarcarPosicao(posicao, -1);
        System.out.println("coluna 3 completa");
        service.exibeTabuleiro();
        assertEquals(-1, service.verificarTabuleiro());
    }

    // vai colocando posições na diagonal principal para ganhar

    @Test
    void diagonal1CompletaGanhador() {
        int[] posicao = new int[2];
        service.iniciarTabuleiro();
        assertTrue(service.tabuleiroZerado());

        posicao[0] = 0;
        posicao[1] = 0;
        service.TentarMarcarPosicao(posicao, -1);
        assertEquals(0, service.verificarTabuleiro());

        posicao[0] = 0;
        posicao[1] = 1;
        service.TentarMarcarPosicao(posicao, 1);

        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 1;
        posicao[1] = 1;
        service.TentarMarcarPosicao(posicao, -1);
        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 0;
        posicao[1] = 2;
        service.TentarMarcarPosicao(posicao, 1);
        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 2;
        posicao[1] = 2;
        service.TentarMarcarPosicao(posicao, -1);
        System.out.println("diagonal 1 completa");
        service.exibeTabuleiro();
        assertEquals(-1, service.verificarTabuleiro());
    }

    // vai colocando posições na diagonal secundaria para ganhar
    @Test
    void diagonal2CompletaGanhador() {
        int[] posicao = new int[2];
        service.iniciarTabuleiro();
        assertTrue(service.tabuleiroZerado());

        posicao[0] = 0;
        posicao[1] = 2;
        service.TentarMarcarPosicao(posicao, -1);
        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 0;
        posicao[1] = 1;
        service.TentarMarcarPosicao(posicao, 1);
        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 1;
        posicao[1] = 1;
        service.TentarMarcarPosicao(posicao, -1);
        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 2;
        posicao[1] = 2;
        service.TentarMarcarPosicao(posicao, 1);
        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 2;
        posicao[1] = 0;
        service.TentarMarcarPosicao(posicao, -1);
        System.out.println("diagonal 2 completa");
        service.exibeTabuleiro();
        assertEquals(-1, service.verificarTabuleiro());
    }

    // verifica se o tabuleiro ficou completo, sem ganhador
    @Test
    void tabuleiroCompleto() {
        int[] posicao = new int[2];
        service.iniciarTabuleiro();
        assertTrue(service.tabuleiroZerado());
        posicao[0] = 0;
        posicao[1] = 0;
        service.TentarMarcarPosicao(posicao, -1);
        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 0;
        posicao[1] = 1;
        service.TentarMarcarPosicao(posicao, 1);
        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 0;
        posicao[1] = 2;
        service.TentarMarcarPosicao(posicao, -1);
        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 1;
        posicao[1] = 0;
        service.TentarMarcarPosicao(posicao, 1);
        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 1;
        posicao[1] = 1;
        service.TentarMarcarPosicao(posicao, -1);
        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 1;
        posicao[1] = 2;
        service.TentarMarcarPosicao(posicao, 1);
        assertEquals(0, service.verificarTabuleiro());

        posicao[0] = 2;
        posicao[1] = 0;
        service.TentarMarcarPosicao(posicao, 1);
        assertEquals(0, service.verificarTabuleiro());

        posicao[0] = 2;
        posicao[1] = 1;
        service.TentarMarcarPosicao(posicao, -1);
        assertEquals(0, service.verificarTabuleiro());

        posicao[0] = 2;
        posicao[1] = 2;
        service.TentarMarcarPosicao(posicao, 1);
        assertEquals(0, service.verificarTabuleiro());
        service.exibeTabuleiro();

        assertTrue(service.tabuleiroCompleto());
    }


    @Test
    void tabuleiroIncompleto() {
        int[] posicao = new int[2];
        service.iniciarTabuleiro();
        assertTrue(service.tabuleiroZerado());
        posicao[0] = 0;
        posicao[1] = 0;
        service.TentarMarcarPosicao(posicao, -1);
        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 0;
        posicao[1] = 1;
        service.TentarMarcarPosicao(posicao, 1);
        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 0;
        posicao[1] = 2;
        service.TentarMarcarPosicao(posicao, -1);
        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 1;
        posicao[1] = 0;
        service.TentarMarcarPosicao(posicao, 1);
        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 1;
        posicao[1] = 1;
        service.TentarMarcarPosicao(posicao, -1);
        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 1;
        posicao[1] = 2;
        service.TentarMarcarPosicao(posicao, 1);
        assertEquals(0, service.verificarTabuleiro());
        posicao[0] = 2;
        posicao[1] = 0;
        service.TentarMarcarPosicao(posicao, 1);
        assertEquals(0, service.verificarTabuleiro());
        service.exibeTabuleiro();
        assertTrue(!service.tabuleiroCompleto());
    }
}
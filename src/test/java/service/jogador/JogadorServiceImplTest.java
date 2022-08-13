package service.jogador;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class JogadorServiceImplTest {
    @Spy
    @InjectMocks
    private JogadorServiceImpl jogadorService;
    private String nome = "Lucas";
    private int id = 1;

    @Test
    void verificarTentativaFalha() {
        jogadorService = new JogadorServiceImpl(nome, id);
        int[] tentativa = new int[2];
        tentativa[0] = 3;
        tentativa[1] = -1;
        assertTrue(!jogadorService.verificarTentativa(tentativa));
    }
    @Test
    void verificarTentativa() {
        jogadorService = new JogadorServiceImpl(nome, id);
        int[] tentativa = new int[2];
        tentativa[0] = 2;
        tentativa[1] = 1;
        assertTrue(jogadorService.verificarTentativa(tentativa));
    }

    @Test
    void qualONomeDoJogador() {
        jogadorService = new JogadorServiceImpl(nome, id);
        assertEquals("Lucas", jogadorService.QualONomeDoJogador());
    }

    @Test
    void getID() {
        jogadorService = new JogadorServiceImpl(nome, id);
        assertEquals(1, jogadorService.getID());
    }
}
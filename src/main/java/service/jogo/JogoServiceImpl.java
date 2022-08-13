package service.jogo;

import model.Jogador;
import service.jogador.JogadorInterface;
import service.jogador.JogadorServiceImpl;
import service.tabuleiro.TabuleiroServiceInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JogoServiceImpl implements JogoServiceInterface{
    private TabuleiroServiceInterface tabuleiroServiceInterface;
    public Scanner entrada = new Scanner(System.in);
    private List<JogadorInterface> jogadores = new ArrayList<>();


    public JogoServiceImpl(TabuleiroServiceInterface tabuleiroServiceInterface){
        this.tabuleiroServiceInterface = tabuleiroServiceInterface;


    }

    public void iniciarJogogadores() {
        System.out.println("Bem vindo ao Jogo da velha!");
        System.out.println("Jogador numero 1 digite o seu nome: ");
        this.jogadores.add( new JogadorServiceImpl(entrada.nextLine(), 1));
        System.out.println("Jogador numero 2 digite o seu nome: ");
        this.jogadores.add( new JogadorServiceImpl(entrada.nextLine(), 2));

    }

    @Override
    public void iniciarJogo() {
        iniciarJogogadores();
        int rodada = 1;
        boolean vez = true;
        Boolean jogo = true;
        int[] tentativa = new int[2];
        while (jogo){
            System.out.println("Rodada: " + rodada);
            System.out.println("---------------------- ");
            tabuleiroServiceInterface.exibeTabuleiro();
            if(vez){
                System.out.println("Sua vez: " + jogadores.get(0).QualONomeDoJogador()  );
                do {
                    buildTentavia(0,tentativa);
                }while ( !tabuleiroServiceInterface.TentarMarcarPosicao(tentativa,1));
                vez = !vez;
            }else {
                System.out.println("Sua vez: " + jogadores.get(1).QualONomeDoJogador()  );
                do{
                    buildTentavia(1,tentativa);
                }while (!tabuleiroServiceInterface.TentarMarcarPosicao(tentativa,-1));
                vez = !vez;
            }
            int resultado = tabuleiroServiceInterface.verificarTabuleiro();
           if(  resultado != 0){
               if (resultado == 1) {
                   System.out.println("Parabens " + this.jogadores.get(0).QualONomeDoJogador());
               } else {
                   System.out.println("Parabens " + this.jogadores.get(1).QualONomeDoJogador());
               }
               jogo = false;
           }
           if(tabuleiroServiceInterface.tabuleiroCompleto()){
               System.out.println("jogo empatado");
               jogo = false;
           }
           rodada++;
           System.out.println("--------------------------------");
        }

        tabuleiroServiceInterface.exibeTabuleiro();
    }

    private void  buildTentavia(int jogador,int[]  tentativa){
        do{
            System.out.println("Escolha uma linha entre 1 e 3");
            tentativa[0] = Integer. valueOf(entrada.nextLine()) - 1;
            System.out.println("Escolha uma coluna entre 1 e 3");
            tentativa[1] = Integer. valueOf(entrada.nextLine()) - 1;
        }while (!jogadores.get(jogador).verificarTentativa(tentativa));

    }
    public void mostrarJogadores(){
        this.jogadores.forEach(js -> System.out.println(js.QualONomeDoJogador()));
    }

}

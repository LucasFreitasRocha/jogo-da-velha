package service.tabuleiro;

import model.Tabuleiro;

public class TabuleiroServiceImpl implements TabuleiroServiceInterface {
    private Tabuleiro model;
    public TabuleiroServiceImpl(){
        this.model = new Tabuleiro();
    }
    @Override
    public void iniciarTabuleiro() {
        this.zerarTabuleiro();
    }

    @Override
    public Boolean TentarMarcarPosicao(int[] tentativa, int jogador) {
        int posicao = this.model.getTabuleiro()[tentativa[0]][tentativa[1]];
        if( posicao == 0){
            this.model.getTabuleiro()[tentativa[0]][tentativa[1]] = jogador;
            return true;
        }else{
            System.out.println("posicao já marcada, tente novamente");
            return  false;
        }
    }
    @Override
    public int verificarTabuleiro(){
        int auxI = 0 ;
        int auxJ = 0;
        int auxDiagonalPrincipal = 0;
        int auxDiagonalSecundaria = 0;
        int resultado = 0;
         for( int linha=0 ; linha<3 ; linha++) {
            for ( int coluna = 0; coluna < 3; coluna++){
                auxJ += this.model.getTabuleiro()[linha][coluna];
                auxI += this.model.getTabuleiro()[coluna][linha];
                if(linha == coluna)
                    auxDiagonalPrincipal += this.model.getTabuleiro()[linha][coluna];
                if(linha == (2-coluna))
                    auxDiagonalSecundaria += this.model.getTabuleiro()[linha][coluna];
            }

            if(auxJ == 0 ||  Math.abs(auxJ) < 3){
                auxJ = 0;
            }else{
                return getResultado3(auxJ);

            }

             if(auxI == 0 ||  Math.abs(auxI) < 3){
                 auxI = 0;
             }else{
                return getResultado3(auxI);

             }
            if(Math.abs(auxDiagonalPrincipal) == 3){
                 return getResultado3(auxDiagonalPrincipal);

             }
             if(Math.abs(auxDiagonalSecundaria) == 3){
               return  getResultado3(auxDiagonalSecundaria);

             }
        }

        return  resultado;
    }

    @Override
    public void exibeTabuleiro(){
        System.out.println();
        for(int linha=0 ; linha<3 ; linha++){

            for(int coluna=0 ; coluna<3 ; coluna++){
                if(this.model.getTabuleiro()[linha][coluna]==-1){
                    System.out.print(" X ");
                }
                if(this.model.getTabuleiro()[linha][coluna]==1){
                    System.out.print(" O ");
                }
                if(this.model.getTabuleiro()[linha][coluna]==0){
                    System.out.print("   ");
                }
                if(coluna==0 || coluna==1)
                    System.out.print("|");
            }
            System.out.println();
        }

    }

    private int getResultado3(int numero){
        if(numero > 0){
            return  1;
        }else{
            return  -1;
        }
    }

    private void zerarTabuleiro() {
         int[][] zerado= new int[3][3];
            for(int linha=0 ; linha<3 ; linha++)
                for(int coluna=0 ; coluna<3 ; coluna++)
                zerado[linha][coluna]=0;
         this.model.setTabuleiro(zerado);
    }

    @Override
    public boolean tabuleiroCompleto(){
        for(int linha=0 ; linha<3 ; linha++){
            for(int coluna=0 ; coluna<3 ; coluna++){
                if( this.model.getTabuleiro()[linha][coluna] == 0 ) return false;

            }
        }
        return true;
    }

    @Override
    public boolean tabuleiroZerado() {
        for(int linha=0 ; linha<3 ; linha++){
            for(int coluna=0 ; coluna<3 ; coluna++){
                if( this.model.getTabuleiro()[linha][coluna] != 0 ) return false;

            }
        }
        return true;
    }
}

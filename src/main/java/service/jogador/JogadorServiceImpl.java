package service.jogador;

import model.Jogador;


public class JogadorServiceImpl implements  JogadorInterface{
    private Jogador jogador;
    public JogadorServiceImpl(){}
    public JogadorServiceImpl(String nome, int id){
        this.jogador = new Jogador(nome,id);
    }

    @Override
    public Boolean verificarTentativa(int[] tentativa) {
        String resposta = "";
        if(tentativa[0] > 2 || tentativa[0] < 0) resposta += "linha deve  esta entre 1 e 3 \n";
        if(tentativa[1] > 2 || tentativa[1] < 0) resposta += "coluna deve esta entre 1 e 3 \n";
        if(resposta.isEmpty()){
            return true;
        }else {
            System.out.println(resposta);
            System.out.println("Tente novamente");
            return false;
        }
    }

    public String QualONomeDoJogador(){
        return this.jogador.getNome();
    }

    public int getID(){
        return this.jogador.getId();
    }
}

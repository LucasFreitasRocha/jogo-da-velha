package model;

import java.util.UUID;

public class Tabuleiro {
    private int[][] tabuleiro= new int[3][3];
    private String id;

    public void  Tabuleiro(){
        id = UUID.randomUUID().toString();
    }

    public int[][] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(int[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }


}

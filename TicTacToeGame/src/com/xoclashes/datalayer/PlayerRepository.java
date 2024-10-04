package com.xoclashes.datalayer;

public class PlayerRepository {
    private String player1;
    private String player2;
    private char player1Symbol;
    private char player2Symbol;

    public void setPlayers(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.player1Symbol = 'X';
        this.player2Symbol = 'O';
    }

    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public char getPlayer1Symbol() {
        return player1Symbol;
    }

    public char getPlayer2Symbol() {
        return player2Symbol;
    }
}

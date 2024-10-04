package com.xoclashes.screens.player;

import com.xoclashes.datalayer.PlayerRepository;

public class PlayerViewModel {
    private final PlayerRepository playerRepository;
    private char currentSymbol = 'X';  // Player 1 starts

    public PlayerViewModel() {
        this.playerRepository = new PlayerRepository();
    }

    // Set the players
    public void setPlayers(String player1, String player2) {
        playerRepository.setPlayers(player1, player2);
    }

    // Get the name of the current player
    public String getCurrentPlayer() {
        return (currentSymbol == 'X') ? playerRepository.getPlayer1() : playerRepository.getPlayer2();
    }

    // Get the current player's symbol
    public char getCurrentSymbol() {
        return currentSymbol;
    }

    // Switch to the next player
    public void switchPlayer() {
        currentSymbol = (currentSymbol == 'X') ? 'O' : 'X';
    }
}

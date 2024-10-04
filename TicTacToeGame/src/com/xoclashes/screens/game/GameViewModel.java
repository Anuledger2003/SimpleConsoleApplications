package com.xoclashes.screens.game;

import com.xoclashes.datalayer.PlayerRepository;
import com.xoclashes.datalayer.GameRepository;

public class GameViewModel {
    private final PlayerRepository playerRepository;
    private final GameRepository gameRepository;
    private boolean isGameOver;
    private boolean isPlayer1Turn;

    public GameViewModel(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
        this.gameRepository = new GameRepository();
        this.isGameOver = false;
        this.isPlayer1Turn = true; // Player 1 starts
    }

    public void displayBoard() {
        for (char[] row : gameRepository.getBoard()) {
            for (char cell : row) {
                System.out.print((cell == '_' ? "_" : cell) + " ");
            }
            System.out.println();
        }
    }

    public void setMove(int row, int col) {
        char currentSymbol = getCurrentSymbol();
        gameRepository.setMove(row, col, currentSymbol);

        if (checkWin(row, col)) {
            isGameOver = true;
        } else if (gameRepository.isBoardFull()) {
            isGameOver = true; // Game over if board is full
        }
    }

    public boolean isCellEmpty(int row, int col) {
        return gameRepository.isCellEmpty(row, col);
    }

    public void switchPlayer() {
        isPlayer1Turn = !isPlayer1Turn;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public String getCurrentPlayer() {
        return isPlayer1Turn ? playerRepository.getPlayer1() : playerRepository.getPlayer2();
    }

    public char getCurrentSymbol() {
        return isPlayer1Turn ? playerRepository.getPlayer1Symbol() : playerRepository.getPlayer2Symbol();
    }

    private boolean checkWin(int row, int col) {
        char currentSymbol = gameRepository.getBoard()[row][col];

        // Check row
        if (gameRepository.getBoard()[row][0] == currentSymbol && gameRepository.getBoard()[row][1] == currentSymbol && gameRepository.getBoard()[row][2] == currentSymbol) {
            return true;
        }

        // Check column
        if (gameRepository.getBoard()[0][col] == currentSymbol && gameRepository.getBoard()[1][col] == currentSymbol && gameRepository.getBoard()[2][col] == currentSymbol) {
            return true;
        }

        // Check diagonals
        if (row == col) { // Primary diagonal
            if (gameRepository.getBoard()[0][0] == currentSymbol && gameRepository.getBoard()[1][1] == currentSymbol && gameRepository.getBoard()[2][2] == currentSymbol) {
                return true;
            }
        }
        if (row + col == 2) { // Secondary diagonal
            if (gameRepository.getBoard()[0][2] == currentSymbol && gameRepository.getBoard()[1][1] == currentSymbol && gameRepository.getBoard()[2][0] == currentSymbol) {
                return true;
            }
        }

        return false;
    }

    public void displayResult() {
        if (isGameOver) {
            String winner = isPlayer1Turn ? playerRepository.getPlayer1() : playerRepository.getPlayer2();
            System.out.println("Congratulations, " + winner + " wins!");
        } else {
            System.out.println("The game is a draw!");
        }
    }
}

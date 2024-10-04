package com.xoclashes.datalayer;

public class GameRepository {
    private final char[][] board = new char[3][3];

    public GameRepository() {
        // Initialize the board with empty spaces
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '_';
            }
        }
    }

    // Current Game board
    public char[][] getBoard() {
        return board;
    }

    // Checks if a cell is empty
    public boolean isCellEmpty(int row, int col) {
        return board[row][col] == '_';
    }

    // Sets a move at the given row and column
    public void setMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // Checks if the board is full
    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '_') {
                    return false;
                }
            }
        }
        return true;
    }
}

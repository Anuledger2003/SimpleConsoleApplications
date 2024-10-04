package com.xoclashes.dto;

public class GameState {
    private final char[][] board;

    public GameState(char[][] board) {
        this.board = board;
    }

    public char[][] getBoard() {
        return board;
    }
}

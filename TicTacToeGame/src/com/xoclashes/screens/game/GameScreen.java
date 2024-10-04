package com.xoclashes.screens.game;

import com.xoclashes.BaseScreen;

import java.util.Scanner;

public class GameScreen extends BaseScreen {
    private final GameViewModel gameViewModel;
    private final Scanner scanner;

    public GameScreen(GameViewModel gameViewModel) {
        this.gameViewModel = gameViewModel;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void display() {
        // Main Game 
        while (!gameViewModel.isGameOver()) {
            gameViewModel.displayBoard();
            System.out.print(gameViewModel.getCurrentPlayer() + " (" + gameViewModel.getCurrentSymbol() + "), enter your move (row and column): ");
            
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            // Input validation for the move
            if (isValidMove(row, col)) {
                if (gameViewModel.isCellEmpty(row, col)) {
                    gameViewModel.setMove(row, col);
                    if (!gameViewModel.isGameOver()) {
                        gameViewModel.switchPlayer(); // Switch to the next player
                    }
                } else {
                    System.out.println("Invalid move! Cell is already occupied. Try again.");
                }
            } else {
                System.out.println("Invalid input! Please enter row and column values between 0 and 2.");
            }
        }

        gameViewModel.displayResult();
    }

    // Method to validate move input
    private boolean isValidMove(int row, int col) {
        return row >= 0 && row <= 2 && col >= 0 && col <= 2;
    }

    public void startGame() {
        display();
    }
}

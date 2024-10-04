package com.xoclashes.screens.player;

import java.util.Scanner;
import com.xoclashes.BaseScreen;
import com.xoclashes.datalayer.PlayerRepository;

public class PlayerScreen extends BaseScreen {
    private final PlayerRepository playerRepository;
    private final Scanner scanner = new Scanner(System.in);

    public PlayerScreen(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public void display() {
        initializePlayers();
    }

    public void initializePlayers() {
        System.out.print("Enter Player 1's name (X): ");
        String player1 = scanner.nextLine();
        System.out.print("Enter Player 2's name (O): ");
        String player2 = scanner.nextLine();
        playerRepository.setPlayers(player1, player2);
    }
}

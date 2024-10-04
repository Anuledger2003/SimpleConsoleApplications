package com.xoclashes;

import com.xoclashes.datalayer.PlayerRepository;
import com.xoclashes.screens.game.GameViewModel;
import com.xoclashes.screens.game.GameScreen;
import com.xoclashes.screens.player.PlayerScreen;

public class XOClashes {
    public static void main(String[] args) {
        PlayerRepository playerRepository = new PlayerRepository();
        PlayerScreen playerScreen = new PlayerScreen(playerRepository);
        playerScreen.display(); //player names

        GameViewModel gameViewModel = new GameViewModel(playerRepository);
        GameScreen gameScreen = new GameScreen(gameViewModel);
        gameScreen.startGame(); // Game Started
    }
}

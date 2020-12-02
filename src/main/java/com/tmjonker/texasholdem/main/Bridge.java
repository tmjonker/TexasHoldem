package com.tmjonker.texasholdem.main;

import com.tmjonker.texasholdem.gamecontroller.GameController;
import javafx.application.Application;
import javafx.stage.Stage;


public class Bridge extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {

        GameController gameController = new GameController();
        gameController.startGame();
    }
}

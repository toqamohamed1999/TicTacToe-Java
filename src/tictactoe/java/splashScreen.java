package tictactoe.java;

import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class splashScreen extends AnchorPane {

    public splashScreen(Stage stage) {

        setId("SplashScreenAnchorPane");
        setPrefHeight(430.0);
        setPrefWidth(600.0);
        getStylesheets().add("/tictactoe/java/Styles.css");
        navigateToHome(stage);

    }

    private void navigateToHome(Stage stage) {

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    TicTacToeJava.stage.setScene(new Scene(new HomeScreen()));
                    timer.cancel();
                });
            }
        }, 2000, 2000);
    }

}

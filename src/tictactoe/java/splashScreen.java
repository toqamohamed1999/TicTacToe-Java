package tictactoe.java;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class splashScreen extends AnchorPane {

    public splashScreen() {

        setId("SplashScreenAnchorPane");
        setPrefHeight(430.0);
        setPrefWidth(600.0);
        getStylesheets().add("/tictactoe/java/Styles.css");
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
          
             Parent root=null;
                root = new SignInScreen();
                Scene scene = new Scene(root);
                Stage stage = (Stage) getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
        });

    }
}

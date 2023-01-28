
package tictactoe.java;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TicTacToeJava extends Application {

    public static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = new splashScreen(stage);
        Scene scene = new Scene(root);
        this.stage = stage;
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.resizableProperty().setValue(false);
        stage.show();
    }

   
    public static void main(String[] args) {
        launch(args);
        new TicTacToeJava();

    }
}

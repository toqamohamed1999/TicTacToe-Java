/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.java;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TicTacToeJava extends Application {
 public static Scene scene1;
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = new splashScreen(stage);
        Scene scene = new Scene(root);
        scene1=scene;
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.resizableProperty().setValue(false);  
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args); 
        new TicTacToeJava();
       
    }  
}

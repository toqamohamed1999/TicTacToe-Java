/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.java;

import java.awt.Dimension;
import java.awt.Toolkit;
import javafx.application.Application;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.transform.Scale;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class TicTacToeJava extends Application {

    @Override
    public void start(Stage stage) throws Exception {
 
        Parent root = new DisplayRecordScreen();

        
        Scene scene = new Scene(root);
        stage.centerOnScreen();

        stage.setScene(scene);
        stage.show();
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);  
       
    }

}

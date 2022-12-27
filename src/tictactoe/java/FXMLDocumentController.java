/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.java;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    class ShowSplashScreen extends Thread{
        @Override
        public void run(){
            try {
                Thread.sleep(5000);
                
                Platform.runLater(() -> {
                    Stage stage = new Stage();
                    Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    label.getScene().getWindow().hide();
                });                
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        new ShowSplashScreen().start();
    }    
    
}

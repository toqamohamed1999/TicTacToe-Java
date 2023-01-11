/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.IOException;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import tictactoe.java.HomeScreen;
import tictactoe.java.OnlineListScreen;
import tictactoe.java.ProfileScreen;
import tictactoe.java.SignUpScreenBase;

public class Profile {

    public ClientSide clientSide;
    public OnlineListScreen onlineListScreen;

    public Profile() {
        clientSide = ClientSide.getInstanse();
        onlineListScreen = new OnlineListScreen();
        
    }

    public void viewProfile() {

    }

    public final void profilePic() {

        onlineListScreen.profilePic.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                receiveMessgeFromServer();
                Platform.runLater(() -> {
                    Parent root = null;
                    root = new ProfileScreen();
                    Scene scene = new Scene(root);
                    Stage stage = (Stage) onlineListScreen.profilePic.getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                });

            }
        });

    }

    void moveProfileScreen() {

    }

    void receiveMessgeFromServer() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        if (clientSide.dis != null) {
                            String textmessage = clientSide.dis.readLine();
                            System.out.println("@@@@@@@@@@" + textmessage);
                          String [] op = textmessage.split(",");
                            System.out.println("2222222"+op[2]);
                            clientSide.ps.flush();
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }).start();
    }

}

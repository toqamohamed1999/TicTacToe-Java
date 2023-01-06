/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tictactoe.java.OnlineListScreen;
import tictactoe.java.SignUpScreenBase;

/**
 *
 * @author Eman
 */
public class SignUp {
    
    Client client ;
    public SignUpScreenBase signUpScreenBase ;
    ClientSide clientSide;
    String email ;
    String userName; 
    String password;
    String gender; 

    public SignUp() {
        signUpScreenBase = new SignUpScreenBase();
        clientSide= new ClientSide();
        signUp();
        signUpButton();
    }
    
    
    public void signUp(){
     email  = signUpScreenBase. EmailTextField.getText();
     userName = signUpScreenBase.userNameTextField.getText();
     password = signUpScreenBase.passwordTextField.getText();
    }
    
    public void signUpButton(){
    
    signUpScreenBase.signUpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              clientSide.setTextmessage(userName);
              clientSide. sendToServer(userName);
              System.out.println("$$$$$$$$$$$$$$$$$$");
            }
        });
    
    }
    
}

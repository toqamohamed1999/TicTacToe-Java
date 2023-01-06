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

    public Client client;
    public SignUpScreenBase signUpScreenBase;
    public ClientSide clientSide;

    String userName;
    String password;
    String confirmPassword;
    String email;

    public SignUp() {
        signUpScreenBase = new SignUpScreenBase();
        clientSide = new ClientSide();
        signUpButton();
    }

    public String[] signUpTextFields() {
        userName = signUpScreenBase.userNameTextField.getText();
        password = signUpScreenBase.passwordTextField.getText();
        confirmPassword = signUpScreenBase.confirmTextField.getText();
        email = signUpScreenBase.emailTextField.getText();
        String gender = "";
        if (signUpScreenBase.maleRadioButton.isSelected()) {
            gender = signUpScreenBase.maleRadioButton.getText();
        }
        if (signUpScreenBase.femaleRadioButton.isSelected()) {
            gender = signUpScreenBase.femaleRadioButton.getText();
        }

        String[] data = {userName, password, confirmPassword, email, gender};
        return data;
    }

    public final void signUpButton() {

        signUpScreenBase.signUpButton.setOnAction((ActionEvent event) -> {
            clientSide.ps.println("I clicked signup");
            if (signUpTextFields() != null) {
                String[] signUpData = signUpTextFields();
                for (int i = 0; i < signUpData.length; i++) {
                    clientSide.ps.println(signUpData[i]);
                }
            }
        });

    }
}

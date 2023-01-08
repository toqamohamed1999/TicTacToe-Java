package logic;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tictactoe.java.OnlineListScreen;
import tictactoe.java.SignUpScreenBase;

public class SignUp {

    public SignUpScreenBase signUpScreenBase;
    public ClientSide clientSide;

    String userName;
    String password;
    String confirmPassword;
    String email;
    String gender;

    public SignUp() {
        signUpScreenBase = new SignUpScreenBase();
        clientSide = ClientSide.getInstanse();
        signUpButton();
        receiveMessgeFromServer();
    }

    public String[] signUpTextFields() {
        userName = signUpScreenBase.userNameTextField.getText();
        password = signUpScreenBase.passwordTextField.getText();
        confirmPassword = signUpScreenBase.confirmTextField.getText();
        email = signUpScreenBase.emailTextField.getText();
        gender = "";
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

    void receiveMessgeFromServer() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        if (clientSide.dis != null) {
                            String textmessage = clientSide.dis.readLine();
                            System.out.println(textmessage);
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

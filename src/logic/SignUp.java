package logic;

import java.io.IOException;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import javafx.application.Platform;

import tictactoe.java.SignUpScreenBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import tictactoe.java.TicTacToeJava;

public class SignUp {

    public SignUpScreenBase signUpScreenBase;
    static SignUp signUp;
    static String profileDataArr = null;
    String userName;
    String password;
    String confirmPassword;
    String email;
    String gender;
    ActionEvent actionEvent;
    String ip = null;

    public SignUp() {
        signUpScreenBase = new SignUpScreenBase();
        signUp = this;
        try {
            ip = Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
        signUpButton();
    }

    public final void signUpButton() {

        signUpScreenBase.signUpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // clientSide.ps.println("I clicked signup");
                userName = signUpScreenBase.userNameTextField.getText();
                password = signUpScreenBase.passwordTextField.getText();
                confirmPassword = signUpScreenBase.confirmTextField.getText();
                email = signUpScreenBase.emailTextField.getText();
                gender = signUpScreenBase.getGender(actionEvent);
                boolean isValiad = signUpScreenBase.validEmail(email);

                if (isValiad || confirmPassword.equals(password) || userName != null || gender == "Not Selected") {

                    String data = "SignUp" + "," + ip + "," + userName + "," + email + "," + password + "," + gender;
                    ClientSide.ps.println(data);
                }

            }
        });
    }

    void doAction(String textmessage) {

        if (textmessage.equalsIgnoreCase("signUpVerified")) {
            moveToOnlineListScreen();
        } else if (textmessage.equalsIgnoreCase("signUpNotVerified")) {
            showDialog();
        }

    }

    void moveToOnlineListScreen() {
        Platform.runLater(() -> {
            OnlineList onlineList = new OnlineList(email);
            TicTacToeJava.stage.setScene(new Scene(onlineList.onlineListScreen));
        });
    }

    void showDialog() {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("SignUp incorrect");
            alert.setContentText("You already have an account!");
            alert.show();

        });
    }
}

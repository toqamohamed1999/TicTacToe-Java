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
                boolean isValiadEmail = signUpScreenBase.validEmail(email);
                boolean isVaildPassword = signUpScreenBase.validPassword(password);

                if (userName.isEmpty()) {
                    showDialog("Enter userName ");
                } else if (isVaildPassword == false) {
                    showDialog("Password should contains special charachters,numbers and capital charachters ");
                } else if (!confirmPassword.equals(password)) {
                    showDialog("your password not matches");
                } else if (isValiadEmail == false) {
                    showDialog("Enter a vaild Email");
                } else if (gender.equals("Not Selected")) {
                    showDialog("Select your gender");
                } else {
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
            showDialog("You already have an account");
        }

    }

    void moveToOnlineListScreen() {
        Platform.runLater(() -> {
            Parent root = null;
            OnlineList onlineList = new OnlineList(email);
            root = onlineList.onlineListScreen;
            Scene scene = new Scene(root);
            Stage stage = (Stage) signUpScreenBase.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        });
    }

    void showDialog(String msg) {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("SignUp incorrect");
            alert.setContentText(msg);
            alert.show();
        });
    }

}

package logic;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public ClientSide clientSide;

    String userName;
    String password;
    String confirmPassword;
    String email;
    String gender;
    ActionEvent actionEvent;

    public SignUp() {
        signUpScreenBase = new SignUpScreenBase();
        clientSide = ClientSide.getInstanse();
        signUpButton();
        receiveMessgeFromServer();
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

                    try {
                        String ip = Inet4Address.getLocalHost().getHostAddress();
                        String data = "SignUp" + "," + ip + "," + userName + "," + email + "," + password + "," + gender;
                        clientSide.ps.println(data);
                        //  System.out.println("Your Data" + data);
                    } catch (UnknownHostException ex) {
                        Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                /* if(clientSide.dis == null){
                    showDialog();
                }*/

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
            Parent root = null;
            OnlineList onlineList = new OnlineList();
            root = onlineList.onlineListScreen;
            Scene scene = new Scene(root);
            Stage stage = (Stage) signUpScreenBase.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
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

    void receiveMessgeFromServer() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        if (clientSide.dis != null) {
                            String textmessage = clientSide.dis.readLine();
                            System.out.println("@@@@@@@@@@" + textmessage);
                            doAction(textmessage);
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

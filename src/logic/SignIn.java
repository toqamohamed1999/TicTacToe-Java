package logic;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import tictactoe.java.OnlineListScreen;
import tictactoe.java.SignInScreenBase;

public class SignIn {

    public SignInScreenBase signInScreenBase;
    public ClientSide clientSide;

    String email;
    String password;
    String data = null;

    public SignIn() {
        signInScreenBase = new SignInScreenBase();
        clientSide = ClientSide.getInstanse();
        signInBtn();
        receiveMessgeFromServer();
    }

    String getFields() {

        email = signInScreenBase.emailTextField.getText() + "";
        password = signInScreenBase.passwordTextField.getText() + "";
        if (!email.isEmpty() && !password.isEmpty()) {
            try {

               String ip = Inet4Address.getLocalHost().getHostAddress();

                data = "signIn," + ip + "," + email + "," + password;
            } catch (UnknownHostException ex) {
                Logger.getLogger(SignIn.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return data;
    }

    void signInBtn() {
        signInScreenBase.signInButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                getFields();
                if (data != null) {
                    clientSide.ps.println(data);
                } else {
                    showDialog();
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

    void doAction(String textmessage) {

        if (textmessage.equalsIgnoreCase("signInVerified")) {
            moveToOnlineListScreen();
        } else if (textmessage.equalsIgnoreCase("signInNotVerified")) {
            showDialog();
        }

    }

    void moveToOnlineListScreen() {
        Platform.runLater(() -> {
            Parent root = null;
            OnlineList onlineList = new OnlineList();
            root = onlineList.onlineListScreen;
            Scene scene = new Scene(root);
            Stage stage = (Stage) signInScreenBase.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        });
    }

    void showDialog() {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("SignIn incorrect");
            alert.setContentText("Make sure that, your email and password are empty or correct!");
            alert.show();

        });
    }
}

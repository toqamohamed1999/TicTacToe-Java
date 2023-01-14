package logic;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import tictactoe.java.SignInScreenBase;
import tictactoe.java.TicTacToeJava;

public class SignIn {

    public SignInScreenBase signInScreenBase;
    static String profileDataArr = null;
    static ClientSide clientSide = ClientSide.getInstanse();
    Thread thread;

    static SignIn signIn;

    String email;
    String password;
    String data = null;
    String ip = null;

    public SignIn() {
        thread = new Thread(clientSide);
        thread.start();

        signInScreenBase = new SignInScreenBase();
        clientSide = ClientSide.getInstanse();
        signIn = this;

        try {
            ip = Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }

        signInBtn();
    }

    String getFields() {

        email = signInScreenBase.emailTextField.getText() + "";
        password = signInScreenBase.passwordTextField.getText() + "";
        if (!email.isEmpty() && !password.isEmpty()) {

            System.out.println("ip = " + ip);
            data = "signIn," + ip + "," + email + "," + password;
        }
        return data;
    }

    void signInBtn() {
        signInScreenBase.signInButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                getFields();
                if (data != null) {
                    ClientSide.ps.println(data);
                } else {
                    showDialog();
                }
            }
        });
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
            OnlineList onlineList = new OnlineList(email);
            TicTacToeJava.stage.setScene(new Scene(onlineList.onlineListScreen));
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

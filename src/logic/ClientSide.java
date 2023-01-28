
package logic;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import static logic.SignIn.profileDataArr;
import tictactoe.java.HomeScreen;
import tictactoe.java.TicTacToeJava;

public class ClientSide implements Runnable {

    private static ClientSide clientSide;
    Socket clientSocket;
    DataInputStream dis;
    public static PrintStream ps;
    String textmessage = "";

    private ClientSide() {

        try {
            clientSocket = new Socket(InetAddress.getLocalHost(), 5005);
            dis = new DataInputStream(clientSocket.getInputStream());
            ps = new PrintStream(clientSocket.getOutputStream());
        } catch (Exception ex) {
            Platform.runLater(() -> {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Server is down!");
                alert.setContentText("The Server is down, Please try again later.");
                alert.show();
                clientSide = null;
                TicTacToeJava.stage.setScene(new Scene(new HomeScreen()));
            });
        }

    }

    public static ClientSide getInstanse() {
        if (clientSide == null) {
            clientSide = new ClientSide();
        }
        return clientSide;
    }

    @Override
    public void run() {
        try {
            while (true) {

                if (dis != null) {
                    String textmessage = dis.readLine();
                    System.out.println("message from server: "+textmessage);
                    Platform.setImplicitExit(false);
                    Platform.runLater(() -> {
                        handleAction(textmessage);
                    });
                    if (textmessage.contains("profileData")) {
                        profileDataArr = textmessage;
                    }
                    ps.flush();
                }

            }
        } catch (IOException ex) {
            Platform.runLater(() -> {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Server is down!");
                alert.setContentText("The Server is down, Please try again later.");
                alert.show();
                clientSide = null;
                TicTacToeJava.stage.setScene(new Scene(new HomeScreen()));
            });
        } 
    }

    void handleAction(String msg) {
        if (msg.endsWith("signInVerified") || msg.equals("signInNotVerified")) {
            SignIn.signIn.doAction(msg);
        } else if (msg.endsWith("signUpVerified") || msg.equals("signUpNotVerified")) {
            SignUp.signUp.doAction(msg);
        } else if (msg.contains("sendAllUsers") || msg.contains("recieveRequest")
                || msg.contains("confirmRequest") || msg.contains("getPlayersData")) {
            OnlineList.onlineList.receiveOnlineList(msg);
        } else if (msg.contains("game")) {
            OnlineGame.onlineGame.doAction(msg);
        }
    }

}

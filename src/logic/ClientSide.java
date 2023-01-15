/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import static logic.SignIn.profileDataArr;
import tictactoe.java.SignUpScreenBase;

public class ClientSide implements Runnable {

    private static ClientSide clientSide = new ClientSide();
    Socket clientSocket;
    DataInputStream dis;
    public static PrintStream ps;
    String textmessage = "";
    // Thread thread;

    private ClientSide() {
        //     thread = new Thread(this);
        //     thread.start();

        try {
            clientSocket = new Socket(InetAddress.getLocalHost(), 5005);
            dis = new DataInputStream(clientSocket.getInputStream());
            ps = new PrintStream(clientSocket.getOutputStream());
        } catch (SocketException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static ClientSide getInstanse() {
        return clientSide;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (dis != null) {
                    String textmessage = dis.readLine();
                    System.out.println("@@@@@@@@@@@" + textmessage);
                    Platform.setImplicitExit(false);
                    Platform.runLater(() -> {
                        handleAction(textmessage);
                    });
                    if (textmessage.contains("profileData")) {
                        profileDataArr = textmessage;
                    }
                    ps.flush();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    void handleAction(String msg) {
        if (msg.endsWith("signInVerified") || msg.equals("signInNotVerified")) {
            SignIn.signIn.doAction(msg);
        } else if (msg.endsWith("signUpVerified") || msg.equals("signUpNotVerified")) {
            SignUp.signUp.doAction(msg);
        } else if (msg.contains("sendAllUsers") || msg.contains("recieveRequest")
                || msg.contains("confirmRequest")||msg.contains("getPlayersData")) {
            OnlineList.onlineList.receiveOnlineList(msg);
        } else if (msg.contains("game")) {

            OnlineGame.onlineGame.doAction(msg);

        }

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Eman
 */
public class ClientSide implements Runnable {

    Socket clientSocket;
    DataInputStream dis;
    PrintStream ps;
    String textmessage = "";
    Thread thread;

    public void setTextmessage(String textmessage) {
        this.textmessage = textmessage;
    }

    public ClientSide() {
        thread = new Thread(this);
        thread.start();
 

        try {
            clientSocket = new Socket(InetAddress.getLocalHost(), 5005);
            // System.out.println("my ip"+InetAddress.getLocalHost());
            dis = new DataInputStream(clientSocket.getInputStream());
            ps = new PrintStream(clientSocket.getOutputStream());
            //ReceiveMessage r = new ReceiveMessage();

        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }

        sendToServer(textmessage);

        /* mySendButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                //ps.println("I clicked send");
                // String replayMsg = dis.readLine();
                // System.out.println("server say "+replayMsg);
                if (myTextField.getText() != null) {
                    String clientMsg = myTextField.getText();
                    // System.out.println("clientMsg"+clientMsg);
                    ps.println(clientMsg);
                }

                //  String replayMsg = dis.readLine();
            }
        });*/
    }

    @Override
    public void run() {

        /* while (true) {
            try {
                textmessage = dis.readLine();
                //ps.flush(); 
                myTextArea.appendText(textmessage.toString() + " \n");
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
            }

        }*/
    }

    public void sendToServer(String message) {

        if (message != null) {

            ps.println(message);
            System.out.println(message);
        }

    }

}

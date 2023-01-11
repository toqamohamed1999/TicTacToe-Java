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


/**
 *
 * @author Eman
 */
public class ClientSide implements Runnable {

    private static ClientSide clientSide;
    Socket clientSocket;
    DataInputStream dis;
    PrintStream ps;
    String textmessage = "";
    Thread thread;
    

    private ClientSide() {
        thread = new Thread(this);
        thread.start();

        try {
            clientSocket = new Socket(InetAddress.getLocalHost(), 5005);
            dis = new DataInputStream(clientSocket.getInputStream());
            ps = new PrintStream(clientSocket.getOutputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static ClientSide getInstanse() {
        if (clientSide == null) {
            return new ClientSide();
        }
        return clientSide;
    }
    

    @Override
    public void run() {
        /*      while (true) {
            try {
                if (dis != null && textmessage != null) {
                    textmessage = dis.readLine();
                    System.out.println("$$$$$$$$$$$$$$$$$$$$$recived message2");
                    System.out.println(textmessage);
                    // ps.flush();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }*/
    }

}

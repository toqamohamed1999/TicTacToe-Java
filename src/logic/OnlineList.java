package logic;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import tictactoe.java.GameBoard;
import tictactoe.java.OnlineListScreen;
import tictactoe.java.SignInScreenBase;

public class OnlineList {
    
    public OnlineListScreen onlineListScreen;
    public ClientSide clientSide;
    public ListView listView;
    
    String[] operationArr;
    ArrayList<String> items = new ArrayList();
    ArrayList<User> usersList = new ArrayList();
    String data = null;
    
    public OnlineList() {
        onlineListScreen = new OnlineListScreen();
        clientSide = ClientSide.getInstanse();
        listView = onlineListScreen.onlineListView;
        receiveMessgeFromServer();
        getAllOnlineUsers();
        onItemClick();
    }
    int secondPlayerindex = -1;
    String secondPlayerIp = "";
    void onItemClick() {
        listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String item = (String) listView.getSelectionModel().getSelectedItem();
                System.out.println("clicked on lsitview = " + item);
                secondPlayerindex = listView.getSelectionModel().getSelectedIndex();
                sendRequest();
                // moveToGameBoardScreen();
            }
        });
    }
    
    void sendRequest() {
        try {
            String ip = Inet4Address.getLocalHost().getHostAddress();
            secondPlayerIp =usersList.get(secondPlayerindex).getIP();
            System.out.println("seconddddddddddd = "+secondPlayerIp);
            clientSide.ps.println("sendRequest," + ip + "," + secondPlayerIp);
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
    }
    
    void recieveRequest() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("message");
        alert.setContentText("Player " + operationArr[1] + " want to play with you");
        alert.show();
    }
    
    void getAllOnlineUsers() {
        data = "getOnlineUsers";
        clientSide.ps.println(data);
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
                            divideMessage(textmessage);
                            doAction();
                            clientSide.ps.flush();
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }).start();
    }
    
    public void divideMessage(String operation) {
        operationArr = operation.split(",");
    }
    
    void doAction() {
        System.out.println(Arrays.toString(operationArr));
        if (operationArr[0].equalsIgnoreCase("sendAllUsers")) {
            items.add(operationArr[2]);
            additemToList();
            
            ObservableList<String> obsItems = FXCollections.observableArrayList(items);
            listView.setItems(obsItems);
        } else if (operationArr[0].equals("recieveRequest")) {
            System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy "+Arrays.toString(operationArr));
            recieveRequest();
        }
        
    }
    
    void additemToList() {
        User user = new User();
        user.setIP(operationArr[1]);
        user.setUserName(operationArr[2]);
        user.setEmail(operationArr[3]);
        usersList.add(user);        
    }
    
    void moveToGameBoardScreen() {
        Platform.runLater(() -> {
            Parent root;
            root = new GameBoard("A", 1, "A", 2);
            Scene scene = new Scene(root);
            Stage stage = (Stage) listView.getScene().getWindow();
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
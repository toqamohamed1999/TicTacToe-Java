package logic;

import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import tictactoe.java.MultipleUserXOScreenBase;
import tictactoe.java.OnlineListScreen;
import tictactoe.java.SignInScreenBase;

public class OnlineList {

    public OnlineListScreen onlineListScreen;
    public ClientSide clientSide;
    public ListView listView;

    String[] operationArr;
    String data = null;

    public OnlineList() {
        onlineListScreen = new OnlineListScreen();
        clientSide = ClientSide.getInstanse();
        listView = onlineListScreen.onlineListView;
        receiveMessgeFromServer();
        getAllOnlineUsers();
    }

    void getFields() {

        listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("clicked on lsitview = "
                        + listView.getSelectionModel().getSelectedItem());

            }
        });
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
                            clientSide.ps.flush();
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public String[] divideMessage(String operation) {
        operationArr = operation.split(",");
        return operationArr;
    }

    void doAction(String textmessage) {

        if (textmessage.equalsIgnoreCase("sendAllUsers")) {
            listView.getItems().add("User " + operationArr[1]);
        }

    }

    void moveToOnlineListScreen() {
        Platform.runLater(() -> {
            Parent root;
            root = new MultipleUserXOScreenBase("A", 1, "A", 2);
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

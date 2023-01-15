package logic;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import tictactoe.java.OnlineListScreen;
import tictactoe.java.ProfileScreen;
import tictactoe.java.TicTacToeJava;

public class OnlineList {

    public OnlineListScreen onlineListScreen;
    public static OnlineList onlineList;
    public ListView listView;

    String[] operationArr;
    ArrayList<String> usersName = new ArrayList();
    ArrayList<User> usersList = new ArrayList();
    String data = null;
    String email = null;
    String ip = null;

    public OnlineList(String email) {
        onlineListScreen = new OnlineListScreen();
        onlineList = this;
        listView = onlineListScreen.onlineListView;
        this.email = email;
        try {
            ip = Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
        getAllOnlineUsers();
        onItemClick();
        onProfileClick();
        setRefresh();
    }
    int secondPlayerIndex = -1;
    String secondPlayerIp = "";

    private void onItemClick() {
        listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String item = (String) listView.getSelectionModel().getSelectedItem();
                secondPlayerIndex = listView.getSelectionModel().getSelectedIndex();
                sendRequest();
            }
        });
    }

    void sendRequest() {
        secondPlayerIp = usersList.get(secondPlayerIndex).getIP();
        ClientSide.ps.println("sendRequest," + ip + "," + secondPlayerIp);
    }

    void recieveRequest() {
        Platform.runLater(() -> {
            showRecieveDialog(operationArr[1], operationArr[2]);
        });
    }
    Optional<ButtonType> result;

    void showRecieveDialog(String myIp, String secondIp) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Test");
        alert.setHeaderText("Tic Tac Toe");
        alert.setResizable(false);
        alert.setContentText("Player " + operationArr[1] + " want to play with you");

        Optional<ButtonType> result = alert.showAndWait();
        ButtonType button = result.orElse(ButtonType.CANCEL);

        if (button == ButtonType.OK) {
            ClientSide.ps.println("confirmRequestfromSecondPlayer," + myIp + "," + secondIp);
            System.out.println("ssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
            moveToGameBoardScreen();
        } else {
            alert.close();
        }

    }

    private void getAllOnlineUsers() {
        data = "getOnlineUsers," + ip;
        ClientSide.ps.println(data);
    }
    String profileStr = null;

    void receiveOnlineList(String msg) {
        divideMessage(msg);
        doAction();
    }

    public void divideMessage(String operation) {
        operationArr = operation.split(",");
    }

    void doAction() {
        if (operationArr[0].equalsIgnoreCase("sendAllUsers")) {
            String userIp = operationArr[1];
            String userName = operationArr[2];
            //          if (!userIp.equals(ip)) {
            usersName.add(userName);
            //           }
            addUserToList();

            ObservableList<String> obsItems = FXCollections.observableArrayList(usersName);
            listView.setItems(obsItems);
        } else if (operationArr[0].equals("recieveRequest")) {
            recieveRequest();
        } else if (operationArr[0].equals("confirmRequest")) {
            moveToGameBoardScreen();
        } else if (operationArr[0].equals("getPlayersData")) {
            System.out.println("fffffffffffffffff " + Arrays.toString(operationArr));
            getPlayersData();
        }
    }
// ps.println("sendAllUsers," + loopIp + "," + user.getUserName() + "," + user.getEmail() + "," + user.getGender());

    void addUserToList() {
        User user = new User();
        user.setIP(operationArr[1]);
        user.setUserName(operationArr[2]);
        user.setEmail(operationArr[3]);
        user.setGender(operationArr[4]);
        user.setScore(Integer.valueOf(operationArr[5]));
        usersList.add(user);
    }

    void moveToGameBoardScreen() {

        Platform.runLater(new Runnable() {
            public void run() {
                //OnlineGame onlineGame = new OnlineGame(firstPlayer,secondPlayer);
                OnlineGame onlineGame = new OnlineGame("a", 1, "b", 2);
                TicTacToeJava.stage.setScene(new Scene(onlineGame.gameBoard));
            }
        });
    }

    private void onProfileClick() {
        onlineListScreen.profilePic.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Platform.runLater(() -> {
                    Parent root;
                    if (SignIn.profileDataArr != null) {
                        root = new ProfileScreen(SignIn.profileDataArr);
                    } else {
                        root = new ProfileScreen(SignUp.profileDataArr);
                    }
                    TicTacToeJava.stage.setScene(new Scene(root));
                });
            }
        });
    }

    private void setRefresh() {

        onlineListScreen.refresh.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                listView.getItems().clear();
                usersList.clear();
                getAllOnlineUsers();
            }
        });
    }

    User firstPlayer = new User();
    User secondPlayer = new User();

    //[getPlayersData, 192.168.1.9, amr, amr@gmail.com, 0, Male, 192.168.1.9, amr, amr@gmail.com, 0, Male]
    void getPlayersData() {

        firstPlayer.setIP(operationArr[1]);
        firstPlayer.setUserName(operationArr[2]);
        firstPlayer.setEmail(operationArr[3]);
        firstPlayer.setScore(Integer.valueOf(operationArr[4]));
        firstPlayer.setGender(operationArr[5]);

        secondPlayer.setIP(operationArr[6]);
        secondPlayer.setUserName(operationArr[7]);
        secondPlayer.setEmail(operationArr[8]);
        secondPlayer.setScore(Integer.valueOf(operationArr[9]));
        secondPlayer.setGender(operationArr[10]);

        System.out.println("player1 = " + firstPlayer.toString());
        System.out.println("player2 = " + secondPlayer.toString());
    }
}

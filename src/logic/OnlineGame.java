/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import tictactoe.java.GameBoard;
import tictactoe.java.ResultLogic;
import tictactoe.java.TicTacToeJava;
import tictactoe.java.YouWinScreenBase;
import tictactoe.java.multiPlayerScreen;

/**
 *
 * @author Ahmed Abdo
 */
public class OnlineGame {

    public ClientSide clientSide;
    public GameBoard Online;
    int sourceMode;
    int turn,counter;
    boolean yourTurn;

    public OnlineGame(String playerOneName, int playerOneAvatarNumber, String playerTwoName, int playerTwoAvatarNumber) {
        yourTurn = true;
        turn = 2;
        counter=0;
        clientSide = ClientSide.getInstanse();
        Online = new GameBoard(playerOneName, playerOneAvatarNumber, playerTwoName, playerTwoAvatarNumber);
        sourceMode = 2;
        record();
        back();
        buttonshandel();
        receiveMessgeFromServer();

    }

    void receiveMessgeFromServer() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        if (clientSide.dis != null) {
                            String textmessage = clientSide.dis.readLine();
                            String[] arr = textmessage.split(" ");
                            if (arr[0].equals("game")) {
                                
                                int buttonNumber = Integer.parseInt(arr[1]);
                                switch (buttonNumber) {
                                    case 1:
                                        if (Online.button_1.getText().equals("")) {
                                            setXorO(Online.button_1, Online.button_1Image);
                                            TheWinner();
                                            yourTurn = true;
                                        }
                                        break;
                                    case 2:
                                        if (Online.button_2.getText().equals("")) {
                                            setXorO(Online.button_2, Online.button_2Image);
                                            TheWinner();
                                            yourTurn = true;
                                        }
                                        break;
                                    case 3:
                                        if (Online.button_3.getText().equals("")) {
                                            setXorO(Online.button_3, Online.button_3Image);
                                            TheWinner();
                                            yourTurn = true;
                                        }
                                        break;
                                    case 4:
                                        if (Online.button_4.getText().equals("")) {
                                            setXorO(Online.button_4, Online.button_4Image);
                                            TheWinner();
                                            yourTurn = true;
                                        }
                                        break;
                                    case 5:
                                        if (Online.button_5.getText().equals("")) {
                                            setXorO(Online.button_5, Online.button_5Image);
                                            TheWinner();
                                            yourTurn = true;
                                        }
                                        break;
                                    case 6:
                                        if (Online.button_6.getText().equals("")) {
                                            setXorO(Online.button_6, Online.button_6Image);
                                            TheWinner();
                                            yourTurn = true;
                                        }
                                        break;
                                    case 7:
                                        if (Online.button_7.getText().equals("")) {
                                            setXorO(Online.button_7, Online.button_7Image);
                                            TheWinner();
                                            yourTurn = true;
                                        }
                                        break;
                                    case 8:
                                        if (Online.button_8.getText().equals("")) {
                                            setXorO(Online.button_8, Online.button_8Image);
                                            TheWinner();
                                            yourTurn = true;
                                        }
                                        break;
                                    case 9:
                                        if (Online.button_9.getText().equals("")) {
                                            setXorO(Online.button_9, Online.button_9Image);
                                            TheWinner();
                                            yourTurn = true;
                                        }
                                        break;
                                    default:
                                }

                            }
                            else if(arr[0].equals("2ndPlayer")){
                                if(arr[1].equals("w")){
                                    System.out.println("yaaraab");
                                    Parent root = null;
                                    ResultLogic win = new ResultLogic("w");
                                    root = win.rs;
                                    Scene scene = new Scene(root);
                                    Stage stage = (Stage) Online.button_1Image.getScene().getWindow();
                                    stage.setScene(scene);
                                    stage.show();
                                }
                                
                                if(arr[1].equals("l")){
                                    System.out.println("yaaraab");
                                    Parent root = null;
                                    ResultLogic lose = new ResultLogic("l");
                                    root = lose.rs;
                                    Scene scene = new Scene(root);
                                    Stage stage = (Stage) Online.button_2Image.getScene().getWindow();
                                    stage.setScene(scene);
                                    stage.show();
                                }
                                
                                if(arr[1].equals("d")){
                                    System.out.println(arr[1]);
                                    Parent root = null;
                                    ResultLogic draw = new ResultLogic("l");
                                    root = draw.rs;
                                    Scene scene = new Scene(root);
                                    Stage stage = (Stage) Online.button_2.getScene().getWindow();
                                    stage.setScene(scene);
                                    stage.show();
                                }
                            }

                            clientSide.ps.flush();
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void record() {
        Online.recordGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Online.recordIndicatorImageView.setVisible(true);
                Online.recordIndicatorButton.setVisible(true);
            }
        });
    }

    public void back() {
        Online.backImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Parent root = null;
                root = new multiPlayerScreen();
                Scene scene = new Scene(root);
                Stage stage = (Stage) Online.backImageView.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
        });
    }

    public void buttonshandel() {
        Online.button_1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Online.button_1.getText().equals("") && yourTurn == true) {
                    setXorO(Online.button_1, Online.button_1Image);
                    clientSide.ps.println("game 1");
                    yourTurn = false;
                    TheWinner();
                }

            }
        });

        Online.button_2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Online.button_2.getText().equals("") && yourTurn == true) {
                    setXorO(Online.button_2, Online.button_2Image);
                    clientSide.ps.println("game 2");
                    yourTurn = false;
                    TheWinner();
                }

            }
        });

        Online.button_3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Online.button_3.getText().equals("") && yourTurn == true) {
                    setXorO(Online.button_3, Online.button_3Image);
                    clientSide.ps.println("game 3");
                    yourTurn = false;
                    TheWinner();
                }

            }
        });
        Online.button_4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Online.button_4.getText().equals("") && yourTurn == true) {
                    setXorO(Online.button_4, Online.button_4Image);
                    clientSide.ps.println("game 4");
                    yourTurn = false;
                    TheWinner();
                }

            }
        });
        Online.button_5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Online.button_5.getText().equals("") && yourTurn == true) {
                    setXorO(Online.button_5, Online.button_5Image);
                    clientSide.ps.println("game 5");
                    yourTurn = false;
                    TheWinner();
                }

            }
        });
        Online.button_6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Online.button_6.getText().equals("") && yourTurn == true) {
                    setXorO(Online.button_6, Online.button_6Image);
                    clientSide.ps.println("game 6");
                    yourTurn = false;
                    TheWinner();
                }

            }
        });
        Online.button_7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Online.button_7.getText().equals("") && yourTurn == true) {
                    setXorO(Online.button_7, Online.button_7Image);
                    clientSide.ps.println("game 7");
                    yourTurn = false;
                    TheWinner();
                }

            }
        });
        Online.button_8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Online.button_8.getText().equals("") && yourTurn == true) {
                    setXorO(Online.button_8, Online.button_8Image);
                    clientSide.ps.println("game 8");
                    yourTurn = false;
                    TheWinner();
                }

            }
        });
        Online.button_9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Online.button_9.getText().equals("") && yourTurn == true) {
                    setXorO(Online.button_9, Online.button_9Image);
                    clientSide.ps.println("game 9");
                    yourTurn = false;
                    TheWinner();
                }

            }
        });

    }

    public void setXorO(Button btn, ImageView iv) {
            if (turn % 2 == 0) {
            turn++;
    //        Platform.runLater(() -> {
                btn.setText("X");
                iv.setImage(new Image(getClass().getResource("/res/X.png").toExternalForm()));
     //       });
        } else {
            turn++;
            try{
    //        Platform.runLater(() -> {
                btn.setText("O");
                iv.setImage(new Image(getClass().getResource("/res/O.png").toExternalForm()));
     //       });
         }
             catch(Exception ex){
            
        }
        }
       
        
    }

    private int XisWinner() {
        counter++;
        if (Online.button_1.getText().equals("X") && Online.button_2.getText().equals("X") && Online.button_3.getText().equals("X")) {
            return 1;
        }
        if (Online.button_4.getText().equals("X") && Online.button_5.getText().equals("X") && Online.button_6.getText().equals("X")) {
            return 1;
        }
        if (Online.button_7.getText().equals("X") && Online.button_8.getText().equals("X") && Online.button_9.getText().equals("X")) {
            return 1;
        }
        if (Online.button_1.getText().equals("X") && Online.button_4.getText().equals("X") && Online.button_7.getText().equals("X")) {
            return 1;
        }
        if (Online.button_2.getText().equals("X") && Online.button_5.getText().equals("X") && Online.button_8.getText().equals("X")) {
            return 1;
        }
        if (Online.button_3.getText().equals("X") && Online.button_6.getText().equals("X") && Online.button_9.getText().equals("X")) {
            return 1;
        }
        if (Online.button_1.getText().equals("X") && Online.button_5.getText().equals("X") && Online.button_9.getText().equals("X")) {
            return 1;
        }
        if (Online.button_3.getText().equals("X") && Online.button_5.getText().equals("X") && Online.button_7.getText().equals("X")) {
            return 1;
        } else {
            return 0;
        }
        
    }

    public int OisWinner() {
        if (Online.button_1.getText().equals("O") && Online.button_2.getText().equals("O") && Online.button_3.getText().equals("O")) {
            return 1;
        }
        if (Online.button_4.getText().equals("O") && Online.button_5.getText().equals("O") && Online.button_6.getText().equals("O")) {
            return 1;
        }
        if (Online.button_7.getText().equals("O") && Online.button_8.getText().equals("O") && Online.button_9.getText().equals("O")) {
            return 1;
        }
        if (Online.button_1.getText().equals("O") && Online.button_4.getText().equals("O") && Online.button_7.getText().equals("O")) {
            return 1;
        }
        if (Online.button_2.getText().equals("O") && Online.button_5.getText().equals("O") && Online.button_8.getText().equals("O")) {
            return 1;
        }
        if (Online.button_3.getText().equals("O") && Online.button_6.getText().equals("O") && Online.button_9.getText().equals("O")) {
            return 1;
        }
        if (Online.button_1.getText().equals("O") && Online.button_5.getText().equals("O") && Online.button_9.getText().equals("O")) {
            return 1;
        }
        if (Online.button_3.getText().equals("O") && Online.button_5.getText().equals("O") && Online.button_7.getText().equals("O")) {
            return 1;
        } else {
            return 0;
        }
    }

    public void navigateToWinner(String player1, int player1Avatar, String player2, int player2avatar, char winnerChar) {
            Parent root = null;
            ResultLogic win = new ResultLogic(player1, player1Avatar, player2, player2avatar, 1, sourceMode, winnerChar);
            root = win.rs;
            Scene scene = new Scene(root);
            Stage stage = (Stage) Online.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
       //    TicTacToeJava.scene1.setRoot(win.rs);
    }

    public void TheWinner() {
        int xResult = XisWinner();
        int oResult = OisWinner();
        if (xResult == 1 || oResult == 1) {
            Parent root = null;
            if(yourTurn==false){
                clientSide.ps.println("2ndPlayer l");
                root = new YouWinScreenBase();
            }
            else{
                clientSide.ps.println("2ndPlayer w");
                ResultLogic lose = new ResultLogic("l");
                root = lose.rs;

            }
         //   navigateToWinner(Online.user1NameText.getText(), Online.player1Avatar, Online.user2NameText.getText(), Online.player2Avatar, 'x');
            Scene scene = new Scene(root);
            Stage stage = (Stage) Online.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
//        } else if (oResult == 1) {
//            clientSide.ps.println("2ndPlayer w");
//         //   navigateToWinner(Online.user1NameText.getText(), Online.player1Avatar, Online.user2NameText.getText(), Online.player2Avatar, 'o');
//            Parent root = null;
//            ResultLogic lose = new ResultLogic("l");
//            root = lose.rs;
//            Scene scene = new Scene(root);
//            Stage stage = (Stage) Online.getScene().getWindow();
//            stage.setScene(scene);
//            stage.show();
        }
        if (counter == 9 && xResult != 1 && oResult != 1) {
            clientSide.ps.println("2ndPlayer d");
            Parent root = null;
          //  ResultLogic draw = new ResultLogic(Online.user1NameText.getText(), Online.player1Avatar, Online.user2NameText.getText(), Online.player2Avatar, 0, sourceMode, 'd');
            ResultLogic draw = new ResultLogic("d");
            root = draw.rs;
            Scene scene = new Scene(root);
            Stage stage = (Stage) Online.backImageView.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
          //  TicTacToeJava.scene1.setRoot(draw.rs);
        }
    }

}

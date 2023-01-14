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

    public GameBoard gameBoard;
    int sourceMode;
    int turn, counter;
    boolean yourTurn;
    static OnlineGame onlineGame;

    public OnlineGame(String playerOneName, int playerOneAvatarNumber, String playerTwoName, int playerTwoAvatarNumber) {
        onlineGame = this;
        yourTurn = true;
        turn = 2;
        counter = 0;
        gameBoard = new GameBoard(playerOneName, playerOneAvatarNumber, playerTwoName, playerTwoAvatarNumber);
        sourceMode = 2;
        record();
        back();
        buttonshandel();

    }

    void doAction(String textmessage) {

        String[] arr = textmessage.split(",");
        if (arr[0].equals("game")) {

            int buttonNumber = Integer.parseInt(arr[1]);
            switch (buttonNumber) {
                case 1:
                    if (gameBoard.button_1.getText().equals("")) {
                        setXorO(gameBoard.button_1, gameBoard.button_1Image);
                        TheWinner();
                        yourTurn = true;
                    }
                    break;
                case 2:
                    if (gameBoard.button_2.getText().equals("")) {
                        setXorO(gameBoard.button_2, gameBoard.button_2Image);
                        TheWinner();
                        yourTurn = true;
                    }
                    break;
                case 3:
                    if (gameBoard.button_3.getText().equals("")) {
                        setXorO(gameBoard.button_3, gameBoard.button_3Image);
                        TheWinner();
                        yourTurn = true;
                    }
                    break;
                case 4:
                    if (gameBoard.button_4.getText().equals("")) {
                        setXorO(gameBoard.button_4, gameBoard.button_4Image);
                        TheWinner();
                        yourTurn = true;
                    }
                    break;
                case 5:
                    if (gameBoard.button_5.getText().equals("")) {
                        setXorO(gameBoard.button_5, gameBoard.button_5Image);
                        TheWinner();
                        yourTurn = true;
                    }
                    break;
                case 6:
                    if (gameBoard.button_6.getText().equals("")) {
                        setXorO(gameBoard.button_6, gameBoard.button_6Image);
                        TheWinner();
                        yourTurn = true;
                    }
                    break;
                case 7:
                    if (gameBoard.button_7.getText().equals("")) {
                        setXorO(gameBoard.button_7, gameBoard.button_7Image);
                        TheWinner();
                        yourTurn = true;
                    }
                    break;
                case 8:
                    if (gameBoard.button_8.getText().equals("")) {
                        setXorO(gameBoard.button_8, gameBoard.button_8Image);
                        TheWinner();
                        yourTurn = true;
                    }
                    break;
                case 9:
                    if (gameBoard.button_9.getText().equals("")) {
                        setXorO(gameBoard.button_9, gameBoard.button_9Image);
                        TheWinner();
                        yourTurn = true;
                    }
                    break;
                default:
            }

        } else if (arr[0].equals("2ndPlayer")) {
            if (arr[1].equals("w")) {
                ResultLogic win = new ResultLogic("w");
                TicTacToeJava.stage.setScene(new Scene(win.result));
            }

            if (arr[1].equals("l")) {
                ResultLogic lose = new ResultLogic("l");
                TicTacToeJava.stage.setScene(new Scene(lose.result));
            }

            if (arr[1].equals("d")) {
                ResultLogic draw = new ResultLogic("l");
                TicTacToeJava.stage.setScene(new Scene(draw.result));
            }
        }

        ClientSide.ps.flush();
    }

    public void record() {
        gameBoard.recordGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gameBoard.recordIndicatorImageView.setVisible(true);
                gameBoard.recordIndicatorButton.setVisible(true);
            }
        });
    }

    public void back() {
        gameBoard.backImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                TicTacToeJava.stage.setScene(new Scene(new multiPlayerScreen()));
            }
        });
    }

    public void buttonshandel() {
        gameBoard.button_1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (gameBoard.button_1.getText().equals("") && yourTurn == true) {
                    setXorO(gameBoard.button_1, gameBoard.button_1Image);
                    ClientSide.ps.println("game,1");
                    yourTurn = false;
                    TheWinner();
                }

            }
        });

        gameBoard.button_2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (gameBoard.button_2.getText().equals("") && yourTurn == true) {
                    setXorO(gameBoard.button_2, gameBoard.button_2Image);
                    ClientSide.ps.println("game,2");
                    yourTurn = false;
                    TheWinner();
                }

            }
        });

        gameBoard.button_3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (gameBoard.button_3.getText().equals("") && yourTurn == true) {
                    setXorO(gameBoard.button_3, gameBoard.button_3Image);
                    ClientSide.ps.println("game,3");
                    yourTurn = false;
                    TheWinner();
                }

            }
        });
        gameBoard.button_4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (gameBoard.button_4.getText().equals("") && yourTurn == true) {
                    setXorO(gameBoard.button_4, gameBoard.button_4Image);
                    ClientSide.ps.println("game,4");
                    yourTurn = false;
                    TheWinner();
                }

            }
        });
        gameBoard.button_5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (gameBoard.button_5.getText().equals("") && yourTurn == true) {
                    setXorO(gameBoard.button_5, gameBoard.button_5Image);
                    ClientSide.ps.println("game,5");
                    yourTurn = false;
                    TheWinner();
                }

            }
        });
        gameBoard.button_6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (gameBoard.button_6.getText().equals("") && yourTurn == true) {
                    setXorO(gameBoard.button_6, gameBoard.button_6Image);
                    ClientSide.ps.println("game,6");
                    yourTurn = false;
                    TheWinner();
                }

            }
        });
        gameBoard.button_7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (gameBoard.button_7.getText().equals("") && yourTurn == true) {
                    setXorO(gameBoard.button_7, gameBoard.button_7Image);
                    ClientSide.ps.println("game,7");
                    yourTurn = false;
                    TheWinner();
                }

            }
        });
        gameBoard.button_8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (gameBoard.button_8.getText().equals("") && yourTurn == true) {
                    setXorO(gameBoard.button_8, gameBoard.button_8Image);
                    ClientSide.ps.println("game,8");
                    yourTurn = false;
                    TheWinner();
                }

            }
        });
        gameBoard.button_9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (gameBoard.button_9.getText().equals("") && yourTurn == true) {
                    setXorO(gameBoard.button_9, gameBoard.button_9Image);
                    ClientSide.ps.println("game,9");
                    yourTurn = false;
                    TheWinner();
                }

            }
        });

    }

    public void setXorO(Button btn, ImageView iv) {
        if (turn % 2 == 0) {
            turn++;
            //       Platform.runLater(() -> {
            btn.setText("X");
            iv.setImage(new Image(getClass().getResource("/res/X.png").toExternalForm()));
            //         });
        } else {
            turn++;
            try {
                //            Platform.runLater(() -> {
                btn.setText("O");
                iv.setImage(new Image(getClass().getResource("/res/O.png").toExternalForm()));
                //           });
            } catch (Exception ex) {

            }
        }

    }

    private int XisWinner() {
        counter++;
        if (gameBoard.button_1.getText().equals("X") && gameBoard.button_2.getText().equals("X") && gameBoard.button_3.getText().equals("X")) {
            return 1;
        }
        if (gameBoard.button_4.getText().equals("X") && gameBoard.button_5.getText().equals("X") && gameBoard.button_6.getText().equals("X")) {
            return 1;
        }
        if (gameBoard.button_7.getText().equals("X") && gameBoard.button_8.getText().equals("X") && gameBoard.button_9.getText().equals("X")) {
            return 1;
        }
        if (gameBoard.button_1.getText().equals("X") && gameBoard.button_4.getText().equals("X") && gameBoard.button_7.getText().equals("X")) {
            return 1;
        }
        if (gameBoard.button_2.getText().equals("X") && gameBoard.button_5.getText().equals("X") && gameBoard.button_8.getText().equals("X")) {
            return 1;
        }
        if (gameBoard.button_3.getText().equals("X") && gameBoard.button_6.getText().equals("X") && gameBoard.button_9.getText().equals("X")) {
            return 1;
        }
        if (gameBoard.button_1.getText().equals("X") && gameBoard.button_5.getText().equals("X") && gameBoard.button_9.getText().equals("X")) {
            return 1;
        }
        if (gameBoard.button_3.getText().equals("X") && gameBoard.button_5.getText().equals("X") && gameBoard.button_7.getText().equals("X")) {
            return 1;
        } else {
            return 0;
        }

    }

    public int OisWinner() {
        if (gameBoard.button_1.getText().equals("O") && gameBoard.button_2.getText().equals("O") && gameBoard.button_3.getText().equals("O")) {
            return 1;
        }
        if (gameBoard.button_4.getText().equals("O") && gameBoard.button_5.getText().equals("O") && gameBoard.button_6.getText().equals("O")) {
            return 1;
        }
        if (gameBoard.button_7.getText().equals("O") && gameBoard.button_8.getText().equals("O") && gameBoard.button_9.getText().equals("O")) {
            return 1;
        }
        if (gameBoard.button_1.getText().equals("O") && gameBoard.button_4.getText().equals("O") && gameBoard.button_7.getText().equals("O")) {
            return 1;
        }
        if (gameBoard.button_2.getText().equals("O") && gameBoard.button_5.getText().equals("O") && gameBoard.button_8.getText().equals("O")) {
            return 1;
        }
        if (gameBoard.button_3.getText().equals("O") && gameBoard.button_6.getText().equals("O") && gameBoard.button_9.getText().equals("O")) {
            return 1;
        }
        if (gameBoard.button_1.getText().equals("O") && gameBoard.button_5.getText().equals("O") && gameBoard.button_9.getText().equals("O")) {
            return 1;
        }
        if (gameBoard.button_3.getText().equals("O") && gameBoard.button_5.getText().equals("O") && gameBoard.button_7.getText().equals("O")) {
            return 1;
        } else {
            return 0;
        }
    }

    public void navigateToWinner(String player1, int player1Avatar, String player2, int player2avatar, char winnerChar) {
        ResultLogic win = new ResultLogic(player1, player1Avatar, player2, player2avatar, 1, sourceMode, winnerChar);
        TicTacToeJava.stage.setScene(new Scene(win.result));
    }

    public void TheWinner() {
        int xResult = XisWinner();
        int oResult = OisWinner();
        if (xResult == 1 || oResult == 1) {
            Parent root = null;
            if (yourTurn == false) {
                ClientSide.ps.println("2ndPlayer,l");
                root = new YouWinScreenBase();
            } else {
                ClientSide.ps.println("2ndPlayer,w");
                ResultLogic lose = new ResultLogic("l");
                root = lose.result;

            }
            //   navigateToWinner(Online.user1NameText.getText(), Online.player1Avatar, Online.user2NameText.getText(), Online.player2Avatar, 'x');
            TicTacToeJava.stage.setScene(new Scene(root));
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
            ClientSide.ps.println("2ndPlayer,d");
            Parent root = null;
            //  ResultLogic draw = new ResultLogic(Online.user1NameText.getText(), Online.player1Avatar, Online.user2NameText.getText(), Online.player2Avatar, 0, sourceMode, 'd');
            ResultLogic draw = new ResultLogic("d");
            TicTacToeJava.stage.setScene(new Scene(draw.result));
            //  TicTacToeJava.scene1.setRoot(draw.rs);
        }
    }

}

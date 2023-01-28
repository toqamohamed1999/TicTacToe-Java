
package logic;


import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.WindowEvent;
import tictactoe.java.GameBoard;
import tictactoe.java.ResultLogic;
import tictactoe.java.TicTacToeJava;
import tictactoe.java.YouWinScreenBase;
import tictactoe.java.multiPlayerScreen;

public class OnlineGame {

    public GameBoard gameBoard;
    int sourceMode;
    int turn, counter;
    boolean yourTurn;
    static OnlineGame onlineGame;
    public int player1Avatar, player2Avatar;
    String player1;
    String player2;
    User myUser1, myUser2;
    String recieverIp = null;
    String myIp;

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
        
        TicTacToeJava.stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                try {
                    ClientSide.ps.println("logOut,"+Inet4Address.getLocalHost().getHostAddress());
                } catch (UnknownHostException ex) {
                    Logger.getLogger(OnlineGame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    public OnlineGame(User user1, User user2) {

        myUser1 = user1;
        myUser2 = user2;
        try {
            myIp = Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
        if (!myIp.equals(user1.getIP())) {
            recieverIp = user1.getIP();
        } else {
            recieverIp = user2.getIP();
        }

        onlineGame = this;
        yourTurn = true;
        turn = 2;
        counter = 0;
        player1 = user1.getUserName();
        player2 = user2.getUserName();
        if (user1.gender.toLowerCase().equals("female")) {
            player1Avatar = 2;
        } else {
            player1Avatar = 1;
        }
        if (user2.gender.toLowerCase().equals("female")) {
            player2Avatar = 2;
        } else {
            player2Avatar = 1;
        }
        gameBoard = new GameBoard(user1.userName, player1Avatar, user2.userName, player2Avatar);
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
                        TheWinner(2);
                        yourTurn = true;
                    }
                    break;
                case 2:
                    if (gameBoard.button_2.getText().equals("")) {
                        setXorO(gameBoard.button_2, gameBoard.button_2Image);
                        TheWinner(2);
                        yourTurn = true;
                    }
                    break;
                case 3:
                    if (gameBoard.button_3.getText().equals("")) {
                        setXorO(gameBoard.button_3, gameBoard.button_3Image);
                        TheWinner(2);
                        yourTurn = true;
                    }
                    break;
                case 4:
                    if (gameBoard.button_4.getText().equals("")) {
                        setXorO(gameBoard.button_4, gameBoard.button_4Image);
                        TheWinner(2);
                        yourTurn = true;
                    }
                    break;
                case 5:
                    if (gameBoard.button_5.getText().equals("")) {
                        setXorO(gameBoard.button_5, gameBoard.button_5Image);
                        TheWinner(2);
                        yourTurn = true;
                    }
                    break;
                case 6:
                    if (gameBoard.button_6.getText().equals("")) {
                        setXorO(gameBoard.button_6, gameBoard.button_6Image);
                        TheWinner(2);
                        yourTurn = true;
                    }
                    break;
                case 7:
                    if (gameBoard.button_7.getText().equals("")) {
                        setXorO(gameBoard.button_7, gameBoard.button_7Image);
                        TheWinner(2);
                        yourTurn = true;
                    }
                    break;
                case 8:
                    if (gameBoard.button_8.getText().equals("")) {
                        setXorO(gameBoard.button_8, gameBoard.button_8Image);
                        TheWinner(2);
                        yourTurn = true;
                    }
                    break;
                case 9:
                    if (gameBoard.button_9.getText().equals("")) {
                        setXorO(gameBoard.button_9, gameBoard.button_9Image);
                        TheWinner(2);
                        yourTurn = true;
                    }
                    break;
                default:
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
                    if (counter == 0) {
                        if (myIp.equals(myUser1.getIP())) {
                            setXorO(gameBoard.button_1, gameBoard.button_1Image);
                            ClientSide.ps.println("game,1," + recieverIp);
                            TheWinner(1);
                            yourTurn = false;
                        }
                    } else {
                    setXorO(gameBoard.button_1, gameBoard.button_1Image);
                    ClientSide.ps.println("game,1," + recieverIp);
                    TheWinner(1);
                    yourTurn = false;
                    }
                }

            }
        });

        gameBoard.button_2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (gameBoard.button_2.getText().equals("") && yourTurn == true) {
                    if (counter == 0) {
                        if (myIp.equals(myUser1.getIP())) {
                            setXorO(gameBoard.button_2, gameBoard.button_2Image);
                            ClientSide.ps.println("game,2," + recieverIp);
                            TheWinner(1);
                            yourTurn = false;
                        }
                    } else {
                    setXorO(gameBoard.button_2, gameBoard.button_2Image);
                    ClientSide.ps.println("game,2," + recieverIp);
                    TheWinner(1);
                    yourTurn = false;
                    }
                }

            }
        });

        gameBoard.button_3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (gameBoard.button_3.getText().equals("") && yourTurn == true) {
                    if (counter == 0) {
                        if (myIp.equals(myUser1.getIP())) {
                            setXorO(gameBoard.button_3, gameBoard.button_3Image);
                            ClientSide.ps.println("game,3," + recieverIp);
                            TheWinner(1);
                            yourTurn = false;
                        }
                    } else {
                    setXorO(gameBoard.button_3, gameBoard.button_3Image);
                    ClientSide.ps.println("game,3," + recieverIp);
                    TheWinner(1);
                    yourTurn = false;
                    }
                }

            }
        });
        gameBoard.button_4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (gameBoard.button_4.getText().equals("") && yourTurn == true) {
                    if (counter == 0) {
                        if (myIp.equals(myUser1.getIP())) {
                            setXorO(gameBoard.button_4, gameBoard.button_4Image);
                            ClientSide.ps.println("game,4," + recieverIp);
                            TheWinner(1);
                            yourTurn = false;
                        }
                    } else {
                    setXorO(gameBoard.button_4, gameBoard.button_4Image);
                    ClientSide.ps.println("game,4," + recieverIp);
                    TheWinner(1);
                    yourTurn = false;
                    }
                }

            }
        });
        gameBoard.button_5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (gameBoard.button_5.getText().equals("") && yourTurn == true) {
                    if (counter == 0) {
                        if (myIp.equals(myUser1.getIP())) {
                            setXorO(gameBoard.button_5, gameBoard.button_5Image);
                            ClientSide.ps.println("game,5," + recieverIp);
                            TheWinner(1);
                            yourTurn = false;
                        }
                    } else {
                    setXorO(gameBoard.button_5, gameBoard.button_5Image);
                    ClientSide.ps.println("game,5," + recieverIp);
                    TheWinner(1);
                    yourTurn = false;
                    }
                }

            }
        });
        gameBoard.button_6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (gameBoard.button_6.getText().equals("") && yourTurn == true) {
                    if (counter == 0) {
                        if (myIp.equals(myUser1.getIP())) {
                            setXorO(gameBoard.button_6, gameBoard.button_6Image);
                            ClientSide.ps.println("game,6," + recieverIp);
                            TheWinner(1);
                            yourTurn = false;
                        }
                    } else {
                    setXorO(gameBoard.button_6, gameBoard.button_6Image);
                    ClientSide.ps.println("game,6," + recieverIp);
                    TheWinner(1);
                    yourTurn = false;
                    }
                }

            }
        });
        gameBoard.button_7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (gameBoard.button_7.getText().equals("") && yourTurn == true) {
                    if (counter == 0) {
                        if (myIp.equals(myUser1.getIP())) {
                            setXorO(gameBoard.button_7, gameBoard.button_7Image);
                            ClientSide.ps.println("game,7," + recieverIp);
                            TheWinner(1);
                            yourTurn = false;
                        }
                    } else {
                    setXorO(gameBoard.button_7, gameBoard.button_7Image);
                    ClientSide.ps.println("game,7," + recieverIp);
                    TheWinner(1);
                    yourTurn = false;
                    }

                }

            }
        });
        gameBoard.button_8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (gameBoard.button_8.getText().equals("") && yourTurn == true) {
                   if (counter == 0) {
                        if (myIp.equals(myUser1.getIP())) {
                            setXorO(gameBoard.button_8, gameBoard.button_8Image);
                            ClientSide.ps.println("game,8," + recieverIp);
                            TheWinner(1);
                            yourTurn = false;
                        }
                    } else {
                    setXorO(gameBoard.button_8, gameBoard.button_8Image);
                    ClientSide.ps.println("game,8," + recieverIp);
                    TheWinner(1);
                    yourTurn = false;
                    }
                }

            }
        });
        gameBoard.button_9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (gameBoard.button_9.getText().equals("") && yourTurn == true) {
                    if (counter == 0) {
                        if (myIp.equals(myUser1.getIP())) {
                            setXorO(gameBoard.button_9, gameBoard.button_9Image);
                            ClientSide.ps.println("game,9," + recieverIp);
                            TheWinner(1);
                            yourTurn = false;
                        }
                    } else {
                    setXorO(gameBoard.button_9, gameBoard.button_9Image);
                    ClientSide.ps.println("game,9," + recieverIp);
                    TheWinner(1);
                    yourTurn = false;
                    }
                }

            }
        });

    }

    public void setXorO(Button btn, ImageView iv) {
        if (turn % 2 == 0) {
            turn++;
            btn.setText("X");
            iv.setImage(new Image(getClass().getResource("/res/X.png").toExternalForm()));
        } else {
            turn++;
            btn.setText("O");
            iv.setImage(new Image(getClass().getResource("/res/O.png").toExternalForm()));
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

    public void TheWinner(int a) {

        int xResult = XisWinner();
        int oResult = OisWinner();
        if (xResult == 1 || oResult == 1) {
            if (a == 1) {
                if(myIp.equals(myUser1.getIP()))ClientSide.ps.println("updateScore,"+myUser1.getEmail()+","+(myUser1.getScore()+10));
                else ClientSide.ps.println("updateScore,"+myUser2.getEmail()+","+(myUser2.getScore()+10));
                TicTacToeJava.stage.setScene(new Scene(new YouWinScreenBase()));
            } else {

                ResultLogic lose = new ResultLogic("l");
                TicTacToeJava.stage.setScene(new Scene(lose.result));
            }
        }
        if (counter == 9 && xResult != 1 && oResult != 1) {
            ResultLogic draw = new ResultLogic("d");
            TicTacToeJava.stage.setScene(new Scene(draw.result));
        }
    }

}

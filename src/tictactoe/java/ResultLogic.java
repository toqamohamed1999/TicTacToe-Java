package tictactoe.java;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Ahmed Abdo
 */
public class ResultLogic {

    public ResultScreen result;
    int state;
    int sourceMode;
    char winner;
    String statusletter;

    public ResultLogic(String stateLetter, int source, String name, int playerAvatar) {
        result = new ResultScreen();
        sourceMode = source;
        exitGame();
        goHome();
        hideLabels();
        statusletter = stateLetter;
        checkAndShow(statusletter);
        playAgain(name, playerAvatar);
    }

    public ResultLogic(String stateLetter) {
        result = new ResultScreen();
        exitGame();
        goHome();
        hideLabels();
        statusletter = stateLetter;
        checkAndShow(statusletter);
    }

    public ResultLogic(String player1, int player1Avatar, String player2, int player2Avatar, int originNumber, int source, char win) {
        result = new ResultScreen();
        state = originNumber;
        sourceMode = source;
        winner = win;
        playAgain(player1, player1Avatar, player2, player2Avatar);
        exitGame();
        setPlayer1Pic(player1Avatar);
        setPlayer2Pic(player2Avatar);
        setPlayer1Name(player1);
        setPlayer2Name(player2);
        goHome();
        setResultLabel(player1, player2);
        setResultPic();
        setPlayerLabels();
    }

    public void checkAndShow(String stateLetter) {
        if (stateLetter.equals("w")) {
            result.resultLabel.setText("You Win");
            result.resultPic.setImage(new Image(getClass().getResource("/res/win.png").toExternalForm()));
        }
        if (stateLetter.equals("d")) {
            result.resultLabel.setText("It's a Draw");
            result.resultPic.setImage(new Image(getClass().getResource("/res/draw.png").toExternalForm()));
        }
        if (stateLetter.equals("l")) {
            result.resultLabel.setText("You lost");
            result.resultPic.setImage(new Image(getClass().getResource("/res/lost.png").toExternalForm()));
        }
    }

    public void hideLabels() {
        result.player1Pic.setVisible(false);
        result.player2Pic.setVisible(false);
        result.player1Name.setVisible(false);
        result.player2Name.setVisible(false);
        result.player1CardPane.setVisible(false);
        result.player2CardPane.setVisible(false);
        result.player1State.setVisible(false);
        result.player2State.setVisible(false);
    }

    public void playAgain(String player, int playerAvatar) {
        result.playAgainButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root = null;
                if (sourceMode == 1) {
                    EasyMode easyMode = new EasyMode(player, playerAvatar, "Computer", 3);
                    root = easyMode.board;
                }
                if (sourceMode == 3) {
                    HardMode hardMode = new HardMode(player, playerAvatar, "Computer", 5);
                    root = hardMode.board;
                }
                TicTacToeJava.stage.setScene(new Scene(root));
            }
        });

    }

    public void playAgain(String player1, int player1Avatar, String player2, int player2Avatar) {
        result.playAgainButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root = null;
                System.out.println(sourceMode);
                if (sourceMode == 1) {
                    EasyMode easyMode = new EasyMode(player1, player1Avatar, player2, player2Avatar);
                    root = easyMode.board;
                } else if (sourceMode == 4) {
                    MultiPlayer mp = new MultiPlayer(player1, player1Avatar, player2, player2Avatar);
                    root = mp.board;
                }
                TicTacToeJava.stage.setScene(new Scene(root));
            }
        });
    }

    public void exitGame() {
        result.exitGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });
    }

    public void setPlayer1Pic(int player1Avatar) {
        if (player1Avatar == 1) {
            result.player1Pic.setImage(new Image(getClass().getResource("/res/man.png").toExternalForm()));
        } else if (player1Avatar == 2) {
            result.player1Pic.setImage(new Image(getClass().getResource("/res/woman.png").toExternalForm()));
        } else if (player1Avatar == 3) {
            result.player1Pic.setImage(new Image(getClass().getResource("/res/Easy.png").toExternalForm()));
        }
    }

    public void setPlayer2Pic(int Player2Avatar) {
        if (Player2Avatar == 1) {
            result.player2Pic.setImage(new Image(getClass().getResource("/res/man.png").toExternalForm()));
        } else if (Player2Avatar == 2) {
            result.player2Pic.setImage(new Image(getClass().getResource("/res/woman.png").toExternalForm()));
        } else if (Player2Avatar == 3) {
            result.player2Pic.setImage(new Image(getClass().getResource("/res/Easy.png").toExternalForm()));
        }
    }

    public void setPlayer1Name(String player1) {
        result.player1Name.setText(player1);
    }

    public void setPlayer2Name(String player2) {
        result.player2Name.setText(player2);
    }

    public void goHome() {
        result.homeButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                TicTacToeJava.stage.setScene(new Scene(new HomeScreen()));
            }
        });
    }

    public void setResultLabel(String player1, String player2) {
        if (state == 0) {
            result.resultLabel.setText("Both Too Good");
        } else if (state == 1) {
            if (winner == 'x') {
                result.resultLabel.setText(player1 + " Wins");
            } else {
                result.resultLabel.setText(player2 + " Wins");
            }
        }
    }

    public void setResultPic() {
        if (state == 0) {
            result.resultPic.setImage(new Image(getClass().getResource("/res/draw.png").toExternalForm()));
        } else if (state == 1) {
            result.resultPic.setImage(new Image(getClass().getResource("/res/win.png").toExternalForm()));
        }
    }

    public void setPlayerLabels() {
        if (state == 0) {
            result.player1State.setText("Winner");
            result.player2State.setText("Winner");
        } else if (state == 1) {
            if (winner == 'x') {
                result.player1State.setText("Winner");
                result.player2State.setText("Loser");
            } else {
                result.player1State.setText("Loser");
                result.player2State.setText("Winner");
            }
        }
    }
}

package tictactoe.java;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.IntStream;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import logic.recordLogic;

public class EasyMode {

    GameBoard board;
    //all logic variable
    private Button[] btns = new Button[9];
    private ImageView[] images = new ImageView[9];
    boolean gameOver = false;
    int activePlayer = 1;//x player(user)
    int gameState[] = {3, 3, 3, 3, 3, 3, 3, 3, 3};
    int winingPosition[][] = {
        {0, 1, 2},
        {3, 4, 5},
        {6, 7, 8},
        {0, 3, 6},
        {1, 4, 7},
        {2, 5, 8},
        {0, 4, 8},
        {2, 4, 6}
    };
    int sourceMode;
    recordLogic rec;
    String fileName;

    public EasyMode(String playerOneName, int playerOneAvatarNumber, String playerTwoName, int playerTwoAvatarNumber) {
        board = new GameBoard(playerOneName, playerOneAvatarNumber, playerTwoName, playerTwoAvatarNumber);
        record();
        back();
        addButtonstoArray();
        play();
        sourceMode = 1;
    }

    public void record() {
        board.recordGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                board.recordIndicatorImageView.setVisible(true);
                board.recordIndicatorButton.setVisible(true);
                rec = new recordLogic();
                fileName = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
                rec.createFile(fileName);
            }
        });
    }

    public void back() {
        board.backImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                showAlart();
            }
        });
    }

    private void addButtonstoArray() {
        btns[0] = board.button_1;
        btns[1] = board.button_2;
        btns[2] = board.button_3;
        btns[3] = board.button_4;
        btns[4] = board.button_5;
        btns[5] = board.button_6;
        btns[6] = board.button_7;
        btns[7] = board.button_8;
        btns[8] = board.button_9;

        images[0] = board.button_1Image;
        images[1] = board.button_2Image;
        images[2] = board.button_3Image;
        images[3] = board.button_4Image;
        images[4] = board.button_5Image;
        images[5] = board.button_6Image;
        images[6] = board.button_7Image;
        images[7] = board.button_8Image;
        images[8] = board.button_9Image;

    }

    private void play() {
        for (Button mybtn : btns) {
            mybtn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Button currentBtn = (Button) actionEvent.getSource();
                    String btnIdS = currentBtn.getId();
                    int btnId = Integer.parseInt(btnIdS);

                    if (gameOver) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("finish message");
                        alert.setContentText("Game over !!  Try to restart the game");
                        alert.show();
                    } else {
                        //game is not over to do chances
                        //check for player
                        if (gameState[btnId] == 3) {
                            //proceed
                            if (activePlayer == 1) {

                                images[btnId].setImage(new Image(getClass().getResource("/res/X.png").toExternalForm()));
                                gameState[btnId] = activePlayer;
                                checkForWinner();
                                activePlayer = 0;
                                if (fileName != null) {
                                    btnId++;
                                    rec.writeFile("X," + btnId, fileName);
                                }
                                for (int i = 0; i < gameState.length; i++) {
                                    if (gameState[i] == 3 && !gameOver) {
                                        images[i].setImage(new Image(getClass().getResource("/res/O.png").toExternalForm()));
                                        gameState[i] = activePlayer;
                                        checkForWinner();
                                        activePlayer = 1;

                                        if (fileName != null) {
                                            btnId++;
                                            rec.writeFile("O," + btnId, fileName);
                                        }
                                        break;

                                    }
                                }

                            } else {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("message");
                                alert.setContentText("Placed is already occupied");
                                alert.show();
                            }
                        }

                    }
                }

            });
        }

    }

    private void checkForWinner() {

        if (!gameOver) {
            boolean contains = IntStream.of(gameState).anyMatch(x -> x == 3);
            if (!contains) {
                navigateToWinner("d");
                gameOver = true;
            } else {
                for (int wp[] : winingPosition) {
                    if (gameState[wp[0]] == gameState[wp[1]] && gameState[wp[1]] == gameState[wp[2]] && gameState[wp[1]] != 3) {
                        // activePlayer has winner
                        if (activePlayer == 1) {
                            navigateToWinner("w");
                        } else {
                            navigateToWinner("l");
                        }
                        gameOver = true;
                        break;
                    }

                }
            }
        }
    }

    private void navigateToWinner(String s) {
        Parent root = null;
        if (s.equals("w")) {
            root = new YouWinScreenBase(s, 1, board.user1NameText.getText(), board.player1Avatar);
        } else {
            ResultLogic win = new ResultLogic(s, 1, board.user1NameText.getText(), board.player1Avatar);
            root = win.result;
        }
        final Parent root1 = root;
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    TicTacToeJava.stage.setScene(new Scene(root1));
                    timer.cancel();
                });
            }
        }, 1000, 1000);

    }

    public void showAlart() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit!");
        alert.setHeaderText("If you exit the game you will lose.");

        Optional<ButtonType> result = alert.showAndWait();
        ButtonType button = result.orElse(ButtonType.CANCEL);

        if (button == ButtonType.OK) {
            TicTacToeJava.stage.setScene(new Scene(new HomeScreen()));
        } else {
            alert.close();
        }

    }

}

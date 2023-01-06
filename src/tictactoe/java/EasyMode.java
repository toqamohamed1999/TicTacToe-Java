package tictactoe.java;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class EasyMode {

    MultipleUserXOScreenBase board;
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

    public EasyMode(String playerOneName, int playerOneAvatarNumber) {
        board = new MultipleUserXOScreenBase(playerOneName, playerOneAvatarNumber, "Computer", 1);
        record();
        back();
        addButtonstoArray();
        play();
    }

    public void record() {
        board.recordGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                board.recordIndicatorImageView.setVisible(true);
                board.recordIndicatorButton.setVisible(true);
            }
        });
    }

    public void back() {
        board.backImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Parent root = null;
                root = new HomeScreen();
                Scene scene = new Scene(root);
                Stage stage = (Stage) board.backImageView.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
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

                    //            currentBtn.setGraphic(new ImageView(new Image("/res/X.png", 40, 40, true, true)));
                                images[btnId].setImage(new Image(getClass().getResource("/res/X.png").toExternalForm()));
                                gameState[btnId] = activePlayer;
                                checkForWinner();
                                activePlayer = 0;

                                for (int i = 0; i < gameState.length; i++) {

                                    if (gameState[i] == 3 && !gameOver) {
                      //                  currentBtn = btns[i];
                     //                   currentBtn.setGraphic(new ImageView(new Image("/res/O.png", 40, 40, true, true)));
                                        images[i].setImage(new Image(getClass().getResource("/res/O.png").toExternalForm()));
                                        gameState[i] = activePlayer;
                                        checkForWinner();
                                        activePlayer = 1;
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
            System.out.println(Arrays.toString(gameState));
            if (!contains) {
                System.out.println(Arrays.toString(gameState));
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("message");
                alert.setContentText("No one has won the game");
                alert.show();
                gameOver = true;
            } else {
                for (int wp[] : winingPosition) {
                    if (gameState[wp[0]] == gameState[wp[1]] && gameState[wp[1]] == gameState[wp[2]] && gameState[wp[1]] != 3) {
                        // activePlayer has winner
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Success message");
                        alert.setContentText((activePlayer == 1 ? "X " : "0 ") + " has won the game");

                        navigateToWinner(board.user1NameText.getText(), board.player1Avatar, board.user2NameText.getText(), board.player2Avatar);

                   //     btns[wp[0]].setStyle("-fx-background-color: #33F000; -fx-border-color: grey; -fx-border-radius: 5;");
                   //     btns[wp[1]].setStyle("-fx-background-color: #33F000; -fx-border-color: grey; -fx-border-radius: 5;");
                   //     btns[wp[2]].setStyle("-fx-background-color: #33F000; -fx-border-color: grey; -fx-border-radius: 5;");
                        //   btns[wp[2]].setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
                      //  alert.show();
                        gameOver = true;
                        break;
                    }

                }
            }
        }
    }

    private void navigateToWinner(String winner, int winnerAvatar, String loser, int loserAvatar) {
        Parent root = null;
        //pass winner name and loser name
        root = new winnerScreen(winner, winnerAvatar, loser, loserAvatar);
        Scene scene = new Scene(root);
        Stage stage = (Stage) board.backImageView.getScene().getWindow();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    stage.setScene(scene);
                    stage.show();
                });
            }
        }, 3000, 3000);

    }

}

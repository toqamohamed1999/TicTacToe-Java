package tictactoe.java;


import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;
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


public class HardMode {

    GameBoard board;
    //all logic variable
    Button[][] btns;
    boolean haswinner = false;
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


    public HardMode(String playerOneName, int playerOneAvatarNumber, String playerTwoName, int playerTwoAvatarNumber) {
        board = new GameBoard(playerOneName, playerOneAvatarNumber, playerTwoName, playerTwoAvatarNumber);
        record();
        back();
        addButtonstoArray();
        play();
        sourceMode = 3;
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
                showAlert();
                TicTacToeJava.stage.setScene(new Scene(new HomeScreen()));
            }
        });
    }

    private void addButtonstoArray() {

        Button[][] arr = {{board.button_1, board.button_2, board.button_3},
        {board.button_4, board.button_5, board.button_6},
        {board.button_7, board.button_8, board.button_9}};
        btns = arr;

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
        for (Button[] btn : btns) {
            for (Button mybtn : btn) {
                mybtn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        Button currentBtn = (Button) actionEvent.getSource();
                        String btnIdS = currentBtn.getId();
                        int btnId = Integer.parseInt(btnIdS);
                        if (!haswinner) {
                            if (currentBtn.getText() == "") {
                                currentBtn.setText("X");
                                System.err.println("X");
                                images[btnId].setImage(new Image(getClass().getResource("/res/X.png").toExternalForm()));
                                int result = minimax(btns, 100, false, true);
                                haswinner = checkWinner(btns) != 1;
                            } else {
                                System.out.println("Not Empty");
                            }
                        }
                        int result = checkWinner(btns);
                        if (result == 0) {
                            navigateToWinner("d", 3, board.user1NameText.getText(), board.player1Avatar);
                        } else {
                            if (result == 2) {
                                navigateToWinner("w", 3, board.user1NameText.getText(), board.player1Avatar);
                            } else if (result == -2) {
                                navigateToWinner("l", 3, board.user1NameText.getText(), board.player1Avatar);
                            }
                        }
                    }

                });
            }
        }

    }

    private void navigateToWinner(String state, int source, String player, int playerAvatar) {
        Parent root = null;
        if (state.equals("w")) {
            root = new YouWinScreenBase(state, source, player, playerAvatar);
        } else {
            ResultLogic win = new ResultLogic(state, source, player, playerAvatar);
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
        }, 2000, 2000);

    }

    public int minimax(Button board[][], int depth, boolean isMaximizing, boolean firstTime) {
        int result = checkWinner(board);
        if (depth == 0 || result != 1) {
            return result;
        }

        if (isMaximizing) {
            int finalScore = -10;
            int finalI = 0, finalJ = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j].getText().equals("")) {
                        board[i][j].setText("X");

                        int score = minimax(board, depth - 1, false, false);
                        board[i][j].setText("");
                        if (score > finalScore) {
                            finalScore = score;
                            finalI = i;
                            finalJ = j;
                        }
                    }
                }
            }
            if (firstTime) {
                board[finalI][finalJ].setText("X");

                String btnIdS = board[finalI][finalJ].getId();
                int btnId = Integer.parseInt(btnIdS);
                images[btnId].setImage(new Image(getClass().getResource("/res/X.png").toExternalForm()));

            }
            return finalScore;
        } else {
            int finalScore = 10;
            int finalI = 0, finalJ = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j].getText().equals("")) {
                        board[i][j].setText("O");
                        int score = minimax(board, depth - 1, true, false);
                        board[i][j].setText("");
                        if (score < finalScore) {
                            finalScore = score;
                            finalI = i;
                            finalJ = j;
                        }
                    }
                }
            }
            if (firstTime) {
                board[finalI][finalJ].setText("O");
                String btnIdS = board[finalI][finalJ].getId();
                int btnId = Integer.parseInt(btnIdS);
                images[btnId].setImage(new Image(getClass().getResource("/res/O.png").toExternalForm()));

            }
            return finalScore;
        }
    }

    public int checkWinner(Button btns[][]) {
        //  2: X winner
        // -2: O winner
        //  0: Tie
        //  1: No winner
        int result = 1;

        // For rows
        for (int i = 0; i < 3; i++) {
            if (haveTheSameValueAndNotEmpty(btns[i][0], btns[i][1], btns[i][2])) {
                result = btns[i][0].getText().equals("X") ? 2 : -2;
            }
        }

        // For cols
        for (int i = 0; i < 3; i++) {
            if (haveTheSameValueAndNotEmpty(btns[0][i], btns[1][i], btns[2][i])) {
                result = btns[0][i].getText().equals("X") ? 2 : -2;
            }
        }

        // Diameter 1
        if (haveTheSameValueAndNotEmpty(btns[0][0], btns[1][1], btns[2][2])) {
            result = btns[0][0].getText().equals("X") ? 2 : -2;
        } // Diameter 2
        else if (haveTheSameValueAndNotEmpty(btns[2][0], btns[1][1], btns[0][2])) {
            result = btns[2][0].getText().equals("X") ? 2 : -2;
        }

        // For Tie Case
        boolean tie = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (btns[i][j].getText().equals("")) {
                    tie = false;
                }
            }
        }
        if (tie) {
            result = 0;
        }

        return result;
    }

    public boolean haveTheSameValueAndNotEmpty(Button x, Button y, Button z) {
        return x.getText().equals(y.getText()) && x.getText().equals(z.getText()) && !(x.getText().equals(""));
    }
    
    
      public void showAlert() {
       
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

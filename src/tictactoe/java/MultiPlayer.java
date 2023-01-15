/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.java;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;
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
import javafx.stage.Stage;
import logic.recordLogic;

/**
 *
 * @author Monica
 */
public class MultiPlayer {

    GameBoard board;
    int sourceMode;
    recordLogic rec;
    String fileName;

    public MultiPlayer(String playerOneName, int playerOneAvatarNumber, String playerTwoName, int playerTwoAvatarNumber) {
        board = new GameBoard(playerOneName, playerOneAvatarNumber, playerTwoName, playerTwoAvatarNumber);
        record();
        back();
        buttonshandel();
        sourceMode = 4;
    }

    public void record() {
        board.recordGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                rec = new recordLogic();
                board.recordIndicatorImageView.setVisible(true);
                board.recordIndicatorButton.setVisible(true);
                fileName = new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(Calendar.getInstance().getTime());
                rec.createFile(fileName);
            }
        });
    }

    public void back() {
        board.backImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Exit!");
                alert.setHeaderText("Do you want to exit.");

                Optional<ButtonType> result = alert.showAndWait();
                ButtonType button = result.orElse(ButtonType.CANCEL);

                if (button == ButtonType.OK) {
                    TicTacToeJava.stage.setScene(new Scene(new HomeScreen()));

                } else {
                    alert.close();

                }
            }
        });

    }

    public void buttonshandel() {
        board.button_1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (board.button_1.getText().equals("")) {
                    setXorO(board.button_1, board.button_1Image);
                    TheWinner();
                }

            }
        });

        board.button_2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (board.button_2.getText().equals("")) {
                    setXorO(board.button_2, board.button_2Image);
                    TheWinner();
                }

            }
        });

        board.button_3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (board.button_3.getText().equals("")) {
                    setXorO(board.button_3, board.button_3Image);
                    TheWinner();
                }

            }
        });
        board.button_4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (board.button_4.getText().equals("")) {
                    setXorO(board.button_4, board.button_4Image);
                    TheWinner();
                }

            }
        });
        board.button_5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (board.button_5.getText().equals("")) {
                    setXorO(board.button_5, board.button_5Image);
                    TheWinner();
                }

            }
        });
        board.button_6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (board.button_6.getText().equals("")) {
                    setXorO(board.button_6, board.button_6Image);
                    TheWinner();
                }

            }
        });
        board.button_7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (board.button_7.getText().equals("")) {
                    setXorO(board.button_7, board.button_7Image);
                    TheWinner();
                }

            }
        });
        board.button_8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (board.button_8.getText().equals("")) {
                    setXorO(board.button_8, board.button_8Image);
                    TheWinner();
                }

            }
        });
        board.button_9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (board.button_9.getText().equals("")) {
                    setXorO(board.button_9, board.button_9Image);
                    TheWinner();
                }

            }
        });

    }

    private void setXorO(Button btn, ImageView iv) {
        if (board.turn % 2 == 0) {
            board.turn++;
            btn.setText("X");
            iv.setImage(new Image(getClass().getResource("/res/X.png").toExternalForm()));
            if (fileName != null) {
                int btnID = Integer.valueOf(btn.getId());
                btnID++;
                rec.writeFile("X," + btnID, fileName);
            }
        } else {
            board.turn++;
            btn.setText("O");
            iv.setImage(new Image(getClass().getResource("/res/O.png").toExternalForm()));
            if (fileName != null) {
                int btnID = Integer.valueOf(btn.getId());
                btnID++;
                rec.writeFile("O," + btnID, fileName);
            }
        }
    }

    private int XisWinner() {
        board.counter++;
        if (board.button_1.getText().equals("X") && board.button_2.getText().equals("X") && board.button_3.getText().equals("X")) {
            return 1;
        }
        if (board.button_4.getText().equals("X") && board.button_5.getText().equals("X") && board.button_6.getText().equals("X")) {
            return 1;
        }
        if (board.button_7.getText().equals("X") && board.button_8.getText().equals("X") && board.button_9.getText().equals("X")) {
            return 1;
        }
        if (board.button_1.getText().equals("X") && board.button_4.getText().equals("X") && board.button_7.getText().equals("X")) {
            return 1;
        }
        if (board.button_2.getText().equals("X") && board.button_5.getText().equals("X") && board.button_8.getText().equals("X")) {
            return 1;
        }
        if (board.button_3.getText().equals("X") && board.button_6.getText().equals("X") && board.button_9.getText().equals("X")) {
            return 1;
        }
        if (board.button_1.getText().equals("X") && board.button_5.getText().equals("X") && board.button_9.getText().equals("X")) {
            return 1;
        }
        if (board.button_3.getText().equals("X") && board.button_5.getText().equals("X") && board.button_7.getText().equals("X")) {
            return 1;
        } else {
            return 0;
        }
    }

    private int OisWinner() {
        if (board.button_1.getText().equals("O") && board.button_2.getText().equals("O") && board.button_3.getText().equals("O")) {
            return 1;
        }
        if (board.button_4.getText().equals("O") && board.button_5.getText().equals("O") && board.button_6.getText().equals("O")) {
            return 1;
        }
        if (board.button_7.getText().equals("O") && board.button_8.getText().equals("O") && board.button_9.getText().equals("O")) {
            return 1;
        }
        if (board.button_1.getText().equals("O") && board.button_4.getText().equals("O") && board.button_7.getText().equals("O")) {
            return 1;
        }
        if (board.button_2.getText().equals("O") && board.button_5.getText().equals("O") && board.button_8.getText().equals("O")) {
            return 1;
        }
        if (board.button_3.getText().equals("O") && board.button_6.getText().equals("O") && board.button_9.getText().equals("O")) {
            return 1;
        }
        if (board.button_1.getText().equals("O") && board.button_5.getText().equals("O") && board.button_9.getText().equals("O")) {
            return 1;
        }
        if (board.button_3.getText().equals("O") && board.button_5.getText().equals("O") && board.button_7.getText().equals("O")) {
            return 1;
        } else {
            return 0;
        }
    }

    private void navigateToWinner(String player1, int player1Avatar, String player2, int player2avatar, char winnerChar) {
        Parent root = null;
        ResultLogic win = new ResultLogic(player1, player1Avatar, player2, player2avatar, 1, sourceMode, winnerChar);
        root = win.result;
        Scene scene = new Scene(root);
        Stage stage = (Stage) board.backImageView.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    private void TheWinner() {
        int xResult = XisWinner();
        int oResult = OisWinner();
        if (xResult == 1) {
            navigateToWinner(board.user1NameText.getText(), board.player1Avatar, board.user2NameText.getText(), board.player2Avatar, 'x');
        } else if (oResult == 1) {
            navigateToWinner(board.user1NameText.getText(), board.player1Avatar, board.user2NameText.getText(), board.player2Avatar, 'o');
        }
        if (board.counter == 9 && xResult != 1 && oResult != 1) {
            Parent root = null;
            ResultLogic draw = new ResultLogic(board.user1NameText.getText(), board.player1Avatar, board.user2NameText.getText(), board.player2Avatar, 0, sourceMode, 'd');
            root = draw.result;
            Scene scene = new Scene(root);
            Stage stage = (Stage) board.backImageView.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }

}

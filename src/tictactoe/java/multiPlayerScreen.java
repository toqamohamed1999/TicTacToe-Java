package tictactoe.java;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import logic.SignIn;
import logic.OnlineGame;

public class multiPlayerScreen extends AnchorPane {

    protected final ImageView backButton;
    protected final ImageView profilePic;
    protected final Label multiplayerLabel;
    protected final Circle onlineCircle;
    protected final ImageView onlineImage;
    protected final Circle passAndPlayCircle;
    protected final ImageView passAndPlayImage;
    protected final Button passAndPlayButton;
    protected final Button onlineButton;
    protected final Pane playersNamesPane;
    protected final ImageView innerPaneBackButton;
    protected final Label enterNameLabel;
    protected final Label playerOneLabel;
    protected final Label playerTwoLabel;
    protected final ImageView playerOneAvatar;
    protected final ImageView playerTwoAvatar;
    protected final TextField playerOneNameField;
    protected final TextField playerTwoNameField;
    protected final Pane avatarChoicePane;
    protected final ImageView womanAvatar;
    protected final ImageView manAvatar;
    protected final Label selectAvatarLabel;
    protected final Button enterGameButton;
    protected final Pane errorMassagePane;
    protected final Label enterBothNamesLabel;
    protected final Button okButton;
    int oneOrTwo, playerOneAvatarNumber, playerTwoAvatarNumber;
    String playerOneName, playerTwoName;

    public multiPlayerScreen() {

        backButton = new ImageView();
        profilePic = new ImageView();
        multiplayerLabel = new Label();
        onlineCircle = new Circle();
        onlineImage = new ImageView();
        passAndPlayCircle = new Circle();
        passAndPlayImage = new ImageView();
        passAndPlayButton = new Button();
        onlineButton = new Button();
        playersNamesPane = new Pane();
        innerPaneBackButton = new ImageView();
        enterNameLabel = new Label();
        playerOneLabel = new Label();
        playerTwoLabel = new Label();
        playerOneAvatar = new ImageView();
        playerTwoAvatar = new ImageView();
        playerOneNameField = new TextField();
        playerTwoNameField = new TextField();
        avatarChoicePane = new Pane();
        womanAvatar = new ImageView();
        manAvatar = new ImageView();
        selectAvatarLabel = new Label();
        enterGameButton = new Button();
        errorMassagePane = new Pane();
        enterBothNamesLabel = new Label();
        okButton = new Button();
        oneOrTwo = 0;
        playerOneAvatarNumber = 1;
        playerTwoAvatarNumber = 1;

        setId("HomeAnchorPane");
        setPrefHeight(430.0);
        setPrefWidth(600.0);
        getStylesheets().add("/tictactoe/java/Styles.css");

        backButton.setFitHeight(53.0);
        backButton.setFitWidth(50.0);
        backButton.setLayoutX(38.0);
        backButton.setLayoutY(21.0);
        backButton.setPickOnBounds(true);
        backButton.setPreserveRatio(true);
        backButton.setImage(new Image(getClass().getResource("/res/back.png").toExternalForm()));
        backButton.setCursor(Cursor.HAND);
        backButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                TicTacToeJava.stage.setScene(new Scene(new HomeScreen()));

                TicTacToeJava.stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        System.exit(0);
                    }
                });
            }
        });

        profilePic.setFitHeight(57.0);
        profilePic.setFitWidth(66.0);
        profilePic.setLayoutX(520.0);
        profilePic.setLayoutY(21.0);
        profilePic.setPickOnBounds(true);
        profilePic.setPreserveRatio(true);
        profilePic.setImage(new Image(getClass().getResource("/res/record.png").toExternalForm()));
        profilePic.setCursor(Cursor.HAND);
        profilePic.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                TicTacToeJava.stage.setScene(new Scene(new RecordsListScreen()));

                TicTacToeJava.stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        System.exit(0);
                    }
                });
            }
        });

        multiplayerLabel.setLayoutX(162.0);
        multiplayerLabel.setLayoutY(38.0);
        multiplayerLabel.setPrefHeight(67.0);
        multiplayerLabel.setPrefWidth(301.0);
        multiplayerLabel.setText("MultiPlayer Mode");
        multiplayerLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        multiplayerLabel.setFont(new Font("Impact", 40.0));

        onlineCircle.setFill(javafx.scene.paint.Color.valueOf("#44a7a1"));
        onlineCircle.setLayoutX(422.0);
        onlineCircle.setLayoutY(210.0);
        onlineCircle.setRadius(51.0);
        onlineCircle.setStroke(javafx.scene.paint.Color.BLACK);
        onlineCircle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        onlineCircle.setCursor(Cursor.HAND);
        onlineCircle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                goToSignInScreen();
            }

        });

        onlineImage.setFitHeight(78.0);
        onlineImage.setFitWidth(81.0);
        onlineImage.setLayoutX(382.0);
        onlineImage.setLayoutY(173.0);
        onlineImage.setPickOnBounds(true);
        onlineImage.setPreserveRatio(true);
        onlineImage.setImage(new Image(getClass().getResource("/res/multiplayer.png").toExternalForm()));
        onlineImage.setCursor(Cursor.HAND);
        onlineImage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                goToSignInScreen();
            }

        });

        passAndPlayCircle.setFill(javafx.scene.paint.Color.valueOf("#44a7a1"));
        passAndPlayCircle.setLayoutX(193.0);
        passAndPlayCircle.setLayoutY(210.0);
        passAndPlayCircle.setRadius(51.0);
        passAndPlayCircle.setStroke(javafx.scene.paint.Color.BLACK);
        passAndPlayCircle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        passAndPlayCircle.setCursor(Cursor.HAND);
        passAndPlayCircle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                showPlayerNamesPane();
            }

        });

        passAndPlayImage.setFitHeight(78.0);
        passAndPlayImage.setFitWidth(78.0);
        passAndPlayImage.setLayoutX(155.0);
        passAndPlayImage.setLayoutY(172.0);
        passAndPlayImage.setPickOnBounds(true);
        passAndPlayImage.setPreserveRatio(true);
        passAndPlayImage.setImage(new Image(getClass().getResource("/res/battle.png").toExternalForm()));
        passAndPlayImage.setCursor(Cursor.HAND);
        passAndPlayImage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                showPlayerNamesPane();
            }

        });

        passAndPlayButton.setLayoutX(110.0);
        passAndPlayButton.setLayoutY(249.0);
        passAndPlayButton.setMnemonicParsing(false);
        passAndPlayButton.setPrefWidth(170.0);
        passAndPlayButton.setText("Pass & Play");
        passAndPlayButton.setTextFill(javafx.scene.paint.Color.RED);
        passAndPlayButton.setFont(new Font("Impact", 23.0));
        passAndPlayButton.setCursor(Cursor.HAND);
        passAndPlayButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showPlayerNamesPane();
            }
        });

        onlineButton.setLayoutX(335.0);
        onlineButton.setLayoutY(249.0);
        onlineButton.setMnemonicParsing(false);
        onlineButton.setPrefWidth(170.0);
        onlineButton.setText("Online");
        onlineButton.setTextFill(javafx.scene.paint.Color.RED);
        onlineButton.setFont(new Font("Impact", 23.0));
        onlineButton.setCursor(Cursor.HAND);
        onlineButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                goToSignInScreen();
            }
        });

        playersNamesPane.setId("enterNamesLayer");
        playersNamesPane.setLayoutX(103.0);
        playersNamesPane.setLayoutY(77.0);
        playersNamesPane.setPrefHeight(302.0);
        playersNamesPane.setPrefWidth(406.0);
        playersNamesPane.setVisible(false);

        innerPaneBackButton.setFitHeight(44.0);
        innerPaneBackButton.setFitWidth(36.0);
        innerPaneBackButton.setLayoutX(117.0);
        innerPaneBackButton.setLayoutY(88.0);
        innerPaneBackButton.setPickOnBounds(true);
        innerPaneBackButton.setPreserveRatio(true);
        innerPaneBackButton.setVisible(false);
        innerPaneBackButton.setImage(new Image(getClass().getResource("/res/back.png").toExternalForm()));
        innerPaneBackButton.setCursor(Cursor.HAND);
        innerPaneBackButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                hidePlayerNamesPane();
            }

        });

        enterNameLabel.setLayoutX(189.0);
        enterNameLabel.setLayoutY(83.0);
        enterNameLabel.setText("Enter Your Names");
        enterNameLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        enterNameLabel.setVisible(false);
        enterNameLabel.setFont(new Font("Impact", 36.0));

        playerOneLabel.setLayoutX(160.0);
        playerOneLabel.setLayoutY(138.0);
        playerOneLabel.setText("Player 1");
        playerOneLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        playerOneLabel.setVisible(false);
        playerOneLabel.setFont(new Font("Impact", 21.0));

        playerTwoLabel.setLayoutX(387.0);
        playerTwoLabel.setLayoutY(138.0);
        playerTwoLabel.setText("Player 2");
        playerTwoLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        playerTwoLabel.setVisible(false);
        playerTwoLabel.setFont(new Font("Impact", 21.0));

        playerOneAvatar.setFitHeight(102.0);
        playerOneAvatar.setFitWidth(94.0);
        playerOneAvatar.setLayoutX(146.0);
        playerOneAvatar.setLayoutY(165.0);
        playerOneAvatar.setPickOnBounds(true);
        playerOneAvatar.setPreserveRatio(true);
        playerOneAvatar.setVisible(false);
        playerOneAvatar.setImage(new Image(getClass().getResource("/res/man.png").toExternalForm()));
        playerOneAvatar.setCursor(Cursor.HAND);
        playerOneAvatar.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                oneOrTwo = 1;
                showAvatarChoicePane();
            }

        });

        playerTwoAvatar.setFitHeight(102.0);
        playerTwoAvatar.setFitWidth(94.0);
        playerTwoAvatar.setLayoutX(374.0);
        playerTwoAvatar.setLayoutY(165.0);
        playerTwoAvatar.setPickOnBounds(true);
        playerTwoAvatar.setPreserveRatio(true);
        playerTwoAvatar.setVisible(false);
        playerTwoAvatar.setImage(new Image(getClass().getResource("/res/man.png").toExternalForm()));
        playerTwoAvatar.setCursor(Cursor.HAND);
        playerTwoAvatar.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                oneOrTwo = 2;
                showAvatarChoicePane();
            }

        });

        playerOneNameField.setId("TextField");
        playerOneNameField.setLayoutX(112.0);
        playerOneNameField.setLayoutY(266.0);
        playerOneNameField.setPrefHeight(37.0);
        playerOneNameField.setPrefWidth(162.0);
        playerOneNameField.setVisible(false);
        playerOneNameField.setFont(new Font("Impact", 16.0));
        playerOneNameField.setCursor(Cursor.TEXT);

        playerTwoNameField.setId("TextField");
        playerTwoNameField.setLayoutX(338.0);
        playerTwoNameField.setLayoutY(266.0);
        playerTwoNameField.setPrefHeight(37.0);
        playerTwoNameField.setPrefWidth(162.0);
        playerTwoNameField.setVisible(false);
        playerTwoNameField.setFont(new Font("Impact", 16.0));
        playerTwoNameField.setCursor(Cursor.TEXT);

        avatarChoicePane.setId("genderSelectionLayer");
        avatarChoicePane.setLayoutX(174.0);
        avatarChoicePane.setLayoutY(133.0);
        avatarChoicePane.setPrefHeight(159.0);
        avatarChoicePane.setPrefWidth(278.0);
        avatarChoicePane.setVisible(false);

        womanAvatar.setFitHeight(115.0);
        womanAvatar.setFitWidth(102.0);
        womanAvatar.setLayoutX(331.0);
        womanAvatar.setLayoutY(181.0);
        womanAvatar.setPickOnBounds(true);
        womanAvatar.setPreserveRatio(true);
        womanAvatar.setVisible(false);
        womanAvatar.setImage(new Image(getClass().getResource("/res/woman.png").toExternalForm()));
        womanAvatar.setCursor(Cursor.HAND);
        womanAvatar.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (oneOrTwo == 1) {
                    playerOneAvatar.setImage(new Image(getClass().getResource("/res/woman.png").toExternalForm()));
                    playerOneAvatarNumber = 2;
                } else if (oneOrTwo == 2) {
                    playerTwoAvatar.setImage(new Image(getClass().getResource("/res/woman.png").toExternalForm()));
                    playerTwoAvatarNumber = 2;
                }
                hideAvatarChoicePane();
            }

        });

        manAvatar.setFitHeight(115.0);
        manAvatar.setFitWidth(102.0);
        manAvatar.setLayoutX(187.0);
        manAvatar.setLayoutY(181.0);
        manAvatar.setPickOnBounds(true);
        manAvatar.setPreserveRatio(true);
        manAvatar.setVisible(false);
        manAvatar.setImage(new Image(getClass().getResource("/res/man.png").toExternalForm()));
        manAvatar.setCursor(Cursor.HAND);
        manAvatar.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (oneOrTwo == 1) {
                    playerOneAvatar.setImage(new Image(getClass().getResource("/res/man.png").toExternalForm()));
                    playerOneAvatarNumber = 1;
                } else if (oneOrTwo == 2) {
                    playerTwoAvatar.setImage(new Image(getClass().getResource("/res/man.png").toExternalForm()));
                    playerTwoAvatarNumber = 1;
                }
                hideAvatarChoicePane();
            }

        });

        selectAvatarLabel.setLayoutX(235.0);
        selectAvatarLabel.setLayoutY(142.0);
        selectAvatarLabel.setText("Select your Avatar");
        selectAvatarLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        selectAvatarLabel.setVisible(false);
        selectAvatarLabel.setFont(new Font("Impact", 21.0));

        enterGameButton.setLayoutX(239.0);
        enterGameButton.setLayoutY(320.0);
        enterGameButton.setMnemonicParsing(false);
        enterGameButton.setText("Enter Game");
        enterGameButton.setTextFill(javafx.scene.paint.Color.RED);
        enterGameButton.setVisible(false);
        enterGameButton.setFont(new Font("Impact", 22.0));
        enterGameButton.setCursor(Cursor.HAND);
        enterGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (playerOneNameField.getText().equals("") || playerTwoNameField.getText().equals("")) {
                    errorMassagePane.setVisible(true);
                    enterBothNamesLabel.setVisible(true);
                    okButton.setVisible(true);
                } else {
                    playerOneName = playerOneNameField.getText();
                    playerTwoName = playerTwoNameField.getText();
                    MultiPlayer mp = new MultiPlayer(playerOneName, playerOneAvatarNumber, playerTwoName, playerTwoAvatarNumber);
                    TicTacToeJava.stage.setScene(new Scene(mp.board));

                    TicTacToeJava.stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                        @Override
                        public void handle(WindowEvent event) {
                            System.exit(0);
                        }
                    });
                }
            }
        });

        errorMassagePane.setId("errorMassagePane");
        errorMassagePane.setLayoutX(140.0);
        errorMassagePane.setLayoutY(152.0);
        errorMassagePane.setPrefHeight(146.0);
        errorMassagePane.setPrefWidth(336.0);
        errorMassagePane.setVisible(false);

        enterBothNamesLabel.setLayoutX(169.0);
        enterBothNamesLabel.setLayoutY(172.0);
        enterBothNamesLabel.setText("Please Enter both Players Names");
        enterBothNamesLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        enterBothNamesLabel.setVisible(false);
        enterBothNamesLabel.setFont(new Font("Impact", 21.0));

        okButton.setLayoutX(265.0);
        okButton.setLayoutY(240.0);
        okButton.setMnemonicParsing(false);
        okButton.setPrefWidth(80.0);
        okButton.setText("OK");
        okButton.setTextFill(javafx.scene.paint.Color.valueOf("#fc0000"));
        okButton.setVisible(false);
        okButton.setFont(new Font("Impact", 21.0));
        okButton.setCursor(Cursor.HAND);
        okButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                errorMassagePane.setVisible(false);
                enterBothNamesLabel.setVisible(false);
                okButton.setVisible(false);
            }
        });

        getChildren().add(backButton);
        getChildren().add(profilePic);
        getChildren().add(multiplayerLabel);
        getChildren().add(onlineCircle);
        getChildren().add(onlineImage);
        getChildren().add(passAndPlayCircle);
        getChildren().add(passAndPlayImage);
        getChildren().add(passAndPlayButton);
        getChildren().add(onlineButton);
        getChildren().add(playersNamesPane);
        getChildren().add(innerPaneBackButton);
        getChildren().add(enterNameLabel);
        getChildren().add(playerOneLabel);
        getChildren().add(playerTwoLabel);
        getChildren().add(playerOneAvatar);
        getChildren().add(playerTwoAvatar);
        getChildren().add(playerOneNameField);
        getChildren().add(playerTwoNameField);
        getChildren().add(avatarChoicePane);
        getChildren().add(womanAvatar);
        getChildren().add(manAvatar);
        getChildren().add(selectAvatarLabel);
        getChildren().add(enterGameButton);
        getChildren().add(errorMassagePane);
        getChildren().add(enterBothNamesLabel);
        getChildren().add(okButton);

    }

    void hidePlayerNamesPane() {
        playersNamesPane.setVisible(false);
        innerPaneBackButton.setVisible(false);
        enterNameLabel.setVisible(false);
        playerOneLabel.setVisible(false);
        playerTwoLabel.setVisible(false);
        playerOneAvatar.setVisible(false);
        playerTwoAvatar.setVisible(false);
        playerOneNameField.setVisible(false);
        playerTwoNameField.setVisible(false);
        enterGameButton.setVisible(false);
        errorMassagePane.setVisible(false);
        enterBothNamesLabel.setVisible(false);
        okButton.setVisible(false);
    }

    void showPlayerNamesPane() {
        playersNamesPane.setVisible(true);
        innerPaneBackButton.setVisible(true);
        enterNameLabel.setVisible(true);
        playerOneLabel.setVisible(true);
        playerTwoLabel.setVisible(true);
        playerOneAvatar.setVisible(true);
        playerTwoAvatar.setVisible(true);
        playerOneNameField.setVisible(true);
        playerTwoNameField.setVisible(true);
        enterGameButton.setVisible(true);
    }

    void hideAvatarChoicePane() {
        avatarChoicePane.setVisible(false);
        womanAvatar.setVisible(false);
        manAvatar.setVisible(false);
        selectAvatarLabel.setVisible(false);
    }

    void showAvatarChoicePane() {
        avatarChoicePane.setVisible(true);

        womanAvatar.setVisible(true);
        manAvatar.setVisible(true);
        selectAvatarLabel.setVisible(true);
    }

    void goToSignInScreen() {

        SignIn signIn = new SignIn();
        TicTacToeJava.stage.setScene(new Scene(signIn.signInScreenBase));

        TicTacToeJava.stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }
        });
    }
}

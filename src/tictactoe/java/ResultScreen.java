package tictactoe.java;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class ResultScreen extends AnchorPane {

    protected final ImageView resultScreenBackGround;
    protected final ImageView resultPic;
    protected final Label resultLabel;
    protected final Button playAgainButton;
    protected final Button exitGameButton;
    protected final Pane player1CardPane;
    protected final Pane player2CardPane;
    protected final ImageView player1Pic;
    protected final Label player1Name;
    protected final Label player1State;
    protected final ImageView player2Pic;
    protected final Label player2Name;
    protected final Label player2State;
    protected final ImageView homeButton;

    public ResultScreen() {

        resultScreenBackGround = new ImageView();
        resultPic = new ImageView();
        resultLabel = new Label();
        playAgainButton = new Button();
        exitGameButton = new Button();
        player1CardPane = new Pane();
        player2CardPane = new Pane();
        player1Pic = new ImageView();
        player1Name = new Label();
        player1State = new Label();
        player2Pic = new ImageView();
        player2Name = new Label();
        player2State = new Label();
        homeButton = new ImageView();

        setId("AnchorPane");
        setPrefHeight(430.0);
        setPrefWidth(600.0);
        getStylesheets().add("/tictactoe/java/Styles.css");

        resultScreenBackGround.setFitHeight(438.0);
        resultScreenBackGround.setFitWidth(630.0);
        resultScreenBackGround.setLayoutX(-6.0);
        resultScreenBackGround.setLayoutY(-1.0);
        resultScreenBackGround.setPickOnBounds(true);
        resultScreenBackGround.setImage(new Image(getClass().getResource("/res/BackGround.JPG").toExternalForm()));

        resultPic.setFitHeight(254.0);
        resultPic.setFitWidth(273.0);
        resultPic.setLayoutX(175.0);
        resultPic.setLayoutY(86.0);
        resultPic.setPickOnBounds(true);

        resultLabel.setId("textLabel");
        resultLabel.setLayoutX(257.0);
        resultLabel.setLayoutY(21.0);
        resultLabel.setText("Winner");
        resultLabel.setTextFill(javafx.scene.paint.Color.RED);
        resultLabel.setFont(new Font("Impact", 36.0));

        playAgainButton.setLayoutX(108.0);
        playAgainButton.setLayoutY(353.0);
        playAgainButton.setMnemonicParsing(false);
        playAgainButton.getStylesheets().add("/tictactoe/java/Styles.css");
        playAgainButton.setText("Play Again");
        playAgainButton.setTextFill(javafx.scene.paint.Color.RED);
        playAgainButton.setFont(new Font("Impact", 24.0));
        playAgainButton.setCursor(Cursor.HAND);
        
        exitGameButton.setLayoutX(385.0);
        exitGameButton.setLayoutY(353.0);
        exitGameButton.setMnemonicParsing(false);
        exitGameButton.getStylesheets().add("/tictactoe/java/Styles.css");
        exitGameButton.setText("Exit Game");
        exitGameButton.setTextFill(javafx.scene.paint.Color.RED);
        exitGameButton.setFont(new Font("Impact", 24.0));
        exitGameButton.setCursor(Cursor.HAND);
       
        player1CardPane.setId("profileResultCard");
        player1CardPane.setLayoutX(36.0);
        player1CardPane.setLayoutY(141.0);
        player1CardPane.setPrefHeight(163.0);
        player1CardPane.setPrefWidth(109.0);
        player1CardPane.getStylesheets().add("/tictactoe/java/Styles.css");

        player2CardPane.setId("profileResultCard");
        player2CardPane.setLayoutX(476.0);
        player2CardPane.setLayoutY(141.0);
        player2CardPane.setPrefHeight(163.0);
        player2CardPane.setPrefWidth(109.0);
        player2CardPane.getStylesheets().add("/tictactoe/java/Styles.css");

        player1Pic.setFitHeight(69.0);
        player1Pic.setFitWidth(86.0);
        player1Pic.setId("profilePic");
        player1Pic.setLayoutX(55.0);
        player1Pic.setLayoutY(187.0);
        player1Pic.setPickOnBounds(true);
        player1Pic.setPreserveRatio(true);
        
        player1Name.setId("textLabel");
        player1Name.setLayoutX(57.0);
        player1Name.setLayoutY(160.0);
        player1Name.setText("");
        player1Name.setTextFill(javafx.scene.paint.Color.WHITE);
        player1Name.setFont(new Font("Impact", 21.0));

        player1State.setLayoutX(66.0);
        player1State.setLayoutY(256.0);
        player1State.setText("Loser");
        player1State.setTextFill(javafx.scene.paint.Color.WHITE);
        player1State.setFont(new Font("Impact", 21.0));

        player2Pic.setFitHeight(69.0);
        player2Pic.setFitWidth(86.0);
        player2Pic.setId("profilePic");
        player2Pic.setLayoutX(497.0);
        player2Pic.setLayoutY(187.0);
        player2Pic.setPickOnBounds(true);
        player2Pic.setPreserveRatio(true);
       
     //   player2Name.setAlignment(javafx.geometry.Pos.CENTER);
        player2Name.setId("textLabel");
        player2Name.setLayoutX(497.0);
        player2Name.setLayoutY(159.0);
        player2Name.setText("");
        player2Name.setTextFill(javafx.scene.paint.Color.WHITE);
        player2Name.setFont(new Font("Impact", 21.0));
        player2Name.setTextAlignment(TextAlignment.JUSTIFY);
        player2Name.setWrapText(true);

        player2State.setLayoutX(499.0);
        player2State.setLayoutY(256.0);
        player2State.setText("Winner");
        player2State.setTextFill(javafx.scene.paint.Color.WHITE);
        player2State.setFont(new Font("Impact", 21.0));

        homeButton.setFitHeight(45.0);
        homeButton.setFitWidth(47.0);
        homeButton.setLayoutX(287.0);
        homeButton.setLayoutY(353.0);
        homeButton.setPickOnBounds(true);
        homeButton.setPreserveRatio(true);
        homeButton.setImage(new Image(getClass().getResource("/res/home.png").toExternalForm()));
        homeButton.setCursor(Cursor.HAND);
        
        getChildren().add(resultScreenBackGround);
        getChildren().add(resultPic);
        getChildren().add(resultLabel);
        getChildren().add(playAgainButton);
        getChildren().add(exitGameButton);
        getChildren().add(player1CardPane);
        getChildren().add(player2CardPane);
        getChildren().add(player1Pic);
        getChildren().add(player1Name);
        getChildren().add(player1State);
        getChildren().add(player2Pic);
        getChildren().add(player2Name);
        getChildren().add(player2State);
        getChildren().add(homeButton);

    }
}

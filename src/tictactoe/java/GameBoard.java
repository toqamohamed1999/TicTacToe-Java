package tictactoe.java;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class GameBoard extends AnchorPane {

    protected final ImageView user2ImageView;
    protected final ImageView user1ImageView;
    protected final Text user1NameText;
    protected final Text user2NameText;
    protected final Button recordIndicatorButton;
    protected final ImageView recordIndicatorImageView;
    protected final ImageView backImageView;
    protected final ImageView logoImageView;
    protected final Button oButton;
    protected final ImageView oImageView;
    protected final Button xButton;
    protected final ImageView xImageView;
    protected final ImageView xoBoard;
    protected final Button recordGameButton;
    protected final ImageView button_1Image;
    protected final ImageView button_2Image;
    protected final ImageView button_3Image;
    protected final ImageView button_4Image;
    protected final ImageView button_5Image;
    protected final ImageView button_6Image;
    protected final ImageView button_7Image;
    protected final ImageView button_8Image;
    protected final ImageView button_9Image;
    protected final Button button_1;
    protected final Button button_2;
    protected final Button button_3;
    protected final Button button_4;
    protected final Button button_5;
    protected final Button button_6;
    protected final Button button_7;
    protected final Button button_8;
    protected final Button button_9;
    int turn,player1Avatar,player2Avatar,counter;


    public GameBoard(String playerOneName,int playerOneAvatarNumber,String playerTwoName,int playerTwoAvatarNumber) {
       
        user2ImageView = new ImageView();
        user1ImageView = new ImageView();
        user1NameText = new Text();
        user2NameText = new Text();
        recordIndicatorButton = new Button();
        recordIndicatorImageView = new ImageView();
        backImageView = new ImageView();
        logoImageView = new ImageView();
        oButton = new Button();
        oImageView = new ImageView();
        xButton = new Button();
        xImageView = new ImageView();
        xoBoard = new ImageView();
        recordGameButton = new Button();
        button_1Image = new ImageView();
        button_2Image = new ImageView();
        button_3Image = new ImageView();
        button_4Image = new ImageView();
        button_5Image = new ImageView();
        button_6Image = new ImageView();
        button_7Image = new ImageView();
        button_8Image = new ImageView();
        button_9Image = new ImageView();
        button_1 = new Button();
        button_2 = new Button();
        button_3 = new Button();
        button_4 = new Button();
        button_5 = new Button();
        button_6 = new Button();
        button_7 = new Button();
        button_8 = new Button();
        button_9 = new Button();
        turn=2;
        player1Avatar=playerOneAvatarNumber;
        player2Avatar=playerTwoAvatarNumber;
        counter=0;

        setId("AnchorPane");
        setPrefHeight(430.0);
        setPrefWidth(600.0);
        getStylesheets().add("/tictactoe/java/Styles.css");

        user2ImageView.setFitHeight(87.0);
        user2ImageView.setFitWidth(94.0);
        user2ImageView.setId("user2ImageView");
        user2ImageView.setLayoutX(475.0);
        user2ImageView.setLayoutY(177.0);
        user2ImageView.setPickOnBounds(true);
        user2ImageView.setPreserveRatio(true);
        if(playerTwoAvatarNumber==1)user2ImageView.setImage(new Image(getClass().getResource("/res/man.png").toExternalForm()));
        else if(playerTwoAvatarNumber==2)user2ImageView.setImage(new Image(getClass().getResource("/res/woman.png").toExternalForm()));
        else if(playerTwoAvatarNumber==3)user2ImageView.setImage(new Image(getClass().getResource("/res/Easy.png").toExternalForm()));
     
        user1ImageView.setFitHeight(87.0);
        user1ImageView.setFitWidth(94.0);
        user1ImageView.setId("user1ImageView");
        user1ImageView.setLayoutX(43.0);
        user1ImageView.setLayoutY(177.0);
        user1ImageView.setPickOnBounds(true);
        user1ImageView.setPreserveRatio(true);
        if(playerOneAvatarNumber==1)user1ImageView.setImage(new Image(getClass().getResource("/res/man.png").toExternalForm()));
        else if(playerOneAvatarNumber==2)user1ImageView.setImage(new Image(getClass().getResource("/res/woman.png").toExternalForm()));
        else if(playerOneAvatarNumber==3)user1ImageView.setImage(new Image(getClass().getResource("/res/Easy.png").toExternalForm()));

        user1NameText.setFill(javafx.scene.paint.Color.WHITE);
        user1NameText.setId("user1Text");
        user1NameText.setLayoutX(61.0);
        user1NameText.setLayoutY(168.0);
        user1NameText.setText(playerOneName);
        user1NameText.setFont(new Font("Impact", 20.0));

        user2NameText.setFill(javafx.scene.paint.Color.WHITE);
        user2NameText.setId("user2Text");
        user2NameText.setLayoutX(490.0);
        user2NameText.setLayoutY(168.0);
        user2NameText.setText(playerTwoName);
        user2NameText.setFont(new Font("Impact", 20.0));

        recordIndicatorButton.setId("recordIndicatorButton");
        recordIndicatorButton.setLayoutX(510.0);
        recordIndicatorButton.setLayoutY(23.0);
        recordIndicatorButton.setMnemonicParsing(false);
        recordIndicatorButton.setVisible(false);
        recordIndicatorButton.setPrefHeight(25.0);
        recordIndicatorButton.setPrefWidth(71.0);

        recordIndicatorImageView.setFitHeight(50.0);
        recordIndicatorImageView.setFitWidth(50.0);
        recordIndicatorImageView.setId("recordImageView");
        recordIndicatorImageView.setLayoutX(520.0);
        recordIndicatorImageView.setLayoutY(17.0);
        recordIndicatorImageView.setPickOnBounds(true);
        recordIndicatorImageView.setVisible(false);        
        recordIndicatorImageView.setImage(new Image(getClass().getResource("/res/record.png").toExternalForm()));
      
        backImageView.setFitHeight(53.0);
        backImageView.setFitWidth(50.0);
        backImageView.setId("backImageView");
        backImageView.setLayoutX(30.0);
        backImageView.setLayoutY(21.0);
        backImageView.setPickOnBounds(true);
        backImageView.setPreserveRatio(true);
        backImageView.setImage(new Image(getClass().getResource("/res/back.png").toExternalForm()));
        backImageView.setCursor(Cursor.HAND);
       
        logoImageView.setFitHeight(83.0);
        logoImageView.setFitWidth(373.0);
        logoImageView.setId("logoImageView");
        logoImageView.setLayoutX(159.0);
        logoImageView.setLayoutY(30.0);
        logoImageView.setPickOnBounds(true);
        logoImageView.setImage(new Image(getClass().getResource("/res/HorizontalLogo.png").toExternalForm()));

        oButton.setId("oButton");
        oButton.setLayoutX(463.0);
        oButton.setLayoutY(252.0);
        oButton.setMnemonicParsing(false);
        oButton.setPrefHeight(40.0);
        oButton.setPrefWidth(105.0);

        oImageView.setFitHeight(33.0);
        oImageView.setFitWidth(27.0);
        oImageView.setId("oImageView");
        oImageView.setLayoutX(504.0);
        oImageView.setLayoutY(256.0);
        oImageView.setPickOnBounds(true);
        oImageView.setPreserveRatio(true);
        oImageView.setImage(new Image(getClass().getResource("/res/O.png").toExternalForm()));

        xButton.setId("xButton");
        xButton.setLayoutX(32.0);
        xButton.setLayoutY(252.0);
        xButton.setMnemonicParsing(false);
        xButton.setPrefHeight(40.0);
        xButton.setPrefWidth(105.0);

        xImageView.setFitHeight(33.0);
        xImageView.setFitWidth(22.0);
        xImageView.setId("xImageView");
        xImageView.setLayoutX(73.0);
        xImageView.setLayoutY(256.0);
        xImageView.setPickOnBounds(true);
        xImageView.setPreserveRatio(true);
        xImageView.setImage(new Image(getClass().getResource("/res/X.png").toExternalForm()));

        xoBoard.setFitHeight(229.0);
        xoBoard.setFitWidth(296.0);
        xoBoard.setLayoutX(152.0);
        xoBoard.setLayoutY(134.0);
        xoBoard.setPickOnBounds(true);
        xoBoard.setImage(new Image(getClass().getResource("/res/OXBackground.png").toExternalForm()));

        recordGameButton.setId("recordGameButton");
        recordGameButton.setLayoutX(221.0);
        recordGameButton.setLayoutY(378.0);
        recordGameButton.setMnemonicParsing(false);
        recordGameButton.setPrefHeight(40.0);
        recordGameButton.setPrefWidth(160.0);
        recordGameButton.setText("Record Game");
        recordGameButton.setTextFill(javafx.scene.paint.Color.valueOf("#e81111"));
        recordGameButton.setFont(new Font("Impact", 21.0));
        recordGameButton.setCursor(Cursor.HAND);
      
        button_1Image.setFitHeight(45.0);
        button_1Image.setFitWidth(40.0);
        button_1Image.setLayoutX(185.0);
        button_1Image.setLayoutY(153.0);
        button_1Image.setPickOnBounds(true);
        button_1Image.setCursor(Cursor.HAND);

        button_2Image.setFitHeight(45.0);
        button_2Image.setFitWidth(40.0);
        button_2Image.setLayoutX(279.0);
        button_2Image.setLayoutY(152.0);
        button_2Image.setPickOnBounds(true);
        button_2Image.setCursor(Cursor.HAND);

        button_3Image.setFitHeight(45.0);
        button_3Image.setFitWidth(40.0);
        button_3Image.setLayoutX(374.0);
        button_3Image.setLayoutY(152.0);
        button_3Image.setPickOnBounds(true);
        button_3Image.setCursor(Cursor.HAND);

        button_4Image.setFitHeight(45.0);
        button_4Image.setFitWidth(40.0);
        button_4Image.setLayoutX(185.0);
        button_4Image.setLayoutY(225.0);
        button_4Image.setPickOnBounds(true);
        button_4Image.setCursor(Cursor.HAND);

        button_5Image.setFitHeight(45.0);
        button_5Image.setFitWidth(40.0);
        button_5Image.setLayoutX(279.0);
        button_5Image.setLayoutY(227.0);
        button_5Image.setPickOnBounds(true);
        button_5Image.setCursor(Cursor.HAND);

        button_6Image.setFitHeight(45.0);
        button_6Image.setFitWidth(40.0);
        button_6Image.setLayoutX(373.0);
        button_6Image.setLayoutY(227.0);
        button_6Image.setPickOnBounds(true);
        button_6Image.setCursor(Cursor.HAND);

        button_7Image.setFitHeight(45.0);
        button_7Image.setFitWidth(40.0);
        button_7Image.setLayoutX(185.0);
        button_7Image.setLayoutY(301.0);
        button_7Image.setPickOnBounds(true);
        button_7Image.setCursor(Cursor.HAND);

        button_8Image.setFitHeight(45.0);
        button_8Image.setFitWidth(40.0);
        button_8Image.setLayoutX(280.0);
        button_8Image.setLayoutY(299.0);
        button_8Image.setPickOnBounds(true);
        button_8Image.setCursor(Cursor.HAND);

        button_9Image.setFitHeight(45.0);
        button_9Image.setFitWidth(40.0);
        button_9Image.setLayoutX(375.0);
        button_9Image.setLayoutY(299.0);
        button_9Image.setPickOnBounds(true);
        button_9Image.setCursor(Cursor.HAND);

        button_1.setLayoutX(170.0);
        button_1.setLayoutY(138.0);
        button_1.setMnemonicParsing(false);
        button_1.setOpacity(0.0);
        button_1.setPrefHeight(70.0);
        button_1.setPrefWidth(70.0);
        button_1.setCursor(Cursor.HAND);
        button_1.setId(0+"");
       
        button_2.setLayoutX(265.0);
        button_2.setLayoutY(138.0);
        button_2.setMnemonicParsing(false);
        button_2.setOpacity(0.0);
        button_2.setPrefHeight(70.0);
        button_2.setPrefWidth(70.0);
        button_2.setCursor(Cursor.HAND);
        button_2.setId(1+"");

        
        button_3.setLayoutX(359.0);
        button_3.setLayoutY(140.0);
        button_3.setMnemonicParsing(false);
        button_3.setOpacity(0.0);
        button_3.setPrefHeight(70.0);
        button_3.setPrefWidth(70.0);
        button_3.setCursor(Cursor.HAND);
        button_3.setId(2+"");

        button_4.setLayoutX(170.0);
        button_4.setLayoutY(212.0);
        button_4.setMnemonicParsing(false);
        button_4.setOpacity(0.0);
        button_4.setPrefHeight(70.0);
        button_4.setPrefWidth(70.0);
        button_4.setCursor(Cursor.HAND);
        button_4.setId(3+"");

       
        button_5.setLayoutX(264.0);
        button_5.setLayoutY(212.0);
        button_5.setMnemonicParsing(false);
        button_5.setOpacity(0.0);
        button_5.setPrefHeight(70.0);
        button_5.setPrefWidth(70.0);
        button_5.setCursor(Cursor.HAND);
        button_5.setId(4+"");

        button_6.setLayoutX(358.0);
        button_6.setLayoutY(212.0);
        button_6.setMnemonicParsing(false);
        button_6.setOpacity(0.0);
        button_6.setPrefHeight(70.0);
        button_6.setPrefWidth(70.0);
        button_6.setCursor(Cursor.HAND);
        button_6.setId(5+"");
        
        button_7.setLayoutX(170.0);
        button_7.setLayoutY(287.0);
        button_7.setMnemonicParsing(false);
        button_7.setOpacity(0.0);
        button_7.setPrefHeight(70.0);
        button_7.setPrefWidth(70.0);
        button_7.setCursor(Cursor.HAND);
        button_7.setId(6+"");

        
        button_8.setLayoutX(265.0);
        button_8.setLayoutY(284.0);
        button_8.setMnemonicParsing(false);
        button_8.setOpacity(0.0);
        button_8.setPrefHeight(70.0);
        button_8.setPrefWidth(70.0);
        button_8.setCursor(Cursor.HAND);
        button_8.setId(7+"");
 
        button_9.setLayoutX(359.0);
        button_9.setLayoutY(284.0);
        button_9.setMnemonicParsing(false);
        button_9.setOpacity(0.0);
        button_9.setPrefHeight(70.0);
        button_9.setPrefWidth(70.0);
        button_9.setCursor(Cursor.HAND);
        button_9.setId(8+"");
       
        getChildren().add(user2ImageView);
        getChildren().add(user1ImageView);
        getChildren().add(user1NameText);
        getChildren().add(user2NameText);
        getChildren().add(recordIndicatorButton);
        getChildren().add(recordIndicatorImageView);
        getChildren().add(backImageView);
        getChildren().add(logoImageView);
        getChildren().add(oButton);
        getChildren().add(oImageView);
        getChildren().add(xButton);
        getChildren().add(xImageView);
        getChildren().add(xoBoard);
        getChildren().add(recordGameButton);
        getChildren().add(button_1Image);
        getChildren().add(button_2Image);
        getChildren().add(button_3Image);
        getChildren().add(button_4Image);
        getChildren().add(button_5Image);
        getChildren().add(button_6Image);
        getChildren().add(button_7Image);
        getChildren().add(button_8Image);
        getChildren().add(button_9Image);
        getChildren().add(button_1);
        getChildren().add(button_2);
        getChildren().add(button_3);
        getChildren().add(button_4);
        getChildren().add(button_5);
        getChildren().add(button_6);
        getChildren().add(button_7);
        getChildren().add(button_8);
        getChildren().add(button_9);
    }
}

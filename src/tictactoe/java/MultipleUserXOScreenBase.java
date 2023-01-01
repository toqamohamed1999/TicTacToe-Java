package tictactoe.java;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MultipleUserXOScreenBase extends AnchorPane {

    protected final ImageView user2ImageView;
    protected final ImageView user1ImageView;
    protected final Text user1NameText;
    protected final Text user2NameText;
    protected final Button recordIndicatorButton;
    protected final ImageView recordIndicatorImageView;
    protected final Button recordGameButton;
    protected final ImageView backImageView;
    protected final ImageView logoImageView;
    protected final Button oButton;
    protected final ImageView oImageView;
    protected final Button xButton;
    protected final ImageView xImageView;
    protected final Button button_1;
    protected final Button button_2;
    protected final Button button_3;
    protected final Button button_4;
    protected final Button button_5;
    protected final Button button_6;
    protected final Button button_7;
    protected final Button button_8;
    protected final Button button_9;
    int turn;
    
    // 1 2 3 
    // 4 5 6
    // 7 8 9
    
    public MultipleUserXOScreenBase() {

        user2ImageView = new ImageView();
        user1ImageView = new ImageView();
        user1NameText = new Text();
        user2NameText = new Text();
        recordIndicatorButton = new Button();
        recordIndicatorImageView = new ImageView();
        recordGameButton = new Button();
        backImageView = new ImageView();
        logoImageView = new ImageView();
        oButton = new Button();
        oImageView = new ImageView();
        xButton = new Button();
        xImageView = new ImageView();
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

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        getStylesheets().add("/tictactoe/java/Styles.css");

        user2ImageView.setFitHeight(87.0);
        user2ImageView.setFitWidth(94.0);
        user2ImageView.setId("user2ImageView");
        user2ImageView.setLayoutX(479.0);
        user2ImageView.setLayoutY(148.0);
        user2ImageView.setPickOnBounds(true);
        user2ImageView.setPreserveRatio(true);
        user2ImageView.setImage(new Image(getClass().getResource("/res/profile.png").toExternalForm()));

        user1ImageView.setFitHeight(87.0);
        user1ImageView.setFitWidth(94.0);
        user1ImageView.setId("user1ImageView");
        user1ImageView.setLayoutX(43.0);
        user1ImageView.setLayoutY(148.0);
        user1ImageView.setPickOnBounds(true);
        user1ImageView.setPreserveRatio(true);
        user1ImageView.setImage(new Image(getClass().getResource("/res/profile.png").toExternalForm()));

        user1NameText.setFill(javafx.scene.paint.Color.WHITE);
        user1NameText.setId("user1Text");
        user1NameText.setLayoutX(61.0);
        user1NameText.setLayoutY(138.0);
        user1NameText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        user1NameText.setStrokeWidth(0.0);
        user1NameText.setText("User1");
        user1NameText.setWrappingWidth(51.999998331069946);
        user1NameText.setFont(new Font("Impact", 20.0));

        user2NameText.setFill(javafx.scene.paint.Color.WHITE);
        user2NameText.setId("user2Text");
        user2NameText.setLayoutX(494.0);
        user2NameText.setLayoutY(137.0);
        user2NameText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        user2NameText.setStrokeWidth(0.0);
        user2NameText.setText("User2");
        user2NameText.setWrappingWidth(51.999998331069946);
        user2NameText.setFont(new Font("Impact", 20.0));

        recordIndicatorButton.setId("recordIndicatorButton");
        recordIndicatorButton.setLayoutX(520.0);
        recordIndicatorButton.setLayoutY(23.0);
        recordIndicatorButton.setMnemonicParsing(false);
        recordIndicatorButton.setPrefHeight(25.0);
        recordIndicatorButton.setPrefWidth(71.0);

        recordIndicatorImageView.setFitHeight(50.0);
        recordIndicatorImageView.setFitWidth(52.0);
        recordIndicatorImageView.setId("recordImageView");
        recordIndicatorImageView.setLayoutX(530.0);
        recordIndicatorImageView.setLayoutY(11.0);
        recordIndicatorImageView.setPickOnBounds(true);
        recordIndicatorImageView.setPreserveRatio(true);
        recordIndicatorImageView.setImage(new Image(getClass().getResource("/res/record.png").toExternalForm()));

        recordGameButton.setId("recordGameButton");
        recordGameButton.setLayoutX(240.0);
        recordGameButton.setLayoutY(340.0);
        recordGameButton.setMnemonicParsing(false);
        recordGameButton.setPrefHeight(25.0);
        recordGameButton.setPrefWidth(120.0);
        recordGameButton.setText("Record Game");
        recordGameButton.setTextFill(javafx.scene.paint.Color.valueOf("#e81111"));
        recordGameButton.setFont(new Font("Impact", 14.0));
        recordGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                recordIndicatorImageView.setVisible(true);
                recordIndicatorButton.setVisible(true);
            }
        });

        backImageView.setFitHeight(40.0);
        backImageView.setFitWidth(83.0);
        backImageView.setId("backImageView");
        backImageView.setLayoutX(14.0);
        backImageView.setLayoutY(15.0);
        backImageView.setPickOnBounds(true);
        backImageView.setPreserveRatio(true);
        backImageView.setImage(new Image(getClass().getResource("/res/back.png").toExternalForm()));
        backImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Parent root=null;
                root = new multiPlayerScreen();
                Scene scene = new Scene(root);
                Stage stage = (Stage) backImageView.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
        });

        logoImageView.setFitHeight(75.0);
        logoImageView.setFitWidth(304.0);
        logoImageView.setId("logoImageView");
        logoImageView.setLayoutX(187.0);
        logoImageView.setLayoutY(22.0);
        logoImageView.setPickOnBounds(true);
        logoImageView.setPreserveRatio(true);
        logoImageView.setImage(new Image(getClass().getResource("/res/Horizontal.png").toExternalForm()));

        oButton.setId("oButton");
        oButton.setLayoutX(467.0);
        oButton.setLayoutY(222.0);
        oButton.setMnemonicParsing(false);
        oButton.setPrefHeight(40.0);
        oButton.setPrefWidth(105.0);

        oImageView.setFitHeight(33.0);
        oImageView.setFitWidth(27.0);
        oImageView.setId("oImageView");
        oImageView.setLayoutX(508.0);
        oImageView.setLayoutY(226.0);
        oImageView.setPickOnBounds(true);
        oImageView.setPreserveRatio(true);
        oImageView.setImage(new Image(getClass().getResource("/res/O.png").toExternalForm()));

        xButton.setId("xButton");
        xButton.setLayoutX(32.0);
        xButton.setLayoutY(222.0);
        xButton.setMnemonicParsing(false);
        xButton.setPrefHeight(40.0);
        xButton.setPrefWidth(105.0);

        xImageView.setFitHeight(33.0);
        xImageView.setFitWidth(22.0);
        xImageView.setId("xImageView");
        xImageView.setLayoutX(73.0);
        xImageView.setLayoutY(226.0);
        xImageView.setPickOnBounds(true);
        xImageView.setPreserveRatio(true);
        xImageView.setImage(new Image(getClass().getResource("/res/X.png").toExternalForm()));

        button_1.setLayoutX(185.0);
        button_1.setLayoutY(160.0);
        button_1.setMnemonicParsing(false);
        button_1.setPrefHeight(31.0);
        button_1.setPrefWidth(60.0);
        button_1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(button_1.getText().equals("")){
                    setXorO(button_1);
                    TheWinner();
                }
                
            }
        });

        button_2.setLayoutX(270.0);
        button_2.setLayoutY(160.0);
        button_2.setMnemonicParsing(false);
        button_2.setPrefHeight(31.0);
        button_2.setPrefWidth(60.0);
        button_2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(button_2.getText().equals("")){
                    setXorO(button_2);
                    TheWinner();
                }   
            }
        });

        button_3.setLayoutX(355.0);
        button_3.setLayoutY(160.0);
        button_3.setMnemonicParsing(false);
        button_3.setPrefHeight(31.0);
        button_3.setPrefWidth(60.0);
        button_3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(button_3.getText().equals("")){
                    setXorO(button_3);
                    TheWinner();
                }
                
            }
        });

        button_4.setLayoutX(185.0);
        button_4.setLayoutY(200.0);
        button_4.setMnemonicParsing(false);
        button_4.setPrefHeight(31.0);
        button_4.setPrefWidth(60.0);
        button_4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(button_4.getText().equals("")){
                    setXorO(button_4);
                    TheWinner();
                }
                
            }
        });

        button_5.setLayoutX(270.0);
        button_5.setLayoutY(200.0);
        button_5.setMnemonicParsing(false);
        button_5.setPrefHeight(31.0);
        button_5.setPrefWidth(60.0);
        button_5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(button_5.getText().equals("")){
                    setXorO(button_5);
                    TheWinner();
                }
                
            }
        });

        button_6.setLayoutX(355.0);
        button_6.setLayoutY(200.0);
        button_6.setMnemonicParsing(false);
        button_6.setPrefHeight(31.0);
        button_6.setPrefWidth(60.0);
        button_6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(button_6.getText().equals("")){
                    setXorO(button_6);
                    TheWinner();
                }
                
            }
        });

        button_7.setLayoutX(185.0);
        button_7.setLayoutY(240.0);
        button_7.setMnemonicParsing(false);
        button_7.setPrefHeight(31.0);
        button_7.setPrefWidth(60.0);
        button_7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(button_7.getText().equals("")){
                    setXorO(button_7);
                    TheWinner();
                }
                
            }
        });

        button_8.setLayoutX(270.0);
        button_8.setLayoutY(240.0);
        button_8.setMnemonicParsing(false);
        button_8.setPrefHeight(31.0);
        button_8.setPrefWidth(60.0);
        button_8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(button_8.getText().equals("")){
                    setXorO(button_8);
                    TheWinner();
                }
                
            }
        });

        button_9.setLayoutX(355.0);
        button_9.setLayoutY(240.0);
        button_9.setMnemonicParsing(false);
        button_9.setPrefHeight(31.0);
        button_9.setPrefWidth(60.0);
        button_9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(button_9.getText().equals("")){
                    setXorO(button_9);
                    TheWinner();
                }  
            }
        });

        getChildren().add(user2ImageView);
        getChildren().add(user1ImageView);
        getChildren().add(user1NameText);
        getChildren().add(user2NameText);
        getChildren().add(recordIndicatorButton);
        getChildren().add(recordIndicatorImageView);
        getChildren().add(recordGameButton);
        getChildren().add(backImageView);
        getChildren().add(logoImageView);
        getChildren().add(oButton);
        getChildren().add(oImageView);
        getChildren().add(xButton);
        getChildren().add(xImageView);
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
    private void setXorO(Button btn){
        if(turn%2==0){
            turn++;
            btn.setText("X");
        }
        else{
            turn++;
            btn.setText("O");
        }
    }
    private int XisWinner(){
        if (button_1.getText().equals("X")&&button_2.getText().equals("X")&&button_3.getText().equals("X")){
            return 1;
        }
        if (button_4.getText().equals("X")&&button_5.getText().equals("X")&&button_6.getText().equals("X")){
            return 1;
        }
        if (button_7.getText().equals("X")&&button_8.getText().equals("X")&&button_9.getText().equals("X")){
            return 1;
        }
        if (button_1.getText().equals("X")&&button_4.getText().equals("X")&&button_7.getText().equals("X")){
            return 1;
        }
        if (button_2.getText().equals("X")&&button_5.getText().equals("X")&&button_8.getText().equals("X")){
            return 1;
        }
        if (button_3.getText().equals("X")&&button_6.getText().equals("X")&&button_9.getText().equals("X")){
            return 1;
        }
        if (button_1.getText().equals("X")&&button_5.getText().equals("X")&&button_9.getText().equals("X")){
            return 1;
        }
        if (button_3.getText().equals("X")&&button_5.getText().equals("X")&&button_7.getText().equals("X")){
            return 1;
        }
        else {
            return 0;
        }
    }
     private int OisWinner(){
        if (button_1.getText().equals("O")&&button_2.getText().equals("O")&&button_3.getText().equals("O")){
            return 1;
        }
        if (button_4.getText().equals("O")&&button_5.getText().equals("O")&&button_6.getText().equals("O")){
            return 1;
        }
        if (button_7.getText().equals("O")&&button_8.getText().equals("O")&&button_9.getText().equals("O")){
            return 1;
        }
        if (button_1.getText().equals("O")&&button_4.getText().equals("O")&&button_7.getText().equals("O")){
            return 1;
        }
        if (button_2.getText().equals("O")&&button_5.getText().equals("O")&&button_8.getText().equals("O")){
            return 1;
        }
        if (button_3.getText().equals("O")&&button_6.getText().equals("O")&&button_9.getText().equals("O")){
            return 1;
        }
        if (button_1.getText().equals("O")&&button_5.getText().equals("O")&&button_9.getText().equals("O")){
            return 1;
        }
        if (button_3.getText().equals("O")&&button_5.getText().equals("O")&&button_7.getText().equals("O")){
            return 1;
        }
        else {
            return 0;
        }
    }
    private void navigateToWinner(String winnername,String loser){
        Parent root=null;
        //pass winner name and loser name 
        root = new winnerScreen();
        Scene scene = new Scene(root);
        Stage stage = (Stage) backImageView.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    private void TheWinner(){
        int xResult=XisWinner();
        int oResult=OisWinner();
        if(xResult==1){
            navigateToWinner("player1","player2");
        }
        else if(oResult==1){
            navigateToWinner("player2","player1");
        }
        
    }
    
}

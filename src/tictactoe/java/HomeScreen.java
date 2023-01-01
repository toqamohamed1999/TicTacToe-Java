package tictactoe.java;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

public class HomeScreen extends AnchorPane {

    protected final ImageView profilePic;
    protected final Label modeSelectLabel;
    protected final Circle multiPlayerCirle;
    protected final ImageView multiPlayerImage;
    protected final Circle singlePlayerCircle;
    protected final ImageView singlePlayerImage;
    protected final Button singlePlayerButton;
    protected final Button multiPlayerButton;

    public HomeScreen() {

        profilePic = new ImageView();
        modeSelectLabel = new Label();
        multiPlayerCirle = new Circle();
        multiPlayerImage = new ImageView();
        singlePlayerCircle = new Circle();
        singlePlayerImage = new ImageView();
        singlePlayerButton = new Button();
        multiPlayerButton = new Button();

        setId("HomeAnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        getStylesheets().add("/tictactoe/java/Styles.css");

        profilePic.setFitHeight(57.0);
        profilePic.setFitWidth(66.0);
        profilePic.setLayoutX(520.0);
        profilePic.setLayoutY(21.0);
        profilePic.setPickOnBounds(true);
        profilePic.setPreserveRatio(true);
        profilePic.setImage(new Image(getClass().getResource("/res/woman.png").toExternalForm()));
        profilePic.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
          
             Parent root=null;
                root = new ProfileScreen();
                Scene scene = new Scene(root);
                Stage stage = (Stage) profilePic.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
        });

        modeSelectLabel.setLayoutX(162.0);
        modeSelectLabel.setLayoutY(38.0);
        modeSelectLabel.setPrefHeight(67.0);
        modeSelectLabel.setPrefWidth(301.0);
        modeSelectLabel.setText("Select Your Mode");
        modeSelectLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        modeSelectLabel.setFont(new Font("Impact", 40.0));

        multiPlayerCirle.setFill(javafx.scene.paint.Color.valueOf("#44a7a1"));
        multiPlayerCirle.setLayoutX(422.0);
        multiPlayerCirle.setLayoutY(210.0);
        multiPlayerCirle.setRadius(51.0);
        multiPlayerCirle.setStroke(javafx.scene.paint.Color.BLACK);
        multiPlayerCirle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
         multiPlayerCirle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
          
             Parent root=null;
                root = new multiPlayerScreen();
                Scene scene = new Scene(root);
                Stage stage = (Stage) multiPlayerCirle.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
        });

        multiPlayerImage.setFitHeight(78.0);
        multiPlayerImage.setFitWidth(81.0);
        multiPlayerImage.setLayoutX(381.0);
        multiPlayerImage.setLayoutY(170.0);
        multiPlayerImage.setPickOnBounds(true);
        multiPlayerImage.setPreserveRatio(true);
        multiPlayerImage.setImage(new Image(getClass().getResource("/res/singles.png").toExternalForm()));
        multiPlayerImage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
          
             Parent root=null;
                root = new multiPlayerScreen();
                Scene scene = new Scene(root);
                Stage stage = (Stage) multiPlayerImage.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
        });

        singlePlayerCircle.setFill(javafx.scene.paint.Color.valueOf("#44a7a1"));
        singlePlayerCircle.setLayoutX(193.0);
        singlePlayerCircle.setLayoutY(210.0);
        singlePlayerCircle.setRadius(51.0);
        singlePlayerCircle.setStroke(javafx.scene.paint.Color.BLACK);
        singlePlayerCircle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);

        singlePlayerImage.setFitHeight(89.0);
        singlePlayerImage.setFitWidth(54.0);
        singlePlayerImage.setLayoutX(166.0);
        singlePlayerImage.setLayoutY(171.0);
        singlePlayerImage.setPickOnBounds(true);
        singlePlayerImage.setPreserveRatio(true);
        singlePlayerImage.setImage(new Image(getClass().getResource("/res/Single.png").toExternalForm()));

        singlePlayerButton.setLayoutX(110.0);
        singlePlayerButton.setLayoutY(246.0);
        singlePlayerButton.setMnemonicParsing(false);
        singlePlayerButton.setPrefWidth(170.0);
        singlePlayerButton.setText("Single Player");
        singlePlayerButton.setTextFill(javafx.scene.paint.Color.RED);
        singlePlayerButton.setFont(new Font("Impact", 23.0));
        singlePlayerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root=null;
                root = new SingleUserXOScreen();
                Scene scene = new Scene(root);
                Stage stage = (Stage) singlePlayerButton.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
            
        });

        multiPlayerButton.setLayoutX(335.0);
        multiPlayerButton.setLayoutY(246.0);
        multiPlayerButton.setMnemonicParsing(false);
        multiPlayerButton.setPrefWidth(170.0);
        multiPlayerButton.setText("MultiPlayer");
        multiPlayerButton.setTextFill(javafx.scene.paint.Color.RED);
        multiPlayerButton.setFont(new Font("Impact", 23.0));
         multiPlayerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
          
             Parent root=null;
                root = new multiPlayerScreen() {};
                Scene scene = new Scene(root);
                Stage stage = (Stage) multiPlayerButton.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
        });

        getChildren().add(profilePic);
        getChildren().add(modeSelectLabel);
        getChildren().add(multiPlayerCirle);
        getChildren().add(multiPlayerImage);
        getChildren().add(singlePlayerCircle);
        getChildren().add(singlePlayerImage);
        getChildren().add(singlePlayerButton);
        getChildren().add(multiPlayerButton);

    }


}

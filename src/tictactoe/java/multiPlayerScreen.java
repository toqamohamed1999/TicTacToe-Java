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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;


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

        setId("HomeAnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        getStylesheets().add("/tictactoe/java/Styles.css");

        backButton.setFitHeight(53.0);
        backButton.setFitWidth(50.0);
        backButton.setLayoutX(38.0);
        backButton.setLayoutY(21.0);
        backButton.setPickOnBounds(true);
        backButton.setPreserveRatio(true);
        backButton.setImage(new Image(getClass().getResource("/res/back.png").toExternalForm()));
        backButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
          
             Parent root=null;
                root = new HomeScreen() ;
                Scene scene = new Scene(root);
                Stage stage = (Stage) backButton.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
        });
        

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
                Stage stage = (Stage) backButton.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
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

        onlineImage.setFitHeight(78.0);
        onlineImage.setFitWidth(81.0);
        onlineImage.setLayoutX(382.0);
        onlineImage.setLayoutY(173.0);
        onlineImage.setPickOnBounds(true);
        onlineImage.setPreserveRatio(true);
        onlineImage.setImage(new Image(getClass().getResource("/res/multiplayer.png").toExternalForm()));

        passAndPlayCircle.setFill(javafx.scene.paint.Color.valueOf("#44a7a1"));
        passAndPlayCircle.setLayoutX(193.0);
        passAndPlayCircle.setLayoutY(210.0);
        passAndPlayCircle.setRadius(51.0);
        passAndPlayCircle.setStroke(javafx.scene.paint.Color.BLACK);
        passAndPlayCircle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);

        passAndPlayImage.setFitHeight(78.0);
        passAndPlayImage.setFitWidth(78.0);
        passAndPlayImage.setLayoutX(155.0);
        passAndPlayImage.setLayoutY(172.0);
        passAndPlayImage.setPickOnBounds(true);
        passAndPlayImage.setPreserveRatio(true);
        passAndPlayImage.setImage(new Image(getClass().getResource("/res/battle.png").toExternalForm()));

        passAndPlayButton.setLayoutX(110.0);
        passAndPlayButton.setLayoutY(249.0);
        passAndPlayButton.setMnemonicParsing(false);
        passAndPlayButton.setPrefWidth(170.0);
        passAndPlayButton.setText("Pass & Play");
        passAndPlayButton.setTextFill(javafx.scene.paint.Color.RED);
        passAndPlayButton.setFont(new Font("Impact", 23.0));
        passAndPlayButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root=null;
                root = new MultipleUserXOScreenBase();
                Scene scene = new Scene(root);
                Stage stage = (Stage) passAndPlayButton.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
        });

        onlineButton.setLayoutX(335.0);
        onlineButton.setLayoutY(249.0);
        onlineButton.setMnemonicParsing(false);
        onlineButton.setPrefWidth(170.0);
        onlineButton.setText("Online");
        onlineButton.setTextFill(javafx.scene.paint.Color.RED);
        onlineButton.setFont(new Font("Impact", 23.0));
        onlineButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root=null;
                root = new SignInScreenBase();
                Scene scene = new Scene(root);
                Stage stage = (Stage) onlineButton.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
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

    }
}

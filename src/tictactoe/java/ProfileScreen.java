package tictactoe.java;

import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ProfileScreen extends AnchorPane {

    protected final ImageView profileImageView;
    protected final Text userNameTxt;
    protected final Text emailTxt;
    protected final Text scoreTxt;
    protected final Text userNameText;
    protected final Text emailText;
    protected final Text scoreText;
    protected final Button recordsButton;

    public ProfileScreen() {

        profileImageView = new ImageView();
        userNameTxt = new Text();
        emailTxt = new Text();
        scoreTxt = new Text();
        userNameText = new Text();
        emailText = new Text();
        scoreText = new Text();
        recordsButton = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        getStylesheets().add("/tictactoe/java/Styles.css");
        getStylesheets().add("/tictactoe/java/Styles.css");

        profileImageView.setFitHeight(85.0);
        profileImageView.setFitWidth(83.0);
        profileImageView.setLayoutX(260.0);
        profileImageView.setLayoutY(31.0);
        profileImageView.setPickOnBounds(true);
        profileImageView.setPreserveRatio(true);
        profileImageView.setImage(new Image(getClass().getResource("profile.png").toExternalForm()));

        userNameTxt.setFill(javafx.scene.paint.Color.valueOf("#f9002d"));
        userNameTxt.setLayoutX(111.0);
        userNameTxt.setLayoutY(165.0);
        userNameTxt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        userNameTxt.setStrokeWidth(0.0);
        userNameTxt.setText("User Name : ");
        userNameTxt.setWrappingWidth(148.41796875);
        userNameTxt.setFont(new Font("Berlin Sans FB Demi Bold", 26.0));

        emailTxt.setFill(javafx.scene.paint.Color.valueOf("#f9002d"));
        emailTxt.setLayoutX(111.0);
        emailTxt.setLayoutY(209.0);
        emailTxt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        emailTxt.setStrokeWidth(0.0);
        emailTxt.setText("Email : ");
        emailTxt.setWrappingWidth(148.41796875);
        emailTxt.setFont(new Font("Berlin Sans FB Demi Bold", 26.0));

        scoreTxt.setFill(javafx.scene.paint.Color.valueOf("#f9002d"));
        scoreTxt.setLayoutX(111.0);
        scoreTxt.setLayoutY(259.0);
        scoreTxt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        scoreTxt.setStrokeWidth(0.0);
        scoreTxt.setText("Score :");
        scoreTxt.setWrappingWidth(148.41796875);
        scoreTxt.setFont(new Font("Berlin Sans FB Demi Bold", 26.0));

        userNameText.setFill(javafx.scene.paint.Color.WHITE);
        userNameText.setLayoutX(300.0);
        userNameText.setLayoutY(164.0);
        userNameText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        userNameText.setStrokeWidth(0.0);
        userNameText.setText("Eman ");
        userNameText.setWrappingWidth(148.41796875);
        userNameText.setFont(new Font("Berlin Sans FB Demi Bold", 26.0));

        emailText.setFill(javafx.scene.paint.Color.WHITE);
        emailText.setLayoutX(300.0);
        emailText.setLayoutY(209.0);
        emailText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        emailText.setStrokeWidth(0.0);
        emailText.setText("eman@gmail.com ");
        emailText.setWrappingWidth(242.41796875);
        emailText.setFont(new Font("Berlin Sans FB Demi Bold", 26.0));

        scoreText.setFill(javafx.scene.paint.Color.WHITE);
        scoreText.setLayoutX(300.0);
        scoreText.setLayoutY(259.0);
        scoreText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        scoreText.setStrokeWidth(0.0);
        scoreText.setText("90");
        scoreText.setWrappingWidth(148.41796875);
        scoreText.setFont(new Font("Berlin Sans FB Demi Bold", 26.0));

        recordsButton.setLayoutX(215.0);
        recordsButton.setLayoutY(304.0);
        recordsButton.setMnemonicParsing(false);
        recordsButton.setPrefHeight(38.0);
        recordsButton.setPrefWidth(148.0);
        recordsButton.setText("My Records");
        recordsButton.setTextFill(javafx.scene.paint.Color.valueOf("#f9002d"));
        recordsButton.setFont(new Font("Berlin Sans FB Demi Bold", 20.0));

        getChildren().add(profileImageView);
        getChildren().add(userNameTxt);
        getChildren().add(emailTxt);
        getChildren().add(scoreTxt);
        getChildren().add(userNameText);
        getChildren().add(emailText);
        getChildren().add(scoreText);
        getChildren().add(recordsButton);
        
        
        
        recordsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
          
            Parent root;
                try {
                    root = FXMLLoader.load(getClass().getResource("ServerScreen.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = (Stage) recordsButton.getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            
            }
        });
        

    }
}

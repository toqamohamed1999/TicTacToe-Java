package tictactoe.java;

import java.net.URL;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ProfileScreen extends AnchorPane {

    protected final ImageView profileImageView;
    protected final Label emailLabel;
    protected final Label userNameLabel;
    protected final Label scoreLabel;
    protected final Text userNameText;
    protected final Text emailText;
    protected final Text scoreText;
    protected final Button recordsButton;
    protected final ImageView back;
   
 
    public ProfileScreen() {

        profileImageView = new ImageView();
        userNameLabel = new Label();
        scoreLabel = new Label();
        emailLabel = new Label();
        emailText = new Text();
        scoreText = new Text();
        userNameText = new Text();
        recordsButton = new Button();
        back = new ImageView();

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
        profileImageView.setImage(new Image(getClass().getResource("Res/woman.png").toExternalForm()));

        userNameLabel.setLayoutX(111.0);
        userNameLabel.setLayoutY(140.0);
        userNameLabel.setText("UserName:");
        userNameLabel.setTextFill(javafx.scene.paint.Color.valueOf("#f9002d"));
        userNameLabel.setFont(new Font("Impact", 25.0));
        
        scoreLabel.setLayoutX(111.0);
        scoreLabel.setLayoutY(235.0);
        scoreLabel.setText("Score:");
        scoreLabel.setTextFill(javafx.scene.paint.Color.valueOf("#f9002d"));
        scoreLabel.setFont(new Font("Impact", 25.0));

        emailLabel.setLayoutX(111.0);
        emailLabel.setLayoutY(185.0);
        emailLabel.setText("Email:");
        emailLabel.setTextFill(javafx.scene.paint.Color.valueOf("#f9002d"));
        emailLabel.setFont(new Font("Impact", 25.0));

        emailText.setFill(javafx.scene.paint.Color.WHITE);
        emailText.setLayoutX(300.0);
        emailText.setLayoutY(209.0);
        emailText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        emailText.setStrokeWidth(0.0);
        emailText.setText("eman@gmail.com ");
        emailText.setWrappingWidth(242.41796875);
        emailText.setFont(new Font("Impact", 26.0));

        scoreText.setFill(javafx.scene.paint.Color.WHITE);
        scoreText.setLayoutX(300.0);
        scoreText.setLayoutY(259.0);
        scoreText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        scoreText.setStrokeWidth(0.0);
        scoreText.setText("90");
        scoreText.setWrappingWidth(148.41796875);
        scoreText.setFont(new Font("Impact", 26.0));
        
        userNameText.setFill(javafx.scene.paint.Color.WHITE);
        userNameText.setLayoutX(300.0);
        userNameText.setLayoutY(164.0);
        userNameText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        userNameText.setStrokeWidth(0.0);
        userNameText.setText("Eman");
        userNameText.setWrappingWidth(242.41796875);
        userNameText.setFont(new Font("Impact", 26.0));

        recordsButton.setLayoutX(215.0);
        recordsButton.setLayoutY(304.0);
        recordsButton.setMnemonicParsing(false);
        recordsButton.setPrefHeight(38.0);
        recordsButton.setPrefWidth(148.0);
        recordsButton.setText("My Records");
        recordsButton.setTextFill(javafx.scene.paint.Color.valueOf("#f9002d"));
        recordsButton.setFont(new Font("Impact", 20.0));
      
        back.setLayoutX(30.0);
        back.setLayoutY(21.0);
        back.setFitHeight(32.0); 
        back.setPickOnBounds(true);
        back.setPreserveRatio(true);
        back.setImage(new Image(getClass().getResource("Res/back.png").toExternalForm()));
          
        getChildren().add(profileImageView);
        getChildren().add(userNameLabel);
        getChildren().add(scoreLabel);
        getChildren().add(emailLabel);
        getChildren().add(emailText);
        getChildren().add(scoreText);
        getChildren().add(userNameText);
        getChildren().add(recordsButton);
        getChildren().add(back);
       
        recordsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
          
            Parent root;
            root = new ServerScreen();
            //root = new OnlineList();
            Scene scene = new Scene(root);
            Stage stage = (Stage) recordsButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            
            }
        });
         
         
        back.setOnMouseClicked((MouseEvent e) -> {
           
            Parent root;
            root = new OnlineList();
            Scene scene = new Scene(root);
            Stage stage = (Stage) back.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        });

    }
}

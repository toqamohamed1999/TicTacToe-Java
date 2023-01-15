package tictactoe.java;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.Optional;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.ClientSide;
import logic.OnlineList;
import logic.SignIn;

public class ProfileScreen extends AnchorPane {

    protected final ImageView profileImageView;
    protected final Label userNameLabel;
    public final Text emailText;
    protected final Text scoreText;
    protected final Button recordsButton;
    protected final Label scoreLabel;
    protected final Label emailLabel;
    public final Text userNameText;
    protected final ImageView back;
    protected final ImageView logout;
    String ip = null;

    public ProfileScreen(String profilData) {

        profileImageView = new ImageView();
        userNameLabel = new Label();
        scoreLabel = new Label();
        emailLabel = new Label();
        userNameText = new Text();
        emailText = new Text();
        scoreText = new Text();
        recordsButton = new Button();
        back = new ImageView();
        logout = new ImageView();

        if (profilData != null) {
            divideMessage(profilData);
        }

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(430.0);
        setPrefWidth(600.0);
        getStylesheets().add("/tictactoe/java/Styles.css");

        profileImageView.setFitHeight(85.0);
        profileImageView.setFitWidth(83.0);
        profileImageView.setLayoutX(260.0);
        profileImageView.setLayoutY(31.0);
        profileImageView.setPickOnBounds(true);
        profileImageView.setPreserveRatio(true);
        if (profileArr[4].toLowerCase().equals("female")) {
            profileImageView.setImage(new Image(getClass().getResource("/res/woman.png").toExternalForm()));
        } else {
            profileImageView.setImage(new Image(getClass().getResource("/res/man.png").toExternalForm()));
        }

        userNameLabel.setLayoutX(112.0);
        userNameLabel.setLayoutY(169.0);
        userNameLabel.setText("UserName:");
        userNameLabel.setTextFill(javafx.scene.paint.Color.valueOf("#f9002d"));
        userNameLabel.setFont(new Font("Impact", 25.0));

        scoreLabel.setLayoutX(112.0);
        scoreLabel.setLayoutY(270.0);
        scoreLabel.setText("Score:");
        scoreLabel.setTextFill(javafx.scene.paint.Color.valueOf("#f9002d"));
        scoreLabel.setFont(new Font("Impact", 25.0));

        emailLabel.setLayoutX(113.0);
        emailLabel.setLayoutY(217.0);
        emailLabel.setText("Email:");
        emailLabel.setTextFill(javafx.scene.paint.Color.valueOf("#f9002d"));
        emailLabel.setFont(new Font("Impact", 25.0));

        emailText.setFill(javafx.scene.paint.Color.WHITE);
        emailText.setLayoutX(300.0);
        emailText.setLayoutY(242.0);
        emailText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        emailText.setStrokeWidth(0.0);
        emailText.setText(profileArr[2]);
        emailText.setWrappingWidth(242.41796875);
        emailText.setFont(new Font("Impact", 26.0));

        scoreText.setFill(javafx.scene.paint.Color.WHITE);
        scoreText.setLayoutX(302.0);
        scoreText.setLayoutY(294.0);
        scoreText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        scoreText.setStrokeWidth(0.0);
        scoreText.setText(profileArr[3]);
        scoreText.setWrappingWidth(148.41796875);
        scoreText.setFont(new Font("Impact", 26.0));

        userNameText.setFill(javafx.scene.paint.Color.WHITE);
        userNameText.setLayoutX(300.0);
        userNameText.setLayoutY(194.0);
        userNameText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        userNameText.setStrokeWidth(0.0);
        userNameText.setText(profileArr[1]);
        userNameText.setWrappingWidth(242.41796875);
        userNameText.setFont(new Font("Impact", 26.0));

        recordsButton.setLayoutX(211.0);
        recordsButton.setLayoutY(338.0);
        recordsButton.setMnemonicParsing(false);
        recordsButton.setPrefHeight(38.0);
        recordsButton.setPrefWidth(148.0);
        recordsButton.setCursor(Cursor.OPEN_HAND);
        recordsButton.setText("My Records");
        recordsButton.setTextFill(javafx.scene.paint.Color.valueOf("#f9002d"));
        recordsButton.setFont(new Font("Impact", 20.0));
        recordsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            }
        });

        back.setFitHeight(53.0);
        back.setFitWidth(50.0);
        back.setLayoutX(30.0);
        back.setLayoutY(21.0);
        back.setPickOnBounds(true);
        back.setPreserveRatio(true);
        back.setCursor(Cursor.OPEN_HAND);
        back.setImage(new Image(getClass().getResource("/res/back.png").toExternalForm()));
        back.setOnMouseClicked((MouseEvent e) -> {
            OnlineList onlineList = new OnlineList("");
            TicTacToeJava.stage.setScene(new Scene(onlineList.onlineListScreen));
        });

        logout.setFitHeight(53.0);
        logout.setFitWidth(50.0);
        logout.setLayoutX(520.0);
        logout.setLayoutY(21.0);
        logout.setPickOnBounds(true);
        logout.setPreserveRatio(true);
        logout.setCursor(Cursor.OPEN_HAND);
        logout.setImage(new Image(getClass().getResource("/res/logout.png").toExternalForm()));
        logout.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                showAlart();
            }
        });

        getChildren().add(profileImageView);
        getChildren().add(userNameLabel);
        getChildren().add(emailText);
        getChildren().add(scoreText);
        getChildren().add(recordsButton);
        getChildren().add(scoreLabel);
        getChildren().add(emailLabel);
        getChildren().add(userNameText);
        getChildren().add(back);
        getChildren().add(logout);

        try {
            ip = Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }

    }

    String[] profileArr;

    public void divideMessage(String operation) {
        profileArr = operation.split(",");
    }

    public void showAlart() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout!");
        alert.setHeaderText("Do you want to logout?");

        Optional<ButtonType> result = alert.showAndWait();
        ButtonType button = result.orElse(ButtonType.CANCEL);

        if (button == ButtonType.OK) {
            ClientSide.ps.println("logOut," + ip);
            SignIn signIn = new SignIn();
            TicTacToeJava.stage.setScene(new Scene(signIn.signInScreenBase));
        } else {
            alert.close();
        }

    }

}

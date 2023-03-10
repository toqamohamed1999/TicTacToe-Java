package tictactoe.java;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.SignUp;

public class SignInScreenBase extends AnchorPane {

    protected final ImageView logoImageView;
    protected final Label userNameLabel;
    protected final Label passwordLabel;
    public final TextField emailTextField;
    public final PasswordField passwordTextField;
    public final Button signInButton;
    protected final DropShadow dropShadow;
    protected final Label dontHaveAccLabel;
    protected final Label signUpHyperLink;
    protected final ImageView backButton;

    public SignInScreenBase() {

        logoImageView = new ImageView();
        userNameLabel = new Label();
        passwordLabel = new Label();
        emailTextField = new TextField();
        passwordTextField = new PasswordField();
        signInButton = new Button();
        dropShadow = new DropShadow();
        dontHaveAccLabel = new Label();
        signUpHyperLink = new Label();
        backButton = new ImageView();

        setId("AnchorPane");
        setPrefHeight(430.0);
        setPrefWidth(600.0);
        getStylesheets().add("/tictactoe/java/Styles.css");

        logoImageView.setFitHeight(83.0);
        logoImageView.setFitWidth(373.0);
        logoImageView.setLayoutX(159.0);
        logoImageView.setLayoutY(30.0);
        logoImageView.setPickOnBounds(true);
        logoImageView.setImage(new Image(getClass().getResource("/res/HorizontalLogo.png").toExternalForm()));

        userNameLabel.setLayoutX(142.0);
        userNameLabel.setLayoutY(191.0);
        userNameLabel.setText("Email");
        userNameLabel.setTextFill(javafx.scene.paint.Color.RED);
        userNameLabel.setFont(new Font("Impact", 24.0));

        passwordLabel.setLayoutX(142.0);
        passwordLabel.setLayoutY(243.0);
        passwordLabel.setText("Password");
        passwordLabel.setTextFill(javafx.scene.paint.Color.RED);
        passwordLabel.setFont(new Font("Impact", 24.0));

        emailTextField.setId("TextField");
        emailTextField.setLayoutX(268.0);
        emailTextField.setLayoutY(188.0);
        emailTextField.setPrefWidth(200.0);
        emailTextField.getStylesheets().add("/tictactoe/java/Styles.css");
        emailTextField.setFont(new Font("Impact", 16.0));

        passwordTextField.setId("TextField");
        passwordTextField.setLayoutX(268.0);
        passwordTextField.setLayoutY(239.0);
        passwordTextField.setPrefWidth(200.0);
        passwordTextField.getStylesheets().add("/tictactoe/java/Styles.css");
        passwordTextField.setFont(new Font("Impact", 16.0));

        signInButton.setLayoutX(250.0);
        signInButton.setLayoutY(341.0);
        signInButton.setMnemonicParsing(false);
        signInButton.setPrefWidth(110.0);
        signInButton.getStylesheets().add("/tictactoe/java/Styles.css");
        signInButton.setText("Sign In");
        signInButton.setTextFill(javafx.scene.paint.Color.RED);
        signInButton.setFont(new Font("Impact", 26.0));

        dropShadow.setBlurType(javafx.scene.effect.BlurType.ONE_PASS_BOX);
        dropShadow.setColor(javafx.scene.paint.Color.WHITE);
        dropShadow.setOffsetY(4.0);
        signInButton.setEffect(dropShadow);
        signInButton.setCursor(Cursor.HAND);

        dontHaveAccLabel.setLayoutX(194.0);
        dontHaveAccLabel.setLayoutY(401.0);
        dontHaveAccLabel.setText("Don't Have an account? .. ");
        dontHaveAccLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        dontHaveAccLabel.setFont(new Font("Impact", 16.0));

        signUpHyperLink.setLayoutX(359.0);
        signUpHyperLink.setLayoutY(401.0);
        signUpHyperLink.setText("Sign up");
        signUpHyperLink.setTextFill(javafx.scene.paint.Color.WHITE);
        signUpHyperLink.setUnderline(true);
        signUpHyperLink.setFont(new Font("Impact", 18.0));
        signUpHyperLink.setCursor(Cursor.HAND);
        signUpHyperLink.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                SignUp signUp = new SignUp();
                TicTacToeJava.stage.setScene(new Scene(signUp.signUpScreenBase));
            }
        });

        backButton.setFitHeight(53.0);
        backButton.setFitWidth(50.0);
        backButton.setLayoutX(30.0);
        backButton.setLayoutY(21.0);
        backButton.setPickOnBounds(true);
        backButton.setPreserveRatio(true);
        backButton.setImage(new Image(getClass().getResource("/res/back.png").toExternalForm()));
        backButton.setCursor(Cursor.HAND);
        backButton.setOnMouseClicked((MouseEvent e) -> {
            Parent root;
            root = new multiPlayerScreen();
            Scene scene = new Scene(root);
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        });

        getChildren().add(logoImageView);
        getChildren().add(userNameLabel);
        getChildren().add(passwordLabel);
        getChildren().add(emailTextField);
        getChildren().add(passwordTextField);
        getChildren().add(signInButton);
        getChildren().add(dontHaveAccLabel);
        getChildren().add(signUpHyperLink);
        getChildren().add(backButton);

    }
}

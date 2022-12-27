package tictactoe.java;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SignInScreen extends AnchorPane {

    protected final ImageView imageView;
    protected final Label label;
    protected final Label label0;
    protected final TextField userNameTextField;
    protected final TextField PasswordTextField;
    protected final Button signInButton;
    protected final DropShadow dropShadow;
    protected final Label label1;
    protected final Label signUpHyperLink;

    public SignInScreen() {

        imageView = new ImageView();
        label = new Label();
        label0 = new Label();
        userNameTextField = new TextField();
        PasswordTextField = new TextField();
        signInButton = new Button();
        dropShadow = new DropShadow();
        label1 = new Label();
        signUpHyperLink = new Label();

        setId("AnchorPane");
        setPrefHeight(430.0);
        setPrefWidth(600.0);
        getStylesheets().add("/tictactoe/java/Styles.css");

        imageView.setFitHeight(83.0);
        imageView.setFitWidth(373.0);
        imageView.setLayoutX(159.0);
        imageView.setLayoutY(30.0);
        imageView.setPickOnBounds(true);
        imageView.setImage(new Image(getClass().getResource("HorizontalLogo.png").toExternalForm()));

        label.setLayoutX(142.0);
        label.setLayoutY(171.0);
        label.setText("User Name");
        label.setTextFill(javafx.scene.paint.Color.RED);
        label.setFont(new Font("Impact", 24.0));

        label0.setLayoutX(142.0);
        label0.setLayoutY(223.0);
        label0.setText("Password");
        label0.setTextFill(javafx.scene.paint.Color.RED);
        label0.setFont(new Font("Impact", 24.0));

        userNameTextField.setId("TextField");
        userNameTextField.setLayoutX(268.0);
        userNameTextField.setLayoutY(168.0);
        userNameTextField.setPrefWidth(200.0);
        userNameTextField.getStylesheets().add("/tictactoe/java/Styles.css");
        userNameTextField.setCursor(Cursor.TEXT);
        userNameTextField.setFont(new Font("Impact", 16.0));

        PasswordTextField.setId("TextField");
        PasswordTextField.setLayoutX(268.0);
        PasswordTextField.setLayoutY(219.0);
        PasswordTextField.setPrefWidth(200.0);
        PasswordTextField.getStylesheets().add("/tictactoe/java/Styles.css");
        PasswordTextField.setCursor(Cursor.TEXT);
        PasswordTextField.setFont(new Font("Impact", 16.0));

        signInButton.setLayoutX(250.0);
        signInButton.setLayoutY(341.0);
        signInButton.setMnemonicParsing(false);
        signInButton.setPrefWidth(110.0);
        signInButton.getStylesheets().add("/tictactoe/java/Styles.css");
        signInButton.setText("Sign In");
        signInButton.setTextFill(javafx.scene.paint.Color.RED);
        signInButton.setFont(new Font("Impact", 26.0));
        signInButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
          
             Parent root = null;
                root = new HomeScreen(){};
                Scene scene = new Scene(root);
                Stage stage = (Stage) signInButton.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
        });


        dropShadow.setBlurType(javafx.scene.effect.BlurType.ONE_PASS_BOX);
        dropShadow.setColor(javafx.scene.paint.Color.WHITE);
        dropShadow.setOffsetY(4.0);
        signInButton.setEffect(dropShadow);

        label1.setLayoutX(194.0);
        label1.setLayoutY(401.0);
        label1.setText("Don't Have an account? .. ");
        label1.setTextFill(javafx.scene.paint.Color.WHITE);
        label1.setFont(new Font("Impact", 16.0));

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
          
             Parent root=null;
                root = new signUpScreen() ;
                Scene scene = new Scene(root);
                Stage stage = (Stage) signUpHyperLink.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
        });


        getChildren().add(imageView);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(userNameTextField);
        getChildren().add(PasswordTextField);
        getChildren().add(signInButton);
        getChildren().add(label1);
        getChildren().add(signUpHyperLink);

    }
}

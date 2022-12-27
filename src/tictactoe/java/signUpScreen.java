package tictactoe.java;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class signUpScreen extends AnchorPane {

    protected final ImageView imageView;
    protected final Label label;
    protected final Label label0;
    protected final TextField userNameTextField;
    protected final Button SignUpButton;
    protected final DropShadow dropShadow;
    protected final Label label1;
    protected final Label signInHyperLink;
    protected final Label label2;
    protected final Label label3;
    protected final TextField passwordTextField;
    protected final TextField EmailTextField;
    protected final RadioButton maleRadioButton;
    protected final RadioButton femaleRadioButton;
    protected final TextField EmailTextField1;
    protected final Label label4;

    public signUpScreen() {

        imageView = new ImageView();
        label = new Label();
        label0 = new Label();
        userNameTextField = new TextField();
        SignUpButton = new Button();
        dropShadow = new DropShadow();
        label1 = new Label();
        signInHyperLink = new Label();
        label2 = new Label();
        label3 = new Label();
        passwordTextField = new TextField();
        EmailTextField = new TextField();
        maleRadioButton = new RadioButton();
        femaleRadioButton = new RadioButton();
        EmailTextField1 = new TextField();
        label4 = new Label();

        setId("AnchorPane");
        setPrefHeight(430.0);
        setPrefWidth(600.0);

        imageView.setFitHeight(83.0);
        imageView.setFitWidth(373.0);
        imageView.setLayoutX(159.0);
        imageView.setLayoutY(30.0);
        imageView.setPickOnBounds(true);
        imageView.setImage(new Image(getClass().getResource("HorizontalLogo.png").toExternalForm()));

        label.setLayoutX(111.0);
        label.setLayoutY(138.0);
        label.setText("User Name");
        label.setTextFill(javafx.scene.paint.Color.RED);
        label.setFont(new Font("Impact", 24.0));

        label0.setLayoutX(111.0);
        label0.setLayoutY(176.0);
        label0.setText("Password");
        label0.setTextFill(javafx.scene.paint.Color.RED);
        label0.setFont(new Font("Impact", 24.0));

        AnchorPane.setBottomAnchor(userNameTextField, 260.0);
        AnchorPane.setRightAnchor(userNameTextField, 100.0);
        userNameTextField.setId("TextField");
        userNameTextField.setLayoutX(228.0);
        userNameTextField.setLayoutY(137.0);
        userNameTextField.setPrefHeight(33.0);
        userNameTextField.setPrefWidth(272.0);
        userNameTextField.getStylesheets().add("/tictactoe/java/Styles.css");
        userNameTextField.setFont(new Font("Impact", 16.0));
        userNameTextField.setCursor(Cursor.TEXT);

        SignUpButton.setLayoutX(250.0);
        SignUpButton.setLayoutY(341.0);
        SignUpButton.setMnemonicParsing(false);
        SignUpButton.setPrefHeight(51.0);
        SignUpButton.setPrefWidth(118.0);
        SignUpButton.getStylesheets().add("/tictactoe/java/Styles.css");
        SignUpButton.setText("Sign up");
        SignUpButton.setTextFill(javafx.scene.paint.Color.RED);
        SignUpButton.setFont(new Font("Impact", 26.0));
        SignUpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
          
             Parent root=null;
                root = new HomeScreen(){};
                Scene scene = new Scene(root);
                Stage stage = (Stage) SignUpButton.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
        });

        dropShadow.setBlurType(javafx.scene.effect.BlurType.ONE_PASS_BOX);
        dropShadow.setColor(javafx.scene.paint.Color.WHITE);
        dropShadow.setOffsetY(4.0);
        SignUpButton.setEffect(dropShadow);

        label1.setLayoutX(188.0);
        label1.setLayoutY(401.0);
        label1.setText("Already Have an account? .. ");
        label1.setTextFill(javafx.scene.paint.Color.WHITE);
        label1.setFont(new Font("Impact", 16.0));

        signInHyperLink.setLayoutX(368.0);
        signInHyperLink.setLayoutY(401.0);
        signInHyperLink.setText("Sign in");
        signInHyperLink.setTextFill(javafx.scene.paint.Color.WHITE);
        signInHyperLink.setUnderline(true);
        signInHyperLink.setFont(new Font("Impact", 18.0));
        signInHyperLink.setCursor(Cursor.HAND);
         signInHyperLink.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
          
             Parent root=null;
                root = new SignInScreen();
                Scene scene = new Scene(root);
                Stage stage = (Stage) signInHyperLink.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
        });

        label2.setLayoutX(111.0);
        label2.setLayoutY(217.0);
        label2.setPrefHeight(29.0);
        label2.setPrefWidth(189.0);
        label2.setText("Confirm Passowrd");
        label2.setTextFill(javafx.scene.paint.Color.RED);
        label2.setFont(new Font("Impact", 24.0));

        label3.setLayoutX(111.0);
        label3.setLayoutY(258.0);
        label3.setText("Email");
        label3.setTextFill(javafx.scene.paint.Color.RED);
        label3.setFont(new Font("Impact", 24.0));

        AnchorPane.setBottomAnchor(passwordTextField, 221.0);
        AnchorPane.setRightAnchor(passwordTextField, 100.0);
        passwordTextField.setId("TextField");
        passwordTextField.setLayoutX(228.0);
        passwordTextField.setLayoutY(176.0);
        passwordTextField.setPrefHeight(33.0);
        passwordTextField.setPrefWidth(272.0);
        passwordTextField.getStylesheets().add("/tictactoe/java/Styles.css");
        passwordTextField.setFont(new Font("Impact", 16.0));
        passwordTextField.setCursor(Cursor.TEXT);

        AnchorPane.setBottomAnchor(EmailTextField, 182.0);
        AnchorPane.setRightAnchor(EmailTextField, 100.0);
        EmailTextField.setId("TextField");
        EmailTextField.setLayoutX(300.0);
        EmailTextField.setLayoutY(215.0);
        EmailTextField.setPrefWidth(200.0);
        EmailTextField.getStylesheets().add("/tictactoe/java/Styles.css");
        EmailTextField.setFont(new Font("Impact", 16.0));
        EmailTextField.setCursor(Cursor.TEXT);

        maleRadioButton.setLayoutX(228.0);
        maleRadioButton.setLayoutY(303.0);
        maleRadioButton.setMnemonicParsing(false);
        maleRadioButton.setText("Male");
        maleRadioButton.setTextFill(javafx.scene.paint.Color.WHITE);
        maleRadioButton.setFont(new Font("Impact", 16.0));

        femaleRadioButton.setLayoutX(369.0);
        femaleRadioButton.setLayoutY(303.0);
        femaleRadioButton.setMnemonicParsing(false);
        femaleRadioButton.setText("Female");
        femaleRadioButton.setTextFill(javafx.scene.paint.Color.WHITE);
        femaleRadioButton.setFont(new Font("Impact", 16.0));

        AnchorPane.setBottomAnchor(EmailTextField1, 143.0);
        AnchorPane.setRightAnchor(EmailTextField1, 100.0);
        EmailTextField1.setId("TextField");
        EmailTextField1.setLayoutX(176.0);
        EmailTextField1.setLayoutY(254.0);
        EmailTextField1.setPrefHeight(33.0);
        EmailTextField1.setPrefWidth(324.0);
        EmailTextField1.getStylesheets().add("/tictactoe/java/Styles.css");
        EmailTextField1.setFont(new Font("Impact", 16.0));
        EmailTextField1.setCursor(Cursor.TEXT);

        label4.setLayoutX(111.0);
        label4.setLayoutY(299.0);
        label4.setText("Gender");
        label4.setTextFill(javafx.scene.paint.Color.RED);
        label4.setFont(new Font("Impact", 24.0));
        getStylesheets().add("/tictactoe/java/Styles.css");
        getStylesheets().add("/tictactoe/java/Styles.css");

        getChildren().add(imageView);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(userNameTextField);
        getChildren().add(SignUpButton);
        getChildren().add(label1);
        getChildren().add(signInHyperLink);
        getChildren().add(label2);
        getChildren().add(label3);
        getChildren().add(passwordTextField);
        getChildren().add(EmailTextField);
        getChildren().add(maleRadioButton);
        getChildren().add(femaleRadioButton);
        getChildren().add(EmailTextField1);
        getChildren().add(label4);

    }
}

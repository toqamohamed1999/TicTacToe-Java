package tictactoe.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.SignIn;

public class SignUpScreenBase extends AnchorPane {

    protected final ImageView logoImageView;
    protected final Label userNameLabel;
    protected final Label passwordLabel;
    public final TextField userNameTextField;
    public final Button signUpButton;
    protected final DropShadow dropShadow;
    protected final Label alreadyHaveAccLabel;
    protected final Label signInHyperLink;
    protected final Label confirmPasswordLabel;
    protected final Label emailLabel;
    public final PasswordField passwordTextField;
    public final PasswordField confirmTextField;
    public final RadioButton maleRadioButton;
    public final RadioButton femaleRadioButton;
    public final TextField emailTextField;
    protected final Label genderLabel;
    protected final ImageView backButton;
    protected final ToggleGroup gender;

    public SignUpScreenBase() {

        logoImageView = new ImageView();
        userNameLabel = new Label();
        passwordLabel = new Label();
        userNameTextField = new TextField();
        signUpButton = new Button();
        dropShadow = new DropShadow();
        alreadyHaveAccLabel = new Label();
        signInHyperLink = new Label();
        confirmPasswordLabel = new Label();
        emailLabel = new Label();
        passwordTextField = new PasswordField();
        confirmTextField = new PasswordField();
        maleRadioButton = new RadioButton();
        femaleRadioButton = new RadioButton();
        emailTextField = new TextField();
        genderLabel = new Label();
        backButton = new ImageView();
        gender = new ToggleGroup();

        setId("AnchorPane");
        setPrefHeight(430.0);
        setPrefWidth(600.0);

        logoImageView.setFitHeight(83.0);
        logoImageView.setFitWidth(373.0);
        logoImageView.setLayoutX(159.0);
        logoImageView.setLayoutY(30.0);
        logoImageView.setPickOnBounds(true);
        logoImageView.setImage(new Image(getClass().getResource("/res/HorizontalLogo.png").toExternalForm()));

        userNameLabel.setLayoutX(111.0);
        userNameLabel.setLayoutY(138.0);
        userNameLabel.setText("User Name");
        userNameLabel.setTextFill(javafx.scene.paint.Color.RED);
        userNameLabel.setFont(new Font("Impact", 24.0));

        passwordLabel.setLayoutX(111.0);
        passwordLabel.setLayoutY(176.0);
        passwordLabel.setText("Password");
        passwordLabel.setTextFill(javafx.scene.paint.Color.RED);
        passwordLabel.setFont(new Font("Impact", 24.0));

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

        signUpButton.setLayoutX(250.0);
        signUpButton.setLayoutY(341.0);
        signUpButton.setMnemonicParsing(false);
        signUpButton.setPrefHeight(51.0);
        signUpButton.setPrefWidth(118.0);
        signUpButton.getStylesheets().add("/tictactoe/java/Styles.css");
        signUpButton.setText("Sign up");
        signUpButton.setTextFill(javafx.scene.paint.Color.RED);
        signUpButton.setFont(new Font("Impact", 26.0));

        dropShadow.setBlurType(javafx.scene.effect.BlurType.ONE_PASS_BOX);
        dropShadow.setColor(javafx.scene.paint.Color.WHITE);
        dropShadow.setOffsetY(4.0);
        signUpButton.setEffect(dropShadow);
        signUpButton.setCursor(Cursor.HAND);

        alreadyHaveAccLabel.setLayoutX(188.0);
        alreadyHaveAccLabel.setLayoutY(401.0);
        alreadyHaveAccLabel.setText("Already Have an account? .. ");
        alreadyHaveAccLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        alreadyHaveAccLabel.setFont(new Font("Impact", 16.0));

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
                SignIn signIn = new SignIn();
                TicTacToeJava.stage.setScene(new Scene(signIn.signInScreenBase));
            }
        });

        confirmPasswordLabel.setLayoutX(111.0);
        confirmPasswordLabel.setLayoutY(217.0);
        confirmPasswordLabel.setPrefHeight(29.0);
        confirmPasswordLabel.setPrefWidth(189.0);
        confirmPasswordLabel.setText("Confirm Passowrd");
        confirmPasswordLabel.setTextFill(javafx.scene.paint.Color.RED);
        confirmPasswordLabel.setFont(new Font("Impact", 24.0));

        emailLabel.setLayoutX(111.0);
        emailLabel.setLayoutY(258.0);
        emailLabel.setText("Email");
        emailLabel.setTextFill(javafx.scene.paint.Color.RED);
        emailLabel.setFont(new Font("Impact", 24.0));

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

        AnchorPane.setBottomAnchor(confirmTextField, 182.0);
        AnchorPane.setRightAnchor(confirmTextField, 100.0);
        confirmTextField.setId("TextField");
        confirmTextField.setLayoutX(300.0);
        confirmTextField.setLayoutY(215.0);
        confirmTextField.setPrefWidth(200.0);
        confirmTextField.getStylesheets().add("/tictactoe/java/Styles.css");
        confirmTextField.setFont(new Font("Impact", 16.0));
        confirmTextField.setCursor(Cursor.TEXT);

        maleRadioButton.setLayoutX(228.0);
        maleRadioButton.setLayoutY(303.0);
        maleRadioButton.setMnemonicParsing(false);
        maleRadioButton.setText("Male");
        maleRadioButton.setTextFill(javafx.scene.paint.Color.WHITE);
        maleRadioButton.setFont(new Font("Impact", 16.0));
        maleRadioButton.setToggleGroup(gender);
        maleRadioButton.setOnAction(this::getGender);

        femaleRadioButton.setLayoutX(369.0);
        femaleRadioButton.setLayoutY(303.0);
        femaleRadioButton.setMnemonicParsing(false);
        femaleRadioButton.setText("Female");
        femaleRadioButton.setTextFill(javafx.scene.paint.Color.WHITE);
        femaleRadioButton.setFont(new Font("Impact", 16.0));
        femaleRadioButton.setToggleGroup(gender);
        femaleRadioButton.setOnAction(this::getGender);

        AnchorPane.setBottomAnchor(emailTextField, 143.0);
        AnchorPane.setRightAnchor(emailTextField, 100.0);
        emailTextField.setId("TextField");
        emailTextField.setLayoutX(176.0);
        emailTextField.setLayoutY(254.0);
        emailTextField.setPrefHeight(33.0);
        emailTextField.setPrefWidth(324.0);
        emailTextField.getStylesheets().add("/tictactoe/java/Styles.css");
        emailTextField.setFont(new Font("Impact", 16.0));
        emailTextField.setCursor(Cursor.TEXT);

        genderLabel.setLayoutX(111.0);
        genderLabel.setLayoutY(299.0);
        genderLabel.setText("Gender");
        genderLabel.setTextFill(javafx.scene.paint.Color.RED);
        genderLabel.setFont(new Font("Impact", 24.0));

        backButton.setFitHeight(53.0);
        backButton.setFitWidth(50.0);
        backButton.setLayoutX(30.0);
        backButton.setLayoutY(21.0);
        backButton.setPickOnBounds(true);
        backButton.setPreserveRatio(true);
        backButton.setImage(new Image(getClass().getResource("/res/back.png").toExternalForm()));
        backButton.setCursor(Cursor.HAND);
        backButton.setOnMouseClicked((MouseEvent e) -> {
            TicTacToeJava.stage.setScene(new Scene(new multiPlayerScreen()));

        });
        getStylesheets().add("/tictactoe/java/Styles.css");

        getChildren().add(logoImageView);
        getChildren().add(userNameLabel);
        getChildren().add(passwordLabel);
        getChildren().add(userNameTextField);
        getChildren().add(signUpButton);
        getChildren().add(alreadyHaveAccLabel);
        getChildren().add(signInHyperLink);
        getChildren().add(confirmPasswordLabel);
        getChildren().add(emailLabel);
        getChildren().add(passwordTextField);
        getChildren().add(confirmTextField);
        getChildren().add(maleRadioButton);
        getChildren().add(femaleRadioButton);
        getChildren().add(emailTextField);
        getChildren().add(genderLabel);
        getChildren().add(backButton);

    }

    public String getGender(ActionEvent actionEvent) {
        if (maleRadioButton.isSelected()) {
            return maleRadioButton.getText();
        }
        if (femaleRadioButton.isSelected()) {
            return femaleRadioButton.getText();
        } else {
            return "Not Selected";
        }
    }

    public boolean validEmail(String input) {

        String emailRegex = "^.+@.+\\..+$";
        Pattern emailPattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPattern.matcher(input);
        return matcher.find();


    }

    public static boolean validPassword(String password) {
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";
        
        Pattern passwordPattern = Pattern.compile(regex);

        if (password == null) {
            return false;
        }
        Matcher m = passwordPattern.matcher(password);

        return m.matches();

    }

}

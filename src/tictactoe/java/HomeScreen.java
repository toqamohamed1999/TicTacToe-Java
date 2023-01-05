package tictactoe.java;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HomeScreen extends AnchorPane {

    protected final ImageView profilePic;
    protected final Label modeSelectLabel;
    protected final Circle multiPlayerCirle;
    protected final ImageView multiPlayerImage;
    protected final Circle singlePlayerCircle;
    protected final ImageView singlePlayerImage;
    protected final Button singlePlayerButton;
    protected final Button multiPlayerButton;
    protected final Pane levelSelectionPane;
    protected final Button easyButton;
    protected final ImageView easyImage;
    protected final Button mediumButton;
    protected final ImageView mediumImage;
    protected final Button hardButton;
    protected final ImageView hardImage;
    protected final Label levelSelectionHeader;
    protected final Label enterNameLabel;
    protected final TextField userNameTextField;
    protected final ImageView backButton;

    public HomeScreen() {

        profilePic = new ImageView();
        modeSelectLabel = new Label();
        multiPlayerCirle = new Circle();
        multiPlayerImage = new ImageView();
        singlePlayerCircle = new Circle();
        singlePlayerImage = new ImageView();
        singlePlayerButton = new Button();
        multiPlayerButton = new Button();
        levelSelectionPane = new Pane();
        easyButton = new Button();
        easyImage = new ImageView();
        mediumButton = new Button();
        mediumImage = new ImageView();
        hardButton = new Button();
        hardImage = new ImageView();
        levelSelectionHeader = new Label();
        enterNameLabel = new Label();
        userNameTextField = new TextField();
        backButton = new ImageView();

        setId("HomeAnchorPane");
        setPrefHeight(430.0);
        setPrefWidth(600.0);
        getStylesheets().add("/tictactoe/java/Styles.css");

        profilePic.setFitHeight(57.0);
        profilePic.setFitWidth(66.0);
        profilePic.setLayoutX(520.0);
        profilePic.setLayoutY(21.0);
        profilePic.setPickOnBounds(true);
        profilePic.setPreserveRatio(true);
        profilePic.setImage(new Image(getClass().getResource("/res/woman.png").toExternalForm()));
        profilePic.setCursor(Cursor.HAND);
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
        multiPlayerCirle.setCursor(Cursor.HAND);
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
        multiPlayerImage.setCursor(Cursor.HAND);
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
        singlePlayerCircle.setCursor(Cursor.HAND);
        singlePlayerCircle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                showDifficultyChoices();
            }
        });

        singlePlayerImage.setFitHeight(89.0);
        singlePlayerImage.setFitWidth(54.0);
        singlePlayerImage.setLayoutX(166.0);
        singlePlayerImage.setLayoutY(171.0);
        singlePlayerImage.setPickOnBounds(true);
        singlePlayerImage.setPreserveRatio(true);
        singlePlayerImage.setImage(new Image(getClass().getResource("/res/Single.png").toExternalForm()));
        singlePlayerImage.setCursor(Cursor.HAND);
        singlePlayerImage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                showDifficultyChoices(); 
            }
        });

        singlePlayerButton.setLayoutX(110.0);
        singlePlayerButton.setLayoutY(246.0);
        singlePlayerButton.setMnemonicParsing(false);
        singlePlayerButton.setPrefWidth(170.0);
        singlePlayerButton.setText("Single Player");
        singlePlayerButton.setTextFill(javafx.scene.paint.Color.RED);
        singlePlayerButton.setFont(new Font("Impact", 23.0));
        singlePlayerButton.setCursor(Cursor.HAND);
        singlePlayerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showDifficultyChoices(); 
            }
            
        });

        multiPlayerButton.setLayoutX(335.0);
        multiPlayerButton.setLayoutY(246.0);
        multiPlayerButton.setMnemonicParsing(false);
        multiPlayerButton.setPrefWidth(170.0);
        multiPlayerButton.setText("MultiPlayer");
        multiPlayerButton.setTextFill(javafx.scene.paint.Color.RED);
        multiPlayerButton.setFont(new Font("Impact", 23.0));
        multiPlayerButton.setCursor(Cursor.HAND);
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

        levelSelectionPane.setId("difficultyLayer");
        levelSelectionPane.setLayoutX(103.0);
        levelSelectionPane.setLayoutY(97.0);
        levelSelectionPane.setPrefHeight(247.0);
        levelSelectionPane.setPrefWidth(406.0);
        levelSelectionPane.getStylesheets().add("/tictactoe/java/Styles.css");
        levelSelectionPane.setVisible(false);

        easyButton.setLayoutX(132.0);
        easyButton.setLayoutY(238.0);
        easyButton.setMnemonicParsing(false);
        easyButton.setText("Easy Level");
        easyButton.setTextFill(javafx.scene.paint.Color.RED);
        easyButton.setVisible(false);
        easyButton.setFont(new Font("Impact", 16.0));
        easyButton.setCursor(Cursor.HAND);
        easyButton.setOnAction(new EventHandler<ActionEvent>() {
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

        easyImage.setFitHeight(78.0);
        easyImage.setFitWidth(78.0);
        easyImage.setLayoutX(138.0);
        easyImage.setLayoutY(167.0);
        easyImage.setPickOnBounds(true);
        easyImage.setPreserveRatio(true);
        easyImage.setVisible(false);
        easyImage.setImage(new Image(getClass().getResource("/res/Easy.png").toExternalForm()));
        easyImage.setCursor(Cursor.HAND);
        easyImage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Parent root=null;
                root = new SingleUserXOScreen();
                Scene scene = new Scene(root);
                Stage stage = (Stage) singlePlayerButton.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
            
        });

        mediumButton.setLayoutX(251.0);
        mediumButton.setLayoutY(238.0);
        mediumButton.setMnemonicParsing(false);
        mediumButton.setText("Medium Level");
        mediumButton.setTextFill(javafx.scene.paint.Color.RED);
        mediumButton.setVisible(false);
        mediumButton.setFont(new Font("Impact", 16.0));
        mediumButton.setCursor(Cursor.HAND);

        mediumImage.setFitHeight(78.0);
        mediumImage.setFitWidth(78.0);
        mediumImage.setLayoutX(269.0);
        mediumImage.setLayoutY(169.0);
        mediumImage.setPickOnBounds(true);
        mediumImage.setPreserveRatio(true);
        mediumImage.setVisible(false);
        mediumImage.setImage(new Image(getClass().getResource("/res/Medium.png").toExternalForm()));
        mediumImage.setCursor(Cursor.HAND);

        hardButton.setLayoutX(392.0);
        hardButton.setLayoutY(238.0);
        hardButton.setMnemonicParsing(false);
        hardButton.setText("Hard Level");
        hardButton.setTextFill(javafx.scene.paint.Color.RED);
        hardButton.setVisible(false);
        hardButton.setFont(new Font("Impact", 16.0));
        hardButton.setCursor(Cursor.HAND);

        hardImage.setFitHeight(78.0);
        hardImage.setFitWidth(78.0);
        hardImage.setLayoutX(400.0);
        hardImage.setLayoutY(169.0);
        hardImage.setPickOnBounds(true);
        hardImage.setPreserveRatio(true);
        hardImage.setVisible(false);
        hardImage.setImage(new Image(getClass().getResource("/res/Hard.png").toExternalForm()));
        hardImage.setCursor(Cursor.HAND);

        levelSelectionHeader.setLayoutX(189.0);
        levelSelectionHeader.setLayoutY(103.0);
        levelSelectionHeader.setText("Select Your Level");
        levelSelectionHeader.setTextFill(javafx.scene.paint.Color.WHITE);
        levelSelectionHeader.setVisible(false);
        levelSelectionHeader.setFont(new Font("Impact", 36.0));

        enterNameLabel.setLayoutX(137.0);
        enterNameLabel.setLayoutY(298.0);
        enterNameLabel.setText("Enter Your Name");
        enterNameLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        enterNameLabel.setVisible(false);
        enterNameLabel.setFont(new Font("Impact", 24.0));

        userNameTextField.setId("TextField");
        userNameTextField.setLayoutX(308.0);
        userNameTextField.setLayoutY(297.0);
        userNameTextField.getStylesheets().add("/tictactoe/java/Styles.css");
        userNameTextField.setVisible(false);
        userNameTextField.setFont(new Font("Impact", 16.0));
        userNameTextField.setCursor(Cursor.TEXT);

        backButton.setFitHeight(44.0);
        backButton.setFitWidth(36.0);
        backButton.setLayoutX(117.0);
        backButton.setLayoutY(108.0);
        backButton.setPickOnBounds(true);
        backButton.setPreserveRatio(true);
        backButton.setVisible(false);
        backButton.setImage(new Image(getClass().getResource("/res/back.png").toExternalForm()));
        backButton.setCursor(Cursor.HAND);
        backButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               hideDifficultyChoices();
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
        getChildren().add(levelSelectionPane);
        getChildren().add(easyButton);
        getChildren().add(easyImage);
        getChildren().add(mediumButton);
        getChildren().add(mediumImage);
        getChildren().add(hardButton);
        getChildren().add(hardImage);
        getChildren().add(levelSelectionHeader);
        getChildren().add(enterNameLabel);
        getChildren().add(userNameTextField);
        getChildren().add(backButton);

    }

    public void showDifficultyChoices(){
        levelSelectionPane.setVisible(true);
        easyButton.setVisible(true);
        easyImage.setVisible(true);
        mediumButton.setVisible(true);
        mediumImage.setVisible(true);
        hardButton.setVisible(true);
        hardImage.setVisible(true);
        levelSelectionHeader.setVisible(true);
        enterNameLabel.setVisible(true);
        userNameTextField.setVisible(true);
        backButton.setVisible(true);
    }

    void hideDifficultyChoices(){
         levelSelectionPane.setVisible(false);
        easyButton.setVisible(false);
        easyImage.setVisible(false);
        mediumButton.setVisible(false);
        mediumImage.setVisible(false);
        hardButton.setVisible(false);
        hardImage.setVisible(false);
        levelSelectionHeader.setVisible(false);
        enterNameLabel.setVisible(false);
        userNameTextField.setVisible(false);
        backButton.setVisible(false);
    }
}

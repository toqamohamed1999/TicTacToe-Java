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
    protected final Button mediumButton;
    protected final Button hardButton;
    protected final Label levelSelectionHeader;
    protected final ImageView backButton;
    protected final ImageView mediumImage;
    protected final ImageView hardImage;
    protected final ImageView easyImage;
    protected final Pane avatarSelectionPane;
    protected final Label AvatarSelectionHeader;
    protected final Label enterNameLabel;
    protected final TextField userNameTextField;
    protected final ImageView maleAvatarImage;
    protected final ImageView femaleAvatarImage;
    protected final ImageView avatarSelectionbackButton;
    protected final Button singlePlayerEnterGameButton;
    protected final Pane errorMassagePane;
    protected final Label enterYourNameLabel;
    protected final Button okButton;
    int playerAvatar;

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
        mediumButton = new Button();
        hardButton = new Button();
        levelSelectionHeader = new Label();
        backButton = new ImageView();
        mediumImage = new ImageView();
        hardImage = new ImageView();
        easyImage = new ImageView();
        avatarSelectionPane = new Pane();
        AvatarSelectionHeader = new Label();
        enterNameLabel = new Label();
        userNameTextField = new TextField();
        maleAvatarImage = new ImageView();
        femaleAvatarImage = new ImageView();
        avatarSelectionbackButton = new ImageView();
        singlePlayerEnterGameButton = new Button();
        errorMassagePane = new Pane();
        enterYourNameLabel = new Label();
        okButton = new Button();
        playerAvatar=0;

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
        profilePic.setCursor(Cursor.HAND);profilePic.setOnMouseClicked(new EventHandler<MouseEvent>() {
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

        modeSelectLabel.setLayoutX(159.0);
        modeSelectLabel.setLayoutY(38.0);
        modeSelectLabel.setPrefHeight(67.0);
        modeSelectLabel.setPrefWidth(301.0);
        modeSelectLabel.setText("Select Your Mode");
        modeSelectLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        modeSelectLabel.setFont(new Font("Impact", 40.0));

        multiPlayerCirle.setFill(javafx.scene.paint.Color.valueOf("#44a7a1"));
        multiPlayerCirle.setLayoutX(422.0);
        multiPlayerCirle.setLayoutY(223.0);
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
        multiPlayerImage.setLayoutY(183.0);
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
        singlePlayerCircle.setLayoutY(223.0);
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
        singlePlayerImage.setLayoutY(184.0);
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
        singlePlayerButton.setLayoutY(259.0);
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
        multiPlayerButton.setLayoutY(259.0);
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
        levelSelectionPane.setPrefHeight(278.0);
        levelSelectionPane.setPrefWidth(406.0);
        levelSelectionPane.getStylesheets().add("/tictactoe/java/Styles.css");
        levelSelectionPane.setVisible(false);

        easyButton.setLayoutX(119.0);
        easyButton.setLayoutY(285.0);
        easyButton.setMnemonicParsing(false);
        easyButton.setPrefHeight(33.0);
        easyButton.setPrefWidth(112.0);
        easyButton.setText("Easy Level");
        easyButton.setTextFill(javafx.scene.paint.Color.RED);
        easyButton.setVisible(false);
        easyButton.setFont(new Font("Impact", 16.0));
        easyButton.setCursor(Cursor.HAND);
        easyButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showAvatarSelectionPanel();
            }   
        });

        mediumButton.setLayoutX(251.0);
        mediumButton.setLayoutY(285.0);
        mediumButton.setMnemonicParsing(false);
        mediumButton.setPrefHeight(33.0);
        mediumButton.setPrefWidth(112.0);
        mediumButton.setText("Medium Level");
        mediumButton.setTextFill(javafx.scene.paint.Color.RED);
        mediumButton.setVisible(false);
        mediumButton.setFont(new Font("Impact", 16.0));
        mediumButton.setCursor(Cursor.HAND);
                mediumButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showAvatarSelectionPanel();
            }           
        });

        hardButton.setLayoutX(380.0);
        hardButton.setLayoutY(285.0);
        hardButton.setMnemonicParsing(false);
        hardButton.setPrefHeight(33.0);
        hardButton.setPrefWidth(112.0);
        hardButton.setText("Hard Level");
        hardButton.setTextFill(javafx.scene.paint.Color.RED);
        hardButton.setVisible(false);
        hardButton.setFont(new Font("Impact", 16.0));
        hardButton.setCursor(Cursor.HAND);
        hardButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showAvatarSelectionPanel();
            } 
        });

        levelSelectionHeader.setLayoutX(189.0);
        levelSelectionHeader.setLayoutY(103.0);
        levelSelectionHeader.setText("Select Your Level");
        levelSelectionHeader.setTextFill(javafx.scene.paint.Color.WHITE);
        levelSelectionHeader.setVisible(false);
        levelSelectionHeader.setFont(new Font("Impact", 36.0));

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

        mediumImage.setFitHeight(102.0);
        mediumImage.setFitWidth(102.0);
        mediumImage.setLayoutX(256.0);
        mediumImage.setLayoutY(191.0);
        mediumImage.setPickOnBounds(true);
        mediumImage.setPreserveRatio(true);
        mediumImage.setVisible(false);
        mediumImage.setImage(new Image(getClass().getResource("/res/Medium.png").toExternalForm()));
        mediumImage.setCursor(Cursor.HAND);
        mediumImage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               showAvatarSelectionPanel();
            }  
        });

        hardImage.setFitHeight(102.0);
        hardImage.setFitWidth(102.0);
        hardImage.setLayoutX(385.0);
        hardImage.setLayoutY(191.0);
        hardImage.setPickOnBounds(true);
        hardImage.setPreserveRatio(true);
        hardImage.setVisible(false);
        hardImage.setImage(new Image(getClass().getResource("/res/Hard.png").toExternalForm()));
        hardImage.setCursor(Cursor.HAND);
        hardImage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               showAvatarSelectionPanel();
            }  
        });

        easyImage.setFitHeight(81029.0);
        easyImage.setFitWidth(102.0);
        easyImage.setLayoutX(125.0);
        easyImage.setLayoutY(191.0);
        easyImage.setPickOnBounds(true);
        easyImage.setPreserveRatio(true);
        easyImage.setVisible(false);
        easyImage.setImage(new Image(getClass().getResource("/res/Easy.png").toExternalForm()));
        easyImage.setCursor(Cursor.HAND);
        easyImage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               showAvatarSelectionPanel();
            }  
        });

        avatarSelectionPane.setId("avatarSelectionLayerSinglePlayer");
        avatarSelectionPane.setLayoutX(125.0);
        avatarSelectionPane.setLayoutY(108.0);
        avatarSelectionPane.setPrefHeight(253.0);
        avatarSelectionPane.setPrefWidth(365.0);
        avatarSelectionPane.setVisible(false);

        AvatarSelectionHeader.setLayoutX(188.0);
        AvatarSelectionHeader.setLayoutY(111.0);
        AvatarSelectionHeader.setText("Select Your Avatar");
        AvatarSelectionHeader.setTextFill(javafx.scene.paint.Color.WHITE);
        AvatarSelectionHeader.setVisible(false);
        AvatarSelectionHeader.setFont(new Font("Impact", 36.0));

        enterNameLabel.setLayoutX(135.0);
        enterNameLabel.setLayoutY(268.0);
        enterNameLabel.setText("Enter Your Name");
        enterNameLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        enterNameLabel.setVisible(false);
        enterNameLabel.setFont(new Font("Impact", 24.0));

        userNameTextField.setId("TextField");
        userNameTextField.setLayoutX(306.0);
        userNameTextField.setLayoutY(267.0);
        userNameTextField.getStylesheets().add("/tictactoe/java/Styles.css");
        userNameTextField.setVisible(false);
        userNameTextField.setFont(new Font("Impact", 16.0));
        userNameTextField.setCursor(Cursor.TEXT);

        maleAvatarImage.setFitHeight(114.0);
        maleAvatarImage.setFitWidth(102.0);
        maleAvatarImage.setLayoutX(174.0);
        maleAvatarImage.setLayoutY(160.0);
        maleAvatarImage.setPickOnBounds(true);
        maleAvatarImage.setPreserveRatio(true);
        maleAvatarImage.setVisible(false);
        maleAvatarImage.setImage(new Image(getClass().getResource("/res/man.png").toExternalForm()));
        maleAvatarImage.setCursor(Cursor.HAND);
        maleAvatarImage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                maleAvatarImage.setFitHeight(117.0);
                maleAvatarImage.setFitWidth(105.0);
                playerAvatar=1;
                femaleAvatarImage.setFitHeight(99.0);
                femaleAvatarImage.setFitWidth(102.0);
            }  
        });


        femaleAvatarImage.setFitHeight(99.0);
        femaleAvatarImage.setFitWidth(102.0);
        femaleAvatarImage.setLayoutX(354.0);
        femaleAvatarImage.setLayoutY(160.0);
        femaleAvatarImage.setPickOnBounds(true);
        femaleAvatarImage.setPreserveRatio(true);
        femaleAvatarImage.setVisible(false);
        femaleAvatarImage.setImage(new Image(getClass().getResource("/res/woman.png").toExternalForm()));
        femaleAvatarImage.setCursor(Cursor.HAND);
        femaleAvatarImage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                femaleAvatarImage.setFitHeight(102.0);
                femaleAvatarImage.setFitWidth(105.0);
                playerAvatar=2;
                maleAvatarImage.setFitHeight(114.0);
                maleAvatarImage.setFitWidth(102.0);
            }  
        });

        avatarSelectionbackButton.setFitHeight(44.0);
        avatarSelectionbackButton.setFitWidth(36.0);
        avatarSelectionbackButton.setLayoutX(135.0);
        avatarSelectionbackButton.setLayoutY(115.0);
        avatarSelectionbackButton.setPickOnBounds(true);
        avatarSelectionbackButton.setPreserveRatio(true);
        avatarSelectionbackButton.setVisible(false);
        avatarSelectionbackButton.setImage(new Image(getClass().getResource("/res/back.png").toExternalForm()));
        avatarSelectionbackButton.setCursor(Cursor.HAND);
        avatarSelectionbackButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               hideAvatarSelectionPanel();
            }
            
        });

        singlePlayerEnterGameButton.setLayoutX(240.0);
        singlePlayerEnterGameButton.setLayoutY(309.0);
        singlePlayerEnterGameButton.setMnemonicParsing(false);
        singlePlayerEnterGameButton.setText("Enter Game");
        singlePlayerEnterGameButton.setTextFill(javafx.scene.paint.Color.RED);
        singlePlayerEnterGameButton.setVisible(false);
        singlePlayerEnterGameButton.setFont(new Font("Impact", 22.0));
        singlePlayerEnterGameButton.setCursor(Cursor.HAND);
        singlePlayerEnterGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(userNameTextField.getText().equals("")){
                    showErrorMassage();
                }
                else{
                    Parent root=null;
                    EasyMode easyMode = new EasyMode(userNameTextField.getText(),playerAvatar);
                    root = easyMode.board;
                    Scene scene = new Scene(root);
                    Stage stage = (Stage) singlePlayerEnterGameButton.getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                }
            }
            
        });
        
        errorMassagePane.setId("errorMassagePane");
        errorMassagePane.setLayoutX(161.0);
        errorMassagePane.setLayoutY(182.0);
        errorMassagePane.setPrefHeight(146.0);
        errorMassagePane.setPrefWidth(293.0);
        errorMassagePane.setVisible(false);

        enterYourNameLabel.setLayoutX(182.0);
        enterYourNameLabel.setLayoutY(207.0);
        enterYourNameLabel.setText("Please Enter Your Name First");
        enterYourNameLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        enterYourNameLabel.setVisible(false);
        enterYourNameLabel.setFont(new Font("Impact", 21.0));

        okButton.setLayoutX(265.0);
        okButton.setLayoutY(271.0);
        okButton.setMnemonicParsing(false);
        okButton.setPrefWidth(80.0);
        okButton.setText("OK");
        okButton.setTextFill(javafx.scene.paint.Color.valueOf("#fc0000"));
        okButton.setVisible(false);
        okButton.setFont(new Font("Impact", 21.0));
        okButton.setCursor(Cursor.HAND);
        okButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    hideErrorMassage();
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
        getChildren().add(mediumButton);
        getChildren().add(hardButton);
        getChildren().add(levelSelectionHeader);
        getChildren().add(backButton);
        getChildren().add(mediumImage);
        getChildren().add(hardImage);
        getChildren().add(easyImage);
        getChildren().add(avatarSelectionPane);
        getChildren().add(AvatarSelectionHeader);
        getChildren().add(enterNameLabel);
        getChildren().add(userNameTextField);
        getChildren().add(maleAvatarImage);
        getChildren().add(femaleAvatarImage);
        getChildren().add(avatarSelectionbackButton);
        getChildren().add(singlePlayerEnterGameButton);
        getChildren().add(errorMassagePane);
        getChildren().add(enterYourNameLabel);
        getChildren().add(okButton);

    }
    
    void showDifficultyChoices(){
        levelSelectionPane.setVisible(true);
        easyButton.setVisible(true);
        easyImage.setVisible(true);
        mediumButton.setVisible(true);
        mediumImage.setVisible(true);
        hardButton.setVisible(true);
        hardImage.setVisible(true);
        levelSelectionHeader.setVisible(true);
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
        backButton.setVisible(false);
    }
    
    void showAvatarSelectionPanel(){
        avatarSelectionPane.setVisible(true);
        AvatarSelectionHeader.setVisible(true);
        enterNameLabel.setVisible(true);
        userNameTextField.setVisible(true);
        maleAvatarImage.setVisible(true);
        femaleAvatarImage.setVisible(true);
        avatarSelectionbackButton.setVisible(true);
        singlePlayerEnterGameButton.setVisible(true);
    }
    
    void hideAvatarSelectionPanel(){
        avatarSelectionPane.setVisible(false);
        AvatarSelectionHeader.setVisible(false);
        enterNameLabel.setVisible(false);
        userNameTextField.setVisible(false);
        maleAvatarImage.setVisible(false);
        femaleAvatarImage.setVisible(false);
        avatarSelectionbackButton.setVisible(false);
        singlePlayerEnterGameButton.setVisible(false);
    }
    
    void showErrorMassage(){
        errorMassagePane.setVisible(true);
        enterYourNameLabel.setVisible(true);
        okButton.setVisible(true);
    }
    
    
    void hideErrorMassage(){
        errorMassagePane.setVisible(false);
        enterYourNameLabel.setVisible(false);
        okButton.setVisible(false);
    }
}

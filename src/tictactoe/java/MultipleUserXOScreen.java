package tictactoe.java;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MultipleUserXOScreen extends AnchorPane {

    protected final ImageView user2ImageView;
    protected final ImageView user1ImageView;
    protected final Text user1NameText;
    protected final Text user2NameText;
    protected final Button recordIndicatorButton;
    protected final ImageView recordIndicatorImageView;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final Button recordGameButton;
    protected final ImageView backImageView;
    protected final ImageView logoImageView;
    protected final Button oButton;
    protected final ImageView oImageView;
    protected final Button xButton;
    protected final ImageView xImageView;

    public MultipleUserXOScreen() {

        user2ImageView = new ImageView();
        user1ImageView = new ImageView();
        user1NameText = new Text();
        user2NameText = new Text();
        recordIndicatorButton = new Button();
        recordIndicatorImageView = new ImageView();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        recordGameButton = new Button();
        backImageView = new ImageView();
        logoImageView = new ImageView();
        oButton = new Button();
        oImageView = new ImageView();
        xButton = new Button();
        xImageView = new ImageView();

        setId("AnchorPane");
        setPrefHeight(430.0);
        setPrefWidth(600.0);
        getStylesheets().add("/tictactoe/java/Styles.css");

        user2ImageView.setFitHeight(87.0);
        user2ImageView.setFitWidth(94.0);
        user2ImageView.setId("user2ImageView");
        user2ImageView.setLayoutX(479.0);
        user2ImageView.setLayoutY(148.0);
        user2ImageView.setPickOnBounds(true);
        user2ImageView.setPreserveRatio(true);
        user2ImageView.setImage(new Image(getClass().getResource("/res/profile.png").toExternalForm()));

        user1ImageView.setFitHeight(87.0);
        user1ImageView.setFitWidth(94.0);
        user1ImageView.setId("user1ImageView");
        user1ImageView.setLayoutX(43.0);
        user1ImageView.setLayoutY(148.0);
        user1ImageView.setPickOnBounds(true);
        user1ImageView.setPreserveRatio(true);
        user1ImageView.setImage(new Image(getClass().getResource("/res/profile.png").toExternalForm()));

        user1NameText.setFill(javafx.scene.paint.Color.WHITE);
        user1NameText.setId("user1Text");
        user1NameText.setLayoutX(61.0);
        user1NameText.setLayoutY(138.0);
        user1NameText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        user1NameText.setStrokeWidth(0.0);
        user1NameText.setText("User1");
        user1NameText.setWrappingWidth(51.999998331069946);
        user1NameText.setFont(new Font("Impact", 20.0));

        user2NameText.setFill(javafx.scene.paint.Color.WHITE);
        user2NameText.setId("user2Text");
        user2NameText.setLayoutX(494.0);
        user2NameText.setLayoutY(137.0);
        user2NameText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        user2NameText.setStrokeWidth(0.0);
        user2NameText.setText("User2");
        user2NameText.setWrappingWidth(51.999998331069946);
        user2NameText.setFont(new Font("Impact", 20.0));

        recordIndicatorButton.setId("recordIndicatorButton");
        recordIndicatorButton.setLayoutX(520.0);
        recordIndicatorButton.setLayoutY(23.0);
        recordIndicatorButton.setMnemonicParsing(false);
        recordIndicatorButton.setPrefHeight(25.0);
        recordIndicatorButton.setPrefWidth(71.0);
        recordIndicatorButton.setVisible(false);

        recordIndicatorImageView.setFitHeight(50.0);
        recordIndicatorImageView.setFitWidth(52.0);
        recordIndicatorImageView.setId("recordImageView");
        recordIndicatorImageView.setLayoutX(530.0);
        recordIndicatorImageView.setLayoutY(11.0);
        recordIndicatorImageView.setPickOnBounds(true);
        recordIndicatorImageView.setPreserveRatio(true);
        recordIndicatorImageView.setImage(new Image(getClass().getResource("/res/record.png").toExternalForm()));
        recordIndicatorImageView.setVisible(false);
        
        recordGameButton.setId("recordGameButton");
        recordGameButton.setLayoutX(250.0);
        recordGameButton.setLayoutY(341.0);
        recordGameButton.setMnemonicParsing(false);
        recordGameButton.setPrefHeight(51.0);
        recordGameButton.setPrefWidth(118.0);
        recordGameButton.setText("Record Game");
        recordGameButton.setTextFill(javafx.scene.paint.Color.valueOf("#e81111"));
        recordGameButton.setFont(new Font("Impact", 14.0));
        recordGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                recordIndicatorImageView.setVisible(true);
                recordIndicatorButton.setVisible(true);
            }
        });

        backImageView.setFitHeight(53.0);
        backImageView.setFitWidth(50.0);
        backImageView.setId("backImageView");
        backImageView.setLayoutX(30.0);
        backImageView.setLayoutY(21.0);
        backImageView.setPickOnBounds(true);
        backImageView.setPreserveRatio(true);
        backImageView.setImage(new Image(getClass().getResource("/res/back.png").toExternalForm()));
        backImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Parent root=null;
                root = new multiPlayerScreen();
                Scene scene = new Scene(root);
                Stage stage = (Stage) backImageView.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
        });

        logoImageView.setFitHeight(75.0);
        logoImageView.setFitWidth(304.0);
        logoImageView.setId("logoImageView");
        logoImageView.setLayoutX(187.0);
        logoImageView.setLayoutY(22.0);
        logoImageView.setPickOnBounds(true);
        logoImageView.setPreserveRatio(true);
        logoImageView.setImage(new Image(getClass().getResource("/res/Horizontal.png").toExternalForm()));
        logoImageView.setVisible(false);

        oButton.setId("oButton");
        oButton.setLayoutX(467.0);
        oButton.setLayoutY(222.0);
        oButton.setMnemonicParsing(false);
        oButton.setPrefHeight(40.0);
        oButton.setPrefWidth(105.0);

        oImageView.setFitHeight(33.0);
        oImageView.setFitWidth(27.0);
        oImageView.setId("oImageView");
        oImageView.setLayoutX(508.0);
        oImageView.setLayoutY(226.0);
        oImageView.setPickOnBounds(true);
        oImageView.setPreserveRatio(true);
        oImageView.setImage(new Image(getClass().getResource("/res/O.png").toExternalForm()));

        xButton.setId("xButton");
        xButton.setLayoutX(32.0);
        xButton.setLayoutY(222.0);
        xButton.setMnemonicParsing(false);
        xButton.setPrefHeight(40.0);
        xButton.setPrefWidth(105.0);

        xImageView.setFitHeight(33.0);
        xImageView.setFitWidth(22.0);
        xImageView.setId("xImageView");
        xImageView.setLayoutX(73.0);
        xImageView.setLayoutY(226.0);
        xImageView.setPickOnBounds(true);
        xImageView.setPreserveRatio(true);
        xImageView.setImage(new Image(getClass().getResource("/res/X.png").toExternalForm()));

        
        gridPane.setGridLinesVisible(true);
        gridPane.setId("xoGridPane");
        gridPane.setLayoutX(158.0);
        gridPane.setLayoutY(111.0);
        gridPane.setPrefHeight(201.0);
        gridPane.setPrefWidth(284.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);
        
        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(100.0);

        rowConstraints.setMaxHeight(75.0);
        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(68.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMaxHeight(75.0);
        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(68.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMaxHeight(75.0);
        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(66.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        gridPane.setStyle("-fx-padding: 0;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 10;"
                + "-fx-border-insets: 0;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: blue;");
        gridPane.getStyleClass().add("mygridStyle");

        Image image = new Image(getClass().getResourceAsStream("/res/X.png"), 40, 40, true, true);
        ImageView imageView9 = new ImageView(image);
        gridPane.add(imageView9, 0, 0, 1, 1);
        GridPane.setHalignment(imageView9, HPos.CENTER);

        getChildren().add(user2ImageView);
        getChildren().add(user1ImageView);
        getChildren().add(user1NameText);
        getChildren().add(user2NameText);
        getChildren().add(recordIndicatorButton);
        getChildren().add(recordIndicatorImageView);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        getChildren().add(gridPane);
        getChildren().add(recordGameButton);
        getChildren().add(backImageView);
        getChildren().add(logoImageView);
        getChildren().add(oButton);
        getChildren().add(oImageView);
        getChildren().add(xButton);
        getChildren().add(xImageView);

    }
}

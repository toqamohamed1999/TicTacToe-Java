package tictactoe.java;

import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class DisplayRecordScreen extends AnchorPane {

    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final ImageView backImageView;
    protected final ImageView logoImageView;
    protected final Button youPlayedButton;
    protected final ImageView xPlayedImageView;
    protected final Text youPlayedText;

    public DisplayRecordScreen() {

        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        backImageView = new ImageView();
        logoImageView = new ImageView();
        youPlayedButton = new Button();
        xPlayedImageView = new ImageView();
        youPlayedText = new Text();

        setId("AnchorPane");
        setLayoutX(-1.0);
        setPrefHeight(430.0);
        setPrefWidth(600.0);
        getStylesheets().add("/tictactoe/java/Styles.css");

        gridPane.setGridLinesVisible(true);
        gridPane.setId("xoGridPane");
        gridPane.setLayoutX(165.0);
        gridPane.setLayoutY(140.0);
        gridPane.setPrefHeight(185.0);
        gridPane.setPrefWidth(280.0);

        backImageView.setFitHeight(53.0);
        backImageView.setFitWidth(50.0);
        backImageView.setId("backImageView");
        backImageView.setLayoutX(30.0);
        backImageView.setLayoutY(21.0);
        backImageView.setPickOnBounds(true);
        backImageView.setPreserveRatio(true);	
        backImageView.setImage(new Image(getClass().getResource("/res/back.png").toExternalForm()));

        logoImageView.setId("logoImageView");
        logoImageView.setFitHeight(83.0);
        logoImageView.setFitWidth(380.0);
        logoImageView.setLayoutX(165.0);
        logoImageView.setLayoutY(30.0);
        logoImageView.setImage(new Image(getClass().getResource("/res/Horizontal.png").toExternalForm()));

        youPlayedButton.setId("youPlayedButton");
        youPlayedButton.setLayoutX(145.0);
        youPlayedButton.setLayoutY(350.0);
        youPlayedButton.setMnemonicParsing(false);
        youPlayedButton.setPrefHeight(33.0);
        youPlayedButton.setPrefWidth(316.0);

        xPlayedImageView.setFitHeight(33.0);
        xPlayedImageView.setFitWidth(19.0);
        xPlayedImageView.setId("xImageView");
        xPlayedImageView.setLayoutX(414.0);
        xPlayedImageView.setLayoutY(352.0);
        xPlayedImageView.setPickOnBounds(true);
        xPlayedImageView.setPreserveRatio(true);
        xPlayedImageView.setImage(new Image(getClass().getResource("/res/X.png").toExternalForm()));

        youPlayedText.setFill(javafx.scene.paint.Color.valueOf("#da1717"));
        youPlayedText.setId("youPlayedText");
        youPlayedText.setLayoutX(164.0);
        youPlayedText.setLayoutY(375.0);
        youPlayedText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        youPlayedText.setStrokeWidth(0.0);
        youPlayedText.setText("You played This game as ");
        youPlayedText.setWrappingWidth(253.0000001192093);
        youPlayedText.setFont(new Font("Impact", 24.0));
        
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
        rowConstraints.setPrefHeight(60.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMaxHeight(68.0);
        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(60.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(50.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
        
        gridPane.setStyle("-fx-padding: 0;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 10;"
                + "-fx-border-insets: 0;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: blue;");
        gridPane.getStyleClass().add("mygridStyle");

        Image image = new Image(getClass().getResourceAsStream("/res/X.png"), 35, 35, true, true);
        ImageView imageView9 = new ImageView(image);
        gridPane.add(imageView9, 0, 0, 1, 1);
        GridPane.setHalignment(imageView9, HPos.CENTER);

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        getChildren().add(gridPane);
        getChildren().add(backImageView);
        getChildren().add(logoImageView);
        getChildren().add(youPlayedButton);
        getChildren().add(xPlayedImageView);
        getChildren().add(youPlayedText);

    }
}

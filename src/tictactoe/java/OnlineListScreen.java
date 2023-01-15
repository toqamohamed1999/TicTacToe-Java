package tictactoe.java;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class OnlineListScreen extends AnchorPane {

    protected final Label onlineListLabel;
    public final ListView onlineListView;
    protected final ImageView back;
    public final ImageView profilePic;
    public final Button refresh;

    public OnlineListScreen() {

        onlineListLabel = new Label();
        onlineListView = new ListView();
        back = new ImageView();
        profilePic = new ImageView();
        refresh = new Button();

        setId("AnchorPane");
        setPrefHeight(430.0);
        setPrefWidth(600.0);
        getStylesheets().add("/tictactoe/java/Styles.css");

        onlineListLabel.setLayoutX(198.0);
        onlineListLabel.setLayoutY(43.0);
        onlineListLabel.setPrefHeight(53.0);
        onlineListLabel.setPrefWidth(194.0);
        onlineListLabel.setText("Online List");
        onlineListLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        onlineListLabel.setFont(new Font("Impact", 42.0));

        onlineListView.setLayoutX(192.0);
        onlineListView.setLayoutY(123.0);
        onlineListView.setPrefHeight(266.0);
        onlineListView.setPrefWidth(204.0);

        back.setFitHeight(53.0);
        back.setFitWidth(50.0);
        back.setLayoutX(30.0);
        back.setLayoutY(21.0);
        back.setPickOnBounds(true);
        back.setPreserveRatio(true);
        back.setImage(new Image(getClass().getResource("/res/back.png").toExternalForm()));
        back.setOnMouseClicked((MouseEvent e) -> {
                TicTacToeJava.stage.setScene(new Scene(new HomeScreen()));
        });
        refresh.setLayoutX(420.0);
        refresh.setLayoutY(360.0);
        refresh.setMnemonicParsing(false);
        refresh.setPrefHeight(25.0);
        refresh.setPrefWidth(120.0);
        refresh.setText("Refresh");
        refresh.setTextFill(javafx.scene.paint.Color.valueOf("#f9002d"));
        refresh.setFont(new Font("Impact", 24.0));
      

        profilePic.setFitHeight(57.0);
        profilePic.setFitWidth(66.0);
        profilePic.setLayoutX(520.0);
        profilePic.setLayoutY(21.0);
        profilePic.setPickOnBounds(true);
        profilePic.setPreserveRatio(true);

        profilePic.setCursor(Cursor.HAND);

        profilePic.setImage(new Image(getClass().getResource("/res/profile.png").toExternalForm()));

        
        getChildren().add(onlineListLabel);
        getChildren().add(onlineListView);
        getChildren().add(back);
        getChildren().add(profilePic);
        getChildren().add(refresh);

    }
}

package tictactoe.java;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    protected final ListView onlineListView;
    protected final ImageView back;

    public OnlineListScreen() {

        onlineListLabel = new Label();
        onlineListView = new ListView();
        back = new ImageView();

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
        for(int i =1;i<=20;i++ ) {
            onlineListView.getItems().add("User "+i);
        }
        onlineListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Parent root;
                root = new OnlineUserXOScreen();
                Scene scene = new Scene(root);
                Stage stage = (Stage) onlineListView.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
        });

        back.setFitHeight(53.0);
        back.setFitWidth(50.0);
        back.setLayoutX(30.0);
        back.setLayoutY(21.0);
        back.setPickOnBounds(true);
        back.setPreserveRatio(true);
        back.setImage(new Image(getClass().getResource("/res/back.png").toExternalForm()));
        back.setOnMouseClicked((MouseEvent e) -> {     
            Parent root;
            root = new HomeScreen();
            Scene scene = new Scene(root);
            Stage stage = (Stage) back.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        });

        getChildren().add(onlineListLabel);
        getChildren().add(onlineListView);
        getChildren().add(back);

    }
}

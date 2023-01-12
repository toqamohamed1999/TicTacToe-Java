package tictactoe.java;

import java.io.File;
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
import logic.recordLogic;

public class RecordsListScreen extends AnchorPane {

    protected final Label recordListLabel;
    protected final ListView recordListView;
    protected final ImageView back;
    recordLogic rec;

    public RecordsListScreen() {

        recordListLabel = new Label();
        recordListView = new ListView();
        back = new ImageView();
        rec=new recordLogic();

        setId("AnchorPane");
        setPrefHeight(430.0);
        setPrefWidth(600.0);
        getStylesheets().add("/tictactoe/java/Styles.css");

        recordListLabel.setLayoutX(198.0);
        recordListLabel.setLayoutY(43.0);
        recordListLabel.setPrefHeight(53.0);
        recordListLabel.setPrefWidth(194.0);
        recordListLabel.setText("Record List");
        recordListLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        recordListLabel.setFont(new Font("Impact", 42.0));

        recordListView.setLayoutX(192.0);
        recordListView.setLayoutY(123.0);
        recordListView.setPrefHeight(266.0);
        recordListView.setPrefWidth(250.0);
        String path = "C:" + File.separator + "TicTacToe";
        String records[]=rec.getAllFiles(path);
        if(records!=null){
            for(int i =0;i<records.length;i++ ) {
                recordListView.getItems().add(records[i]);
            }
        }
        
        recordListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("clicked on " + recordListView.getSelectionModel().getSelectedItem());
                
                Parent root=null;
                String path = "C:" + File.separator + "TicTacToe" +File.separator+recordListView.getSelectionModel().getSelectedItem();
                root = new DisplayRecordScreen(path);
                Scene scene = new Scene(root);
                Stage stage = (Stage) recordListView.getScene().getWindow();
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

        getChildren().add(recordListLabel);
        getChildren().add(recordListView);
        getChildren().add(back);

    }
}

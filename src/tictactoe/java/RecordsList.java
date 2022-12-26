package tictactoe.java;

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

public class RecordsList extends AnchorPane {

    protected final Label label;
    protected final ImageView back;
    protected final ListView recordListView;

    public RecordsList() {

        label = new Label();
        back = new ImageView();
        recordListView = new ListView();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        getStylesheets().add("/tictactoe/java/Styles.css");

        label.setLayoutX(200.0);
        label.setLayoutY(32.0);
        label.setPrefHeight(49.0);
        label.setPrefWidth(255.0);
        label.setText("Record List");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#ffffff"));
        label.setFont(new Font("Impact", 42.0));
        
        
        back.setLayoutX(30.0);
        back.setLayoutY(21.0);
        back.setFitHeight(32.0); 
        back.setPickOnBounds(true);
        back.setPreserveRatio(true);
        back.setImage(new Image(getClass().getResource("Res/back.png").toExternalForm()));

        recordListView.setLayoutX(197.0);
        recordListView.setLayoutY(104.0);
        recordListView.setPrefHeight(257.0);  
        recordListView.setPrefWidth(230.0);
        
      //  recordListView.setEditable(true);
 
        //recordListView.setBackground(Background.EMPTY);
       // recordListView.setOpacity(0.4);
       // recordListView.setVisible(false);
       
       for(int i =1;i<=20;i++ ) {
        recordListView.getItems().add("Item "+i);
       }
        

        getChildren().add(label);
        getChildren().add(back);
        getChildren().add(recordListView);
        
        
        
            
        back.setOnMouseClicked((MouseEvent e) -> {
           
            Parent root;
            root = new OnlineList();
            Scene scene = new Scene(root);
            Stage stage = (Stage) back.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        });

    }
}

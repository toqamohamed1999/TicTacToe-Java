package tictactoe.java;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLDocumentBase extends AnchorPane  {

    protected final Label label;
    protected final ImageView imageView;

    public FXMLDocumentBase() {

        label = new Label();
        imageView = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);

        label.setLayoutX(126);
        label.setLayoutY(120);
        label.setMinHeight(16);
        label.setMinWidth(69);
        
        

        imageView.fitWidthProperty().bind(this.widthProperty());
        imageView.fitHeightProperty().bind(this.heightProperty());
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(false);
        imageView.setImage(new Image(getClass().getResource("1.JPG").toExternalForm()));
        

        getChildren().add(label);
        getChildren().add(imageView);
        

    }
   
}

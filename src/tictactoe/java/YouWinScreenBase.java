package tictactoe.java;

import java.nio.file.Paths;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class YouWinScreenBase extends BorderPane {

    protected final MediaView YouWinMediaView;

    public YouWinScreenBase() {

        YouWinMediaView = new MediaView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        getStylesheets().add("/tictactoe/java/Styles.css");

        BorderPane.setAlignment(YouWinMediaView, javafx.geometry.Pos.CENTER);
        YouWinMediaView.setFitHeight(250.0);
        YouWinMediaView.setFitWidth(600.0);
        setCenter(YouWinMediaView);
        
        String Vurl=Paths.get("C:/Users/Monica/Downloads/WhatsApp Video 2022-12-25 at 11.26.45 PM.mp4").toUri().toString();
        Media media=new Media(Vurl);
        MediaPlayer mp=new MediaPlayer(media);
        mp.setAutoPlay(true);
        YouWinMediaView.setMediaPlayer(mp);
        
        YouWinMediaView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Parent root=new HomeScreen();
                Scene scene = new Scene(root);
                Stage stage = (Stage) YouWinMediaView.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
        });

    }
}

package tictactoe.java;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class YouWinScreenBase extends BorderPane {

    protected final MediaView YouWinMediaView;

    public YouWinScreenBase() {
        
        YouWinMediaView = new MediaView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(430.0);
        setPrefWidth(600.0);
        getStylesheets().add("/tictactoe/java/Styles.css");

        BorderPane.setAlignment(YouWinMediaView, javafx.geometry.Pos.CENTER);
        YouWinMediaView.setFitHeight(250.0);
        YouWinMediaView.setFitWidth(600.0);
        setCenter(YouWinMediaView);
        
       String path = "./src/res/YouWinVideo.mp4";  
       Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mp=new MediaPlayer(media);
        mp.setAutoPlay(true);
        YouWinMediaView.setMediaPlayer(mp);
        navigateToResult(); 
    }
    
    public YouWinScreenBase(String state ,int source, String player, int playerAvatar) {
        
        YouWinMediaView = new MediaView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(430.0);
        setPrefWidth(600.0);
        getStylesheets().add("/tictactoe/java/Styles.css");

        BorderPane.setAlignment(YouWinMediaView, javafx.geometry.Pos.CENTER);
        YouWinMediaView.setFitHeight(250.0);
        YouWinMediaView.setFitWidth(600.0);
        setCenter(YouWinMediaView);
        
       String path = "./src/res/YouWinVideo.mp4";  
       Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mp=new MediaPlayer(media);
        mp.setAutoPlay(true);
        YouWinMediaView.setMediaPlayer(mp);
        navigateToResult(state,source,player,playerAvatar); 
    }
    
    private void navigateToResult(String state ,int source, String player, int playerAvatar) {
        ResultLogic win = new ResultLogic(state,source,player,playerAvatar); 

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                TicTacToeJava.stage.setScene(new Scene(win.result));

                    timer.cancel();
                });
            }
        }, 4000, 4000);
    }
    
     private void navigateToResult() {
        ResultLogic win = new ResultLogic("w"); 

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                TicTacToeJava.stage.setScene(new Scene(win.result));

                    timer.cancel();
                });
            }
        }, 4000, 4000);
    }
}

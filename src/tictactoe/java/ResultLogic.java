package tictactoe.java;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Ahmed Abdo
 */

public class ResultLogic {
    ResultScreen rs;
    int state;
    
    public ResultLogic(String player1 , int player1Avatar , String player2 , int player2Avatar , int originNumber){
        rs = new ResultScreen();
        state = originNumber;
        playAgain(player1, player1Avatar, player2, player2Avatar);
        exitGame();
        setPlayer1Pic(player1Avatar);
        setPlayer2Pic(player2Avatar);
        setPlayer1Name(player1);
        setPlayer2Name(player2);
        goHome();
        setResultLabel(player1);
        setResultPic();
        setPlayerLabels();
    }
    
    public void playAgain(String player1 , int player1Avatar , String player2 , int player2Avatar){
        rs.playAgainButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MultiPlayer mp=new MultiPlayer(player1, player1Avatar, player2, player2Avatar);
                Parent root=null;
                root = mp.multi ;
                Scene scene = new Scene(root);
                Stage stage = (Stage) rs.playAgainButton.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
        });
    }
    public void exitGame(){
    rs.exitGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });
    }
    
    public void setPlayer1Pic(int player1Avatar){
        if(player1Avatar==1)rs.player2Pic.setImage(new Image(getClass().getResource("/res/man.png").toExternalForm()));
        else rs.player2Pic.setImage(new Image(getClass().getResource("/res/woman.png").toExternalForm()));
    }
    
    public void setPlayer2Pic(int Player2Avatar){
        if(Player2Avatar==1)rs.player1Pic.setImage(new Image(getClass().getResource("/res/man.png").toExternalForm()));
        else rs.player1Pic.setImage(new Image(getClass().getResource("/res/woman.png").toExternalForm()));
    }
    
    public void setPlayer1Name(String player1){
        rs.player2Name.setText(player1);
    }
    
    public void setPlayer2Name(String player2){
        rs.player1Name.setText(player2);
    }
    
    public void goHome(){
        rs.homeButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Parent root=null;
                root = new HomeScreen() ;
                Scene scene = new Scene(root);
                Stage stage = (Stage) rs.homeButton.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
        });
    }
    
    public void setResultLabel(String winner){     
        if (state==0)rs.resultLabel.setText("Both Too Good");
        else if(state==1)rs.resultLabel.setText(winner + " Wins");
    }

    public void setResultPic(){ 
        if(state==0)rs.resultPic.setImage(new Image(getClass().getResource("/res/draw.png").toExternalForm()));
        else if(state==1)rs.resultPic.setImage(new Image(getClass().getResource("/res/win.png").toExternalForm()));
    }
    
    public void setPlayerLabels(){
        if(state==0){
            rs.player1State.setText("Winner");
            rs.player2State.setText("Winner");
        }else if(state==1){
            rs.player1State.setText("Loser");
            rs.player2State.setText("Winner");
        }
    }
}

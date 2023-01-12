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
    
    public ResultScreen rs;
    int state;
    int sourceMode;
    char winner;
    String statusletter;
    
    public ResultLogic(String stateLetter , int source , String name , int playerAvatar) {
        rs = new ResultScreen();
        sourceMode=source;
        exitGame();
        goHome();
        hideLabels();
        statusletter=stateLetter;
        checkAndShow(statusletter);
        playAgain(name, playerAvatar);
    }

    public ResultLogic(String stateLetter) {
        rs = new ResultScreen();
        exitGame();
        goHome();
        hideLabels();
        statusletter=stateLetter;
        checkAndShow(statusletter);       
    }
    
     public ResultLogic(String player1 , int player1Avatar , String player2 , int player2Avatar , int originNumber , int source , char win){
        rs = new ResultScreen();
        state = originNumber;
        sourceMode = source;
        winner = win;
        playAgain(player1, player1Avatar, player2, player2Avatar);
        exitGame();
        setPlayer1Pic(player1Avatar);
        setPlayer2Pic(player2Avatar);
        setPlayer1Name(player1);
        setPlayer2Name(player2);
        goHome();
        setResultLabel(player1,player2);
        setResultPic();
        setPlayerLabels();
    }
    
    public void checkAndShow(String stateLetter){
        if(stateLetter.equals("w")){
            rs.resultLabel.setText("You Win");
            rs.resultPic.setImage(new Image(getClass().getResource("/res/win.png").toExternalForm()));
        }
        if(stateLetter.equals("d")){
            rs.resultLabel.setText("It's a Draw");
            rs.resultPic.setImage(new Image(getClass().getResource("/res/draw.png").toExternalForm()));
        }
        if(stateLetter.equals("l")){
            rs.resultLabel.setText("You lost");
            rs.resultPic.setImage(new Image(getClass().getResource("/res/lost.png").toExternalForm()));
        }
    }
   
    public void hideLabels(){
        rs.player1Pic.setVisible(false);
        rs.player2Pic.setVisible(false);
        rs.player1Name.setVisible(false);
        rs.player2Name.setVisible(false);
        rs.player1CardPane.setVisible(false);
        rs.player2CardPane.setVisible(false);
        rs.player1State.setVisible(false);
        rs.player2State.setVisible(false);
    }
    
   
    public void playAgain(String player ,int playerAvatar){
            rs.playAgainButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root=null;
                if(sourceMode==1){
                    EasyMode easyMode = new EasyMode(player , playerAvatar , "Computer" , 3);
                    root = easyMode.board;
                }
                if(sourceMode==3){
                    HardMode hardMode = new HardMode(player , playerAvatar , "Computer" , 5);
                    root = hardMode.board;
                }
               
                Scene scene = new Scene(root);
                Stage stage = (Stage) rs.playAgainButton.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
        });

    }
    
    public void playAgain(String player1 , int player1Avatar , String player2 , int player2Avatar){
        rs.playAgainButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root=null;
                System.out.println(sourceMode);
                if(sourceMode==1){
                    EasyMode easyMode = new EasyMode(player1,player1Avatar,player2,player2Avatar);
                    root = easyMode.board;
                }
                else if(sourceMode==3){
                    HardMode hardMode=new HardMode(player1, player1Avatar, player2, player2Avatar);
                    root = hardMode.board ;
                }
                else if(sourceMode==4){
                    MultiPlayer mp=new MultiPlayer(player1, player1Avatar, player2, player2Avatar);
                    root = mp.multi ;
                }
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
        if(player1Avatar==1)rs.player1Pic.setImage(new Image(getClass().getResource("/res/man.png").toExternalForm()));
        else if(player1Avatar==2) rs.player1Pic.setImage(new Image(getClass().getResource("/res/woman.png").toExternalForm()));
        else if(player1Avatar==3) rs.player1Pic.setImage(new Image(getClass().getResource("/res/Easy.png").toExternalForm()));
        else if(player1Avatar==5) rs.player1Pic.setImage(new Image(getClass().getResource("/res/Hard.png").toExternalForm()));
    }
    
    public void setPlayer2Pic(int Player2Avatar){
        if(Player2Avatar==1)rs.player2Pic.setImage(new Image(getClass().getResource("/res/man.png").toExternalForm()));
        else if(Player2Avatar==2) rs.player2Pic.setImage(new Image(getClass().getResource("/res/woman.png").toExternalForm()));
        else if(Player2Avatar==3) rs.player2Pic.setImage(new Image(getClass().getResource("/res/Easy.png").toExternalForm()));
        else if(Player2Avatar==5) rs.player2Pic.setImage(new Image(getClass().getResource("/res/Hard.png").toExternalForm()));

    }
    
    public void setPlayer1Name(String player1){
        rs.player1Name.setText(player1);
    }
    
    public void setPlayer2Name(String player2){
        rs.player2Name.setText(player2);
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
    
    public void setResultLabel(String player1, String player2){     
        if (state==0)rs.resultLabel.setText("Both Too Good");
        else if(state==1){
            if(winner=='x')rs.resultLabel.setText(player1 + " Wins");
            else rs.resultLabel.setText(player2 + " Wins");
        }
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
            if(winner=='x'){
                rs.player1State.setText("Winner");
                rs.player2State.setText("Loser");
            }else{
                rs.player1State.setText("Loser");
                rs.player2State.setText("Winner");
            }
        }
    }
}

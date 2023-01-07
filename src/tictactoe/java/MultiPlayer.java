/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.java;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Monica
 */

public class MultiPlayer 
{
    GameBoard multi;
    int sourceMode;
    
    public MultiPlayer(String playerOneName,int playerOneAvatarNumber,String playerTwoName,int playerTwoAvatarNumber) {
         multi=new GameBoard(playerOneName,playerOneAvatarNumber,playerTwoName,playerTwoAvatarNumber);
         record();
         back();
         buttonshandel();
         sourceMode=4;
    }
    
    public void record(){
     multi.recordGameButton.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent event) {
             multi.recordIndicatorImageView.setVisible(true);
             multi.recordIndicatorButton.setVisible(true);
         }
     });   
   }
    
    public void back(){
        multi.backImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Parent root=null;
                root = new multiPlayerScreen();
                Scene scene = new Scene(root);
                Stage stage = (Stage) multi.backImageView.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
        });
    }
    
    public void buttonshandel(){
        multi.button_1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if( multi.button_1.getText().equals("")){
                    setXorO( multi.button_1,multi.button_1Image);
                    TheWinner();
                }
                
            }
        });
        
         multi.button_2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if( multi.button_2.getText().equals("")){
                    setXorO( multi.button_2,multi.button_2Image);
                    TheWinner();
                }
                
            }
        });
         
         multi.button_3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if( multi.button_3.getText().equals("")){
                    setXorO( multi.button_3,multi.button_3Image);
                    TheWinner();
                }
                
            }
        });
         multi.button_4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if( multi.button_4.getText().equals("")){
                    setXorO( multi.button_4,multi.button_4Image);
                    TheWinner();
                }
                
            }
        });
         multi.button_5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if( multi.button_5.getText().equals("")){
                    setXorO( multi.button_5,multi.button_5Image);
                    TheWinner();
                }
                
            }
        });
         multi.button_6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if( multi.button_6.getText().equals("")){
                    setXorO( multi.button_6,multi.button_6Image);
                    TheWinner();
                }
                
            }
        });
         multi.button_7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if( multi.button_7.getText().equals("")){
                    setXorO( multi.button_7,multi.button_7Image);
                    TheWinner();
                }
                
            }
        });
         multi.button_8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if( multi.button_8.getText().equals("")){
                    setXorO( multi.button_8,multi.button_8Image);
                    TheWinner();
                }
                
            }
        });
         multi.button_9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if( multi.button_9.getText().equals("")){
                    setXorO( multi.button_9,multi.button_9Image);
                    TheWinner();
                }
                
            }
        });
        
    }
    
    private void setXorO(Button btn,ImageView iv){
        if(multi.turn%2==0){
            multi.turn++;
            btn.setText("X");
            iv.setImage(new Image(getClass().getResource("/res/X.png").toExternalForm()));

        }
        else{
            multi.turn++;
            btn.setText("O");
            iv.setImage(new Image(getClass().getResource("/res/O.png").toExternalForm()));
        }
    }
    private int XisWinner(){
        multi.counter++;
        if (multi.button_1.getText().equals("X")&&multi.button_2.getText().equals("X")&&multi.button_3.getText().equals("X")){
            return 1;
        }
        if (multi.button_4.getText().equals("X")&&multi.button_5.getText().equals("X")&&multi.button_6.getText().equals("X")){
            return 1;
        }
        if (multi.button_7.getText().equals("X")&&multi.button_8.getText().equals("X")&&multi.button_9.getText().equals("X")){
            return 1;
        }
        if (multi.button_1.getText().equals("X")&&multi.button_4.getText().equals("X")&&multi.button_7.getText().equals("X")){
            return 1;
        }
        if (multi.button_2.getText().equals("X")&&multi.button_5.getText().equals("X")&&multi.button_8.getText().equals("X")){
            return 1;
        }
        if (multi.button_3.getText().equals("X")&&multi.button_6.getText().equals("X")&&multi.button_9.getText().equals("X")){
            return 1;
        }
        if (multi.button_1.getText().equals("X")&&multi.button_5.getText().equals("X")&&multi.button_9.getText().equals("X")){
            return 1;
        }
        if (multi.button_3.getText().equals("X")&&multi.button_5.getText().equals("X")&&multi.button_7.getText().equals("X")){
            return 1;
        }
        else {
            return 0;
        }
    }
     private int OisWinner(){
        if (multi.button_1.getText().equals("O")&&multi.button_2.getText().equals("O")&&multi.button_3.getText().equals("O")){
            return 1;
        }
        if (multi.button_4.getText().equals("O")&&multi.button_5.getText().equals("O")&&multi.button_6.getText().equals("O")){
            return 1;
        }
        if (multi.button_7.getText().equals("O")&&multi.button_8.getText().equals("O")&&multi.button_9.getText().equals("O")){
            return 1;
        }
        if (multi.button_1.getText().equals("O")&&multi.button_4.getText().equals("O")&&multi.button_7.getText().equals("O")){
            return 1;
        }
        if (multi.button_2.getText().equals("O")&&multi.button_5.getText().equals("O")&&multi.button_8.getText().equals("O")){
            return 1;
        }
        if (multi.button_3.getText().equals("O")&&multi.button_6.getText().equals("O")&&multi.button_9.getText().equals("O")){
            return 1;
        }
        if (multi.button_1.getText().equals("O")&&multi.button_5.getText().equals("O")&&multi.button_9.getText().equals("O")){
            return 1;
        }
        if (multi.button_3.getText().equals("O")&&multi.button_5.getText().equals("O")&&multi.button_7.getText().equals("O")){
            return 1;
        }
        else {
            return 0;
        }
    }
    private void navigateToWinner(String player1 ,int player1Avatar , String player2 , int player2avatar , char winnerChar){
        Parent root=null;
        ResultLogic win = new ResultLogic(player1,player1Avatar,player2, player2avatar ,1,sourceMode , winnerChar ); 
        root = win.rs;
        Scene scene = new Scene(root);
        Stage stage = (Stage) multi.backImageView.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    private void TheWinner(){
        int xResult=XisWinner();
        int oResult=OisWinner();
        if(xResult==1){
            navigateToWinner(multi.user1NameText.getText(),multi.player1Avatar,multi.user2NameText.getText(),multi.player2Avatar ,'x');
        }
        else if(oResult==1){
            navigateToWinner(multi.user1NameText.getText(),multi.player1Avatar,multi.user2NameText.getText(),multi.player2Avatar ,'o');
        }
        if(multi.counter==9&&xResult!=1&&oResult!=1){
            Parent root=null;
            ResultLogic draw = new ResultLogic(multi.user1NameText.getText(),multi.player1Avatar,multi.user2NameText.getText(),multi.player2Avatar,0,sourceMode,'d');
            root = draw.rs;
            Scene scene = new Scene(root);
            Stage stage = (Stage) multi.backImageView.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }
    
}

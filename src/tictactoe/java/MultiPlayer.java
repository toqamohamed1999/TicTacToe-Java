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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Monica
 */
public class MultiPlayer 
{
    MultipleUserXOScreenBase multi;
    
    public MultiPlayer() {
         multi=new MultipleUserXOScreenBase();
         record();
         back();
         buttonshandel();
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
                    setXorO( multi.button_1);
                    TheWinner();
                }
                
            }
        });
        
         multi.button_2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if( multi.button_2.getText().equals("")){
                    setXorO( multi.button_2);
                    TheWinner();
                }
                
            }
        });
         
         multi.button_3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if( multi.button_3.getText().equals("")){
                    setXorO( multi.button_3);
                    TheWinner();
                }
                
            }
        });
         multi.button_4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if( multi.button_4.getText().equals("")){
                    setXorO( multi.button_4);
                    TheWinner();
                }
                
            }
        });
         multi.button_5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if( multi.button_5.getText().equals("")){
                    setXorO( multi.button_5);
                    TheWinner();
                }
                
            }
        });
         multi.button_6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if( multi.button_6.getText().equals("")){
                    setXorO( multi.button_6);
                    TheWinner();
                }
                
            }
        });
         multi.button_7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if( multi.button_7.getText().equals("")){
                    setXorO( multi.button_7);
                    TheWinner();
                }
                
            }
        });
         multi.button_8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if( multi.button_8.getText().equals("")){
                    setXorO( multi.button_8);
                    TheWinner();
                }
                
            }
        });
         multi.button_9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if( multi.button_9.getText().equals("")){
                    setXorO( multi.button_9);
                    TheWinner();
                }
                
            }
        });
        
    }
    
    private void setXorO(Button btn){
        if(multi.turn%2==0){
            multi.turn++;
            btn.setText("X");
        }
        else{
            multi.turn++;
            btn.setText("O");
        }
    }
    private int XisWinner(){
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
    private void navigateToWinner(String winnername,String loser){
        Parent root=null;
        //pass winner name and loser name 
        root = new winnerScreen();
        Scene scene = new Scene(root);
        Stage stage = (Stage) multi.backImageView.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    private void TheWinner(){
        int xResult=XisWinner();
        int oResult=OisWinner();
        if(xResult==1){
            navigateToWinner("player1","player2");
        }
        else if(oResult==1){
            navigateToWinner("player2","player1");
        }
    }
    
}

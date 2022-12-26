package tictactoe.java;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ServerScreen extends AnchorPane {

    protected final Button startStopButton;
    protected final Label label;
    protected final PieChart pieChart;

    public ServerScreen() {

        startStopButton = new Button();
        label = new Label();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        getStylesheets().add("/tictactoe/java/Styles.css");
        
        label.setLayoutX(240.0);
        label.setLayoutY(32.0);
        label.setPrefHeight(49.0);
        label.setPrefWidth(255.0);
        label.setText("Server");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#ffffff"));
        label.setFont(new Font("Impact", 42.0));

        startStopButton.setLayoutX(212.0);
        startStopButton.setLayoutY(324.0);
        startStopButton.setMnemonicParsing(false);
        startStopButton.setPrefHeight(25.0);
        startStopButton.setPrefWidth(177.0);
        startStopButton.setText("Start & Stop");
        startStopButton.setTextFill(javafx.scene.paint.Color.valueOf("#f9002d"));
        startStopButton.setFont(new Font("Impact", 20.0));
        
        
        
         startStopButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
          
            Parent root;
            root = new RecordsList();
            //root = new OnlineList();
            Scene scene = new Scene(root);
            Stage stage = (Stage) startStopButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            
            }
        });
        
        
         ObservableList<PieChart.Data> pieData=FXCollections.observableArrayList(
        
           new PieChart.Data("Online", 80),
            new PieChart.Data("Offline", 20)     
        
        );
         
        pieChart = new PieChart(pieData);   
        pieChart.setLegendVisible(false);

        getStylesheets().add("/tictactoe/java/Styles.css");

        pieChart.setLayoutX(130.0);
        pieChart.setLayoutY(70.0);
        pieChart.setPrefHeight(230.0);
        pieChart.setPrefWidth(320.0);

         getChildren().add(label);
        getChildren().add(startStopButton);
        getChildren().add(pieChart);

    }
    
}

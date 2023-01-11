package tictactoe.java;

import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.recordLogic;

public class DisplayRecordScreen extends AnchorPane {

    //protected final GridPane gridPane;
    protected final ImageView button_1Image;
    protected final ImageView button_2Image;
    protected final ImageView button_3Image;
    protected final ImageView button_4Image;
    protected final ImageView button_5Image;
    protected final ImageView button_6Image;
    protected final ImageView button_7Image;
    protected final ImageView button_8Image;
    protected final ImageView button_9Image;
    protected final Button button_1;
    protected final Button button_2;
    protected final Button button_3;
    protected final Button button_4;
    protected final Button button_5;
    protected final Button button_6;
    protected final Button button_7;
    protected final Button button_8;
    protected final Button button_9;
    protected final ImageView backImageView;
    protected final ImageView logoImageView;
    protected final Button youPlayedButton;
    protected final ImageView xPlayedImageView;
    protected final Text youPlayedText;
    recordLogic rec;

    public DisplayRecordScreen(String path) {

        //gridPane = new GridPane();
  
        backImageView = new ImageView();
        logoImageView = new ImageView();
        youPlayedButton = new Button();
        xPlayedImageView = new ImageView();
        youPlayedText = new Text();
        rec=new recordLogic();
        
        
        setId("AnchorPane");
        setLayoutX(-1.0);
        setPrefHeight(430.0);
        setPrefWidth(600.0);
        getStylesheets().add("/tictactoe/java/Styles.css");

//        gridPane.setGridLinesVisible(true);
//        gridPane.setId("xoGridPane");
//        gridPane.setLayoutX(165.0);
//        gridPane.setLayoutY(140.0);
//        gridPane.setPrefHeight(185.0);
//        gridPane.setPrefWidth(280.0);
        button_1Image = new ImageView();
        button_2Image = new ImageView();
        button_3Image = new ImageView();
        button_4Image = new ImageView();
        button_5Image = new ImageView();
        button_6Image = new ImageView();
        button_7Image = new ImageView();
        button_8Image = new ImageView();
        button_9Image = new ImageView();
        button_1 = new Button();
        button_2 = new Button();
        button_3 = new Button();
        button_4 = new Button();
        button_5 = new Button();
        button_6 = new Button();
        button_7 = new Button();
        button_8 = new Button();
        button_9 = new Button();
        backImageView.setFitHeight(53.0);
        backImageView.setFitWidth(50.0);
        backImageView.setId("backImageView");
        backImageView.setLayoutX(30.0);
        backImageView.setLayoutY(21.0);
        backImageView.setPickOnBounds(true);
        backImageView.setPreserveRatio(true);	
        backImageView.setImage(new Image(getClass().getResource("/res/back.png").toExternalForm()));
        backImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Parent root=null;
                root = new RecordsListScreen();
                Scene scene = new Scene(root);
                Stage stage = (Stage) backImageView.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
        });

        logoImageView.setId("logoImageView");
        logoImageView.setFitHeight(83.0);
        logoImageView.setFitWidth(380.0);
        logoImageView.setLayoutX(165.0);
        logoImageView.setLayoutY(30.0);
        logoImageView.setImage(new Image(getClass().getResource("/res/Horizontal.png").toExternalForm()));

        youPlayedButton.setId("youPlayedButton");
        youPlayedButton.setLayoutX(145.0);
        youPlayedButton.setLayoutY(350.0);
        youPlayedButton.setMnemonicParsing(false);
        youPlayedButton.setPrefHeight(33.0);
        youPlayedButton.setPrefWidth(316.0);

        xPlayedImageView.setFitHeight(33.0);
        xPlayedImageView.setFitWidth(19.0);
        xPlayedImageView.setId("xImageView");
        xPlayedImageView.setLayoutX(414.0);
        xPlayedImageView.setLayoutY(352.0);
        xPlayedImageView.setPickOnBounds(true);
        xPlayedImageView.setPreserveRatio(true);
        xPlayedImageView.setImage(new Image(getClass().getResource("/res/X.png").toExternalForm()));

        youPlayedText.setFill(javafx.scene.paint.Color.valueOf("#da1717"));
        youPlayedText.setId("youPlayedText");
        youPlayedText.setLayoutX(164.0);
        youPlayedText.setLayoutY(375.0);
        youPlayedText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        youPlayedText.setStrokeWidth(0.0);
        youPlayedText.setText("You played This game as ");
        youPlayedText.setWrappingWidth(253.0000001192093);
        youPlayedText.setFont(new Font("Impact", 24.0));
        
        button_1Image.setFitHeight(45.0);
        button_1Image.setFitWidth(40.0);
        button_1Image.setLayoutX(185.0);
        button_1Image.setLayoutY(153.0);
        button_1Image.setPickOnBounds(true);
        button_1Image.setCursor(Cursor.HAND);

        button_2Image.setFitHeight(45.0);
        button_2Image.setFitWidth(40.0);
        button_2Image.setLayoutX(279.0);
        button_2Image.setLayoutY(152.0);
        button_2Image.setPickOnBounds(true);
        button_2Image.setCursor(Cursor.HAND);

        button_3Image.setFitHeight(45.0);
        button_3Image.setFitWidth(40.0);
        button_3Image.setLayoutX(374.0);
        button_3Image.setLayoutY(152.0);
        button_3Image.setPickOnBounds(true);
        button_3Image.setCursor(Cursor.HAND);

        button_4Image.setFitHeight(45.0);
        button_4Image.setFitWidth(40.0);
        button_4Image.setLayoutX(185.0);
        button_4Image.setLayoutY(225.0);
        button_4Image.setPickOnBounds(true);
        button_4Image.setCursor(Cursor.HAND);

        button_5Image.setFitHeight(45.0);
        button_5Image.setFitWidth(40.0);
        button_5Image.setLayoutX(279.0);
        button_5Image.setLayoutY(227.0);
        button_5Image.setPickOnBounds(true);
        button_5Image.setCursor(Cursor.HAND);

        button_6Image.setFitHeight(45.0);
        button_6Image.setFitWidth(40.0);
        button_6Image.setLayoutX(373.0);
        button_6Image.setLayoutY(227.0);
        button_6Image.setPickOnBounds(true);
        button_6Image.setCursor(Cursor.HAND);

        button_7Image.setFitHeight(45.0);
        button_7Image.setFitWidth(40.0);
        button_7Image.setLayoutX(185.0);
        button_7Image.setLayoutY(301.0);
        button_7Image.setPickOnBounds(true);
        button_7Image.setCursor(Cursor.HAND);

        button_8Image.setFitHeight(45.0);
        button_8Image.setFitWidth(40.0);
        button_8Image.setLayoutX(280.0);
        button_8Image.setLayoutY(299.0);
        button_8Image.setPickOnBounds(true);
        button_8Image.setCursor(Cursor.HAND);

        button_9Image.setFitHeight(45.0);
        button_9Image.setFitWidth(40.0);
        button_9Image.setLayoutX(375.0);
        button_9Image.setLayoutY(299.0);
        button_9Image.setPickOnBounds(true);
        button_9Image.setCursor(Cursor.HAND);

        button_1.setLayoutX(170.0);
        button_1.setLayoutY(138.0);
        button_1.setMnemonicParsing(false);
        button_1.setOpacity(0.0);
        button_1.setPrefHeight(70.0);
        button_1.setPrefWidth(70.0);
        button_1.setCursor(Cursor.HAND);
        button_1.setId(0+"");
        
        
       
        button_2.setLayoutX(265.0);
        button_2.setLayoutY(138.0);
        button_2.setMnemonicParsing(false);
        button_2.setOpacity(0.0);
        button_2.setPrefHeight(70.0);
        button_2.setPrefWidth(70.0);
        button_2.setCursor(Cursor.HAND);
        button_2.setId(1+"");

        
        button_3.setLayoutX(359.0);
        button_3.setLayoutY(140.0);
        button_3.setMnemonicParsing(false);
        button_3.setOpacity(0.0);
        button_3.setPrefHeight(70.0);
        button_3.setPrefWidth(70.0);
        button_3.setCursor(Cursor.HAND);
        button_3.setId(2+"");

        button_4.setLayoutX(170.0);
        button_4.setLayoutY(212.0);
        button_4.setMnemonicParsing(false);
        button_4.setOpacity(0.0);
        button_4.setPrefHeight(70.0);
        button_4.setPrefWidth(70.0);
        button_4.setCursor(Cursor.HAND);
        button_4.setId(3+"");

       
        button_5.setLayoutX(264.0);
        button_5.setLayoutY(212.0);
        button_5.setMnemonicParsing(false);
        button_5.setOpacity(0.0);
        button_5.setPrefHeight(70.0);
        button_5.setPrefWidth(70.0);
        button_5.setCursor(Cursor.HAND);
        button_5.setId(4+"");

        button_6.setLayoutX(358.0);
        button_6.setLayoutY(212.0);
        button_6.setMnemonicParsing(false);
        button_6.setOpacity(0.0);
        button_6.setPrefHeight(70.0);
        button_6.setPrefWidth(70.0);
        button_6.setCursor(Cursor.HAND);
        button_6.setId(5+"");
        
        button_7.setLayoutX(170.0);
        button_7.setLayoutY(287.0);
        button_7.setMnemonicParsing(false);
        button_7.setOpacity(0.0);
        button_7.setPrefHeight(70.0);
        button_7.setPrefWidth(70.0);
        button_7.setCursor(Cursor.HAND);
        button_7.setId(6+"");

        
        button_8.setLayoutX(265.0);
        button_8.setLayoutY(284.0);
        button_8.setMnemonicParsing(false);
        button_8.setOpacity(0.0);
        button_8.setPrefHeight(70.0);
        button_8.setPrefWidth(70.0);
        button_8.setCursor(Cursor.HAND);
        button_8.setId(7+"");
 
        button_9.setLayoutX(359.0);
        button_9.setLayoutY(284.0);
        button_9.setMnemonicParsing(false);
        button_9.setOpacity(0.0);
        button_9.setPrefHeight(70.0);
        button_9.setPrefWidth(70.0);
        button_9.setCursor(Cursor.HAND);
        button_9.setId(8+"");
        
            
//        gridPane.setStyle("-fx-padding: 0;"
//                + "-fx-border-style: solid inside;"
//                + "-fx-border-width: 10;"
//                + "-fx-border-insets: 0;"
//                + "-fx-border-radius: 5;"
//                + "-fx-border-color: blue;");
//        gridPane.getStyleClass().add("mygridStyle");
//
//        Image image = new Image(getClass().getResourceAsStream("/res/X.png"), 35, 35, true, true);
//        ImageView imageView9 = new ImageView(image);
//        gridPane.add(imageView9, 0, 0, 1, 1);
//        GridPane.setHalignment(imageView9, HPos.CENTER);
        
        List<String> gameSteps=rec.readFile(path);
        System.out.println(gameSteps.size());
        for(int i=0;i<gameSteps.size()-1;i++){
            String[] arr=gameSteps.get(i).split(",");
            String src=null;
            if(arr[0].equals("X")){
                src="/res/X.png";
            }
            else if(arr[0].equals("O")){
                src="/res/O.png";
            }
            switch(arr[1]){
                case "1":
                button_1Image.setImage(new Image(getClass().getResource(src).toExternalForm()));
                    break;
                case "2":
                button_2Image.setImage(new Image(getClass().getResource(src).toExternalForm()));
                    break;
                case "3":
                button_3Image.setImage(new Image(getClass().getResource(src).toExternalForm()));
                    break;
                case "4":
                button_4Image.setImage(new Image(getClass().getResource(src).toExternalForm()));
                    break;
                case "5":
                button_5Image.setImage(new Image(getClass().getResource(src).toExternalForm()));
                    break;
                case "6":
                button_6Image.setImage(new Image(getClass().getResource(src).toExternalForm()));
                    break;
                case "7":
                button_7Image.setImage(new Image(getClass().getResource(src).toExternalForm()));
                    break;
                case "8":
                button_8Image.setImage(new Image(getClass().getResource(src).toExternalForm()));
                    break;
                case "9":
                button_9Image.setImage(new Image(getClass().getResource(src).toExternalForm()));
                    break;
                    
            }
        }

        
        //getChildren().add(gridPane);
        getChildren().add(backImageView);
        getChildren().add(logoImageView);
        getChildren().add(youPlayedButton);
        getChildren().add(xPlayedImageView);
        getChildren().add(youPlayedText);
        getChildren().add(button_1Image);
        getChildren().add(button_2Image);
        getChildren().add(button_3Image);
        getChildren().add(button_4Image);
        getChildren().add(button_5Image);
        getChildren().add(button_6Image);
        getChildren().add(button_7Image);
        getChildren().add(button_8Image);
        getChildren().add(button_9Image);
        getChildren().add(button_1);
        getChildren().add(button_2);
        getChildren().add(button_3);
        getChildren().add(button_4);
        getChildren().add(button_5);
        getChildren().add(button_6);
        getChildren().add(button_7);
        getChildren().add(button_8);
        getChildren().add(button_9);

    }
    
}

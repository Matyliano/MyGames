package ticTacToe;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;


public class TicTacToe2 extends Application implements EventHandler<ActionEvent> {

    private void addButtons(GridPane gridPane, int row){
        for(int i =1; i <=3; i++){
            javafx.scene.control.Button button = new javafx.scene.control.Button();
            button.setPrefSize( 300,300 );
            gridPane.add(button,i-1,row);
            button.setOnAction(this  );
        }
    }





    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        GridPane gridPane = new GridPane();

        addButtons( gridPane,0 );
        addButtons( gridPane,1 );
        addButtons( gridPane,2 );




        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(new Scene(gridPane, 900, 900));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }



    private int counter = 0;


    public void handle( ActionEvent event ) {
            javafx.scene.control.Button button = (Button) event.getSource();
            if(counter % 2 == 0){
                button.setText( "X" );
                System.out.println("X");
            } else {
                button.setText( "O" );
                System.out.println("O");
            }

            button.setDisable( true );  // nie można wybrac i kliknac drugi raz

            counter++;
        }


    public void handle( Event event ) {

    }
}


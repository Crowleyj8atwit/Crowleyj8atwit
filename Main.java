package application;
import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;


public class Main extends Application {
	@Override
	public void start(Stage mineBoard) {
		//determines name of stage
		try {
			mineBoard.setTitle("MineSweeper");
			final Pane plain = new Pane();
			
			
			
			mineBoard.setScene(new Scene(plain, 500, 500));
		//initiates game 
			// dimensions are established here, not upon creation
			mineBoard.show();
			//Go! it's showtime!
			int x = 0;
			int y = 0;
			int b = 10;
			int total = 100;
			Random bomberMan = new Random();
			int j;
	//		int[] squareList = new int[100];
			ArrayList<ButtonStats>SquareArray = new ArrayList<>();

			//loops for producing bombs
			//0-9,0-9
			for ( y = 0; y <= 9; y++) {
				for (x = 0; x<=9; x++) {
					//squareList[(y*10 + x)] = new ButtonStats.SingleStats(x,y,b);
					j = bomberMan.nextInt(10);
					if (j == 9 && b > 0) {
						b = b-1;
						SquareArray.add(new ButtonStats(x,y,1,SquareArray));
					}
				else if (b>=total) {
					b = b-1;
					SquareArray.add(new ButtonStats(x,y,1,SquareArray));
					}
				else {
					SquareArray.add(new ButtonStats(x,y,0,SquareArray));
				}
					total = total - 1;
			/**
			 * Old loop style, no longer needed as buttons are now produced in ButtonStats for oop benifits
					Button btn = new Button();
					 btn.setMinSize(50, 50);
					 btn.setMaxSize(50,50);
					 btn.setPrefSize(50,50);
					 btn.setLayoutX(x*50);
					 btn.setLayoutY(y*50);
					 **/
					 //trial
				//	 ButtonStats btn1 = new ButtonStats(1,1,1);
				
				//	ButtonStats.SingleStats(x,y,b);
				//	Button a = new Button();
				//	a.setLayoutX(x*10);
				//	a.setLayoutY(y*10);
					
				}
				
			}
			//plain.getChildren().add(btn); no longer used
			
			 for (int i = 0; i<100; i++) {
				 plain.getChildren().add(SquareArray.get(i).getButton());
				 }
			//For testing
	//		  SquareArray.get(20).getButton().setText("*b*");
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static void main(String[] args) {
		launch(args);
				
		
	//	final SingleStats p = new SingleStats();
		
		
	}
}

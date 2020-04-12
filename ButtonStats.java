package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ButtonStats {
	private int x;
	private int y;
	private int b;
	//private boolean isBomb
	private Button oopButton;
//used for buttons to check OTHER buttons
private ArrayList<ButtonStats>allButtons;

public ButtonStats(int x, int y, int bomb, ArrayList<ButtonStats>allButtons) {
		this.x = x;
		this.y = y;
		this.b= bomb;
		this.allButtons = allButtons;
		//standard array works as well
		
		/**
		 * btn = new Button();
		 * btn.setLayoutX();
		 * btn.setLayoutY();
		 * 
		 **/
	    oopButton = new Button();
					 oopButton.setMinSize(50, 50);
					 oopButton.setMaxSize(50,50);
					 oopButton.setPrefSize(50,50);
					 oopButton.setLayoutX(x*50);
					 oopButton.setLayoutY(y*50);
					// plain.getChildren().add(btn); Can't be used
					 
	//				 oopButton.setText(String.format("%d", x+y*10));
					 //shows location, not needed
					 oopButton.setOnAction(new EventHandler<ActionEvent>() {
//quick fix add in
						@Override
						public void handle(ActionEvent arg0) {
							// TODO Auto-generated method stub
						//	oopButton.setText("Clicked");
							
			//				allButtons.get(0).getButton().setText(String.format("%d", x+y*10));
							//sample of how to draw information from other areas
				/**			oopButton.setText(String.format("%d",));*/
							//to find other buttons
				//			boolean f;
							int f = 0;
						/**
							if (x < 5) {
								oopButton.setText("frog");
							}
							**/ //showcases button sample dividers
							
							if (b == 0) {
							
							if (x > 0) {
								if (allButtons.get((y*10+x)-1).getB() == 1){		
									f=f+1;
								}
							} //left center
							
							if (y>0) {
								if (allButtons.get((y*10+x)-10).getB() == 1){		
									f=f+1;
								}
							
							} //top center
							
							if (x<9) {
								if (allButtons.get((y*10+x)+1).getB() == 1){		
									f=f+1;
								}
							} //right center
							
							if (y<9) {
								if (allButtons.get((y*10+x)+10).getB() == 1){		
									f=f+1;
								}
							} //down center
							
							if (x>0 && y>0) {
								if (allButtons.get((y*10+x)-11).getB() == 1){		
									f=f+1;
								}
							} //top left
							if (x<9 && y>0) {
								if (allButtons.get((y*10+x)-9).getB() == 1){		
									f=f+1;
								}
							} //top right
							if (x>0 && y<9) {
								if (allButtons.get((y*10+x)+9).getB() == 1){		
									f=f+1;
								}
							} //bottom left
							if (x<9 && y<9) {
								if (allButtons.get((y*10+x)+11).getB() == 1){		
									f=f+1;
								}						
							} //bottom right
							
						
							
							
							oopButton.setText(String.format("%d",f));
						}//end bracket for not bomb tests
							if (b == 1) {
								oopButton.setText("*B*");
							}
						}});
						 
					 
					 //e is the event handler
	 /** @param x
	 * @param y
	 * @param bomb
	 */
		  
		 
	}
public Button getButton() {
	return oopButton;
	
}
	public double getX() {
		//Used to pull out X value of individual object
		return this.x; 
	}
	public double getY() {
		//Used to pull out X value of individual object
		return this.y; 
	}
	private double getB() {
		return this.b;
	}
	
}


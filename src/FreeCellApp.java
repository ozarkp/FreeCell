/**
 * A view for the game of FreeCell
 * @authors ozarkp17 and olsonm16
 */

import javax.swing.JFrame;
public class FreeCellApp {

	public static void main(String[] args){
		final JFrame view = new AppView();
		view.setTitle("The Game of Free Cell");
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setSize(800, 700);
		view.setVisible(true);	
	}
}

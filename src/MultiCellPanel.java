import javax.swing.*;

import java.awt.*;
/**
 * Represents the GUI component for painting an image of a playing card.
 * @authors lambertk, ozarkp17, and olsonm16
 */
public class MultiCellPanel extends AbstractCellPanel {
    /**
     * Constructor to display a given card's image.
     * @param cellInput the card to display.
     */
    public MultiCellPanel (TrueCell inputCell, ViewInformer inputviewInformer) {
		super(inputCell, inputviewInformer);
	}

	/**
     * Paints the card's face image if a card is present, otherwise, paints the back side image.
     */
    public void paintComponent(Graphics g){
    	super.paintComponent(g);
    	Icon image;
    	if (cell.size() == 0){
    		image = Card.getBack();
    		g.setColor(Color.yellow);
    		int x = (getWidth() - image.getIconWidth()) / 2;
    		int y = (getHeight() - image.getIconHeight()) / 2;
    		g.drawRect(x, y, image.getIconWidth(), image.getIconHeight());
    	}
    	else{
    		int increment = 0;
    		for (Card card : cell) {
    			image = card.getImage();
    			int x = (getWidth() - image.getIconWidth()) / 2;
    			int y = (getHeight() - image.getIconHeight()) / 2;
    			y += increment;
    			image.paintIcon(this, g, x, y);
    			increment += 25;
    		}
    	}
    }

}
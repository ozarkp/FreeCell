import javax.swing.*;

import java.awt.*;
/**
 * Represents the GUI component for painting an image of a playing card.
 * @authors lambertk, ozarkp17, and olsonm16
 */
public class SingleCellPanel extends AbstractCellPanel {
	
	public SingleCellPanel(TrueCell inputCell, ViewInformer inputviewInformer) {
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
    		image = cell.get(0).getImage();
    		int x = (getWidth() - image.getIconWidth()) / 2;
    		int y = (getHeight() - image.getIconHeight()) / 2;
    		image.paintIcon(this, g, x, y);
    	}
    }
}

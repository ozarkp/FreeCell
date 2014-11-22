import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.AbstractCollection;
/**
 * Represents the GUI component for an Abstract Panel of Cards
 * @author olsonm16
 */
public abstract class AbstractCellPanel extends JPanel implements TruePanel {
	
	public final static Color NICE_GREEN = new Color(12, 133, 40);
	protected TrueCell cell;
	protected ViewInformer viewInformer;
	protected PanelListener panelListener;
	
    /**
     * Constructor to display a given card's image.
     * @param inputCell the card to display.
     */
    public AbstractCellPanel(TrueCell inputCell, ViewInformer inputviewInformer){
    	setBackground(NICE_GREEN);
    	cell = inputCell;
        viewInformer = inputviewInformer;
        panelListener = new PanelListener();
    }
    
    /**
     * Resets the panel's cell and refreshes the panel.
     * @param c the cell to be displayed.
     */
    public void setCell(TrueCell c){
    	cell = c;
    	repaint();
    }
    
    public TrueCell getCell() {
    	return cell;
    }
    
    private class PanelListener extends MouseAdapter {
    	@Override
    	public void mouseClicked(MouseEvent event) {
    		System.out.println("MouseAdapter X");
    		Object source = event.getSource();
    		if (source instanceof AbstractCellPanel) {
    			AbstractCellPanel panelPressed = (AbstractCellPanel)source;
    			panelPressed.viewInformer.panelPressed(panelPressed);   		
    		}
    	}
    }
}
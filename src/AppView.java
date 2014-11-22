import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
/**
 * A main frame for the game of FreeCell
 * @authors ozarkp17 and olsonm16
 */
public class AppView extends JFrame{
	
	public final static Color NICE_GREEN = new Color(12, 133, 40);
	private FreeCellGame currentGame;
	private SingleCellPanel[] freePanels;
	private SingleCellPanel[] homePanels;
	private MultiCellPanel[] tableauPanels;
	private AbstractCellPanel fromPanel;
	private AppViewInformer appViewInformer;
	
	
	/**
	 * Constructor for the frame
	 */
	public AppView() {
		appViewInformer = new AppViewInformer();
		fromPanel = null; //None clicked
		currentGame = new FreeCellGame();
		freePanels = new SingleCellPanel[4];
		homePanels = new SingleCellPanel[4];
		tableauPanels = new MultiCellPanel[8];
		for (int i = 0; i < freePanels.length; i++) {
			freePanels[i] = new SingleCellPanel(currentGame.getFreeCell(i), appViewInformer);
		}
		for (int i = 0; i < homePanels.length; i++) {
			homePanels[i] = new SingleCellPanel(currentGame.getHomeCell(i), appViewInformer);
		}
		for (int i = 0; i < tableauPanels.length; i++) {
			tableauPanels[i] = new MultiCellPanel(currentGame.getTableauCell(i), appViewInformer);
		}
		
		Container container = getContentPane();
		
		container.add(labelPanelMaker(), BorderLayout.NORTH);	
		container.add(centerPanelMaker(), BorderLayout.CENTER);
		container.add(resetButtonMaker(), BorderLayout.SOUTH);
			
	}
	
	/**
	 * The reset button to create a new game of FreeCell
	 */
	private JButton resetButtonMaker() {
		JButton resetButton = new JButton("New Game");
		resetButton.setForeground(Color.black);
		resetButton.setBackground(Color.white); 
		resetButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){		

				currentGame.buildNewGame();
				repaint();
				
				
		}});		
		return resetButton;
	}
	
	/**
	 * Creates the labels of the frame
	 */
	private JPanel labelPanelMaker() {
		JPanel labelPanel = new JPanel();
		JLabel FreeCellLabel = new JLabel("FreeCells", JLabel.CENTER);
		JLabel HomeCellLabel = new JLabel("HomeCells", JLabel.CENTER);	
		labelPanel.setLayout(new GridLayout(1, 2));
		labelPanel.add(FreeCellLabel);
		labelPanel.add(HomeCellLabel);
		return labelPanel;
	}
	
	/**
	 * Creates the tableau cells for the frame
	 */
	private JPanel tableauCellMaker() {
		JPanel tableauPanel = new JPanel();
		tableauPanel.setLayout(new GridLayout(1, 8));
		tableauPanel.setBackground(NICE_GREEN);
		for (int i = 0; i < tableauPanels.length; i++) {
			tableauPanel.add(tableauPanels[i]);
		}
		return tableauPanel;
	}
	/**
	 * creates the HomeCell and FreeCell panels for the frame
	 * @return
	 */
	private JPanel upperPanelMaker() {
		JPanel upperPanels = new JPanel();
		upperPanels.setLayout(new GridLayout(1, 8));
		upperPanels.setBackground(NICE_GREEN);
		for (int i = 0; i < freePanels.length; i ++) {
			upperPanels.add(freePanels[i]);
		}
		for (int i = 0; i < homePanels.length; i ++) {
			upperPanels.add(homePanels[i]);
		}
		return upperPanels;
	}
	
	/**
	 * Lays out the panels in the frame
	 */
	private JPanel centerPanelMaker() {
		JPanel gridPanel = new JPanel();
		GridBagLayout gbl = new GridBagLayout();		
		gridPanel.setLayout(gbl);
		gridPanel.setBackground(NICE_GREEN);
		GridBagConstraints gbc = new GridBagConstraints();
		
		//Constraints for upper panel
		
		gbc.gridx = 0;
		gbc.gridy = 0;	
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 20, 0, 20);	
		gbc.ipady = 95;
		gbc.weightx = 1;
		gbc.weighty = 1;
		JPanel upperPanel = upperPanelMaker();
		gbl.setConstraints(upperPanel, gbc);
		gridPanel.add(upperPanel);	

		//Constraints for tableau panel
		
		gbc.gridx = 0;
		gbc.gridy = 1;	
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(-200, 20, 0, 20);
		gbc.ipadx = 400;
		gbc.ipady = 400;
		gbc.weightx = 1;
		gbc.weighty = 4;
		JPanel tableauPanel = tableauCellMaker();
		gbl.setConstraints(tableauPanel, gbc);
		gridPanel.add(tableauPanel);
		
		return gridPanel;
	}

	private class AppViewInformer implements ViewInformer {
		
		public void panelPressed(AbstractCellPanel panel) {
			
			System.out.println("watttt");
			
			if (panel == null) {
				fromPanel = panel;
			} 
			
			if (panel == fromPanel) {
				fromPanel = null;
			}
			
			if (panel != fromPanel) {
				if (panel.getCell().transferFrom(fromPanel.getCell())) {
					repaint();
				}
			}
			
		}
	}
		
}

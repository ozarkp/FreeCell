/**
 * A top-level model class FreeCellGame.
 * @authors ozarkp17 and olsonm16
 */


public class FreeCellGame {
	
	private TableauCell[] tableauCells;
	private HomeCell[] homeCells;
	private FreeCell[] freeCells;
	private Deck deck;
	
	/**
     * Constructor for a new FreeCell game. Creates/shuffles a new deck, then creates four Tableau cells with six cards
     * and four Tableau cells with seven cards. Also creates four HomeCells and four FreeCells. All cells are stored in
     * their proper Arrays.
     */
	public FreeCellGame() {
		tableauCells = new TableauCell[8];
		homeCells = new HomeCell[4];
		freeCells = new FreeCell[4];
		deck = new Deck();
		deck.shuffle();
		for (int i = 0; i < 4; i ++) {
			tableauCells[i] = createTableauWithSeven();
			HomeCell tempHome = new HomeCell();
			FreeCell tempFree = new FreeCell();
			homeCells[i] = tempHome;
			freeCells[i] = tempFree;
		}
		for (int i = 4; i < 8; i ++) {
			tableauCells[i] = createTableauWithSix();
		}
	}
	
	public void buildNewGame() {
		
		Deck deck = new Deck();
		deck.shuffle();
		for (AbstractCell c : tableauCells){
			c.clear();
		}
		for (AbstractCell c : homeCells){
			c.clear();
		}
		for (AbstractCell c : freeCells){
			c.clear();
		}
		
		for (int i = 0; i < 4; i ++) {
			for (int j = 0; j < 7; j++){
				tableauCells[i].add(deck.deal());
			}

		}
		for (int k = 4; k < 8; k++) {
			for (int m = 0; m < 6; m++){
				tableauCells[k].add(deck.deal());
			}
		}
	}

	
	/**
	 * Helper method for creating a Tableau cell with Six cards
	 * @return TableauCell with six cards added to it from currentDeck
	 */
	private TableauCell createTableauWithSeven() {
		TableauCell temp = new TableauCell();
		for (int i = 0; i < 7; i++) {
			temp.add(deck.deal());
		}
		return temp;
	}
	
	/**
	 * Helper method for creating a Tableau cell with Seven cards
	 * @return TableauCell with six cards added to it from currentDeck
	 */
	private TableauCell createTableauWithSix() {
		TableauCell temp = new TableauCell();
		for (int i = 0; i < 6; i++) {
			temp.add(deck.deal());
		}
		return temp;
	}
	/**
	 * Typical toString for all cells in game
	 * @return a string representation of cells
	 */
	public String toString() {
		String temp = "";
		for (TableauCell T: tableauCells) {
			temp += T.toString() + "\n";
		}
		return temp;
	}
	
	/**
	 * Getter method for TableauCells in their Array
	 * @param i index of Tableau cell
	 * @return TableauCell at index i
	 */
	public TableauCell getTableauCell(int i) {
		return tableauCells[i];
	}
	
	/**
	 * Getter method for HomeCells in their Array
	 * @param i index of HomeCell
	 * @return HomeCell at index i
	 */
	public HomeCell getHomeCell(int i) {
		return homeCells[i];
	}
	
	/**
	 * Getter method for FreeCells in their Array
	 * @param i index of FreeCell
	 * @return FreeCell at index i
	 */
	public FreeCell getFreeCell(int i) {
		return freeCells[i];
	}
	
	
	
	
}
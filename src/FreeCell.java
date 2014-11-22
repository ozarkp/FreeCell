/**
 * A FreeCell class for the game of FreeCell
 */
public class FreeCell extends AbstractCell {

	/**
	 * Contructor for the FreeCell class
	 */	
	public FreeCell() {
		
	}

	/**
	 * Performs a transfer of a card from a cell of type AbstractCell to the FreeCell
	 * @param cell a cell of type AbstractCell
	 * @return boolean true if transfer is successful and false otherwise
	 */
	public boolean transferFrom(AbstractCell cell) {
		if ( this.isEmpty() ) {
			this.add(cell.cards.get(cell.size() - 1));
			cell.cards.remove(cell.size() - 1);
			return true;
		}
		return false;
	}
	
	
	
	
}






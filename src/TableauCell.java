import java.util.*;
/**
 * A TableuCell class for the game of FreeCell
 * @authors ozarkp17 and olsonm16
 */
public class TableauCell extends AbstractCell {

	/**
	 * An instance variable for holding a list of indices of in order cards
	 */	
	public List<Integer> sortedArray;

	/**
	 * Constructor creating he ArrayList for the cell
	 */
	public TableauCell() {
		sortedArray = new ArrayList<Integer>();
	}
	
	/**
	 * Takes an object, and checks which cell type it is, home or tableau.
	 * If it's a tableau cell, checks if the last cards in each cell are a match
	 * If no match, checks the fromCell for the desired match to the last card in toCell
	 * If there is a match somewhere, checks index of that match with sortedArray
	 * @param cell an AbstractCell object
	 * @return boolean true if successful transfer occurs and false otherwise
	 */
	public boolean transferFrom(AbstractCell cell) {
		if ( (cell instanceof TableauCell) ) {
			TableauCell fromCell = (TableauCell)cell;
			Card lastToCell = this.cards.get(this.cards.size() - 1);
			Card lastFromCell = fromCell.cards.get(fromCell.cards.size() - 1);
			if (checkCardPair(lastToCell, lastFromCell)) {
				this.add(lastFromCell);
				fromCell.cards.remove(fromCell.cards.size() - 1);
				return true;
			} else {
				return multipleTransfer(fromCell, lastToCell); 
			}
		} else if ( (cell instanceof FreeCell) ) {
			FreeCell fromCell = (FreeCell)cell;
			Card lastToCell = this.cards.get(this.cards.size() - 1);
			Card lastFromCell = fromCell.cards.get(fromCell.cards.size() - 1);
			if (checkCardPair(lastToCell, lastFromCell)) {
				this.add(lastFromCell);
				fromCell.cards.remove(fromCell.cards.size() - 1);
				return true; 
		} else {
			return false;
		}
		}
		return false;
	}

	/**
	 * Responsible for transferring a group of cards from fromCell to another cell
	 * @param fromCell a cell from the TableauCell class
	 * @param lastToCell a card object that is in the last position of the cell receiving the transferred cards (this)
	 * @return boolean true if multiple cards were transferred to another cell and false otherwise
	 */
	public boolean multipleTransfer(TableauCell fromCell, Card lastToCell) {
		for (int i = fromCell.cards.size() - 2; i >=0; i--) {
			Card currentFromCell = fromCell.cards.get(i);
			if (checkCardPair(lastToCell, currentFromCell) ) {
				if (!sortedArray.isEmpty()) {
					if (i == fromCell.sortedArray.get(0)) {
						for (int j : fromCell.sortedArray) {
							this.add(fromCell.cards.get(j));
						}
						for (int k = fromCell.sortedArray.size() - 1; k >=0; k--) {
							fromCell.remove(fromCell.sortedArray.get(k)); 
						}
						return true;	
					} 
				}
			}
		}
		return false;
	}

	/**
	 * Creates an ArrayList of the indicies in the TableauCell at which cards can be transferred as a group to another TableauCell
	 * For the ArrayList to contain the indicies of the cards the index of the last card in the cell must be included
	 * If it is not then sortedArray is empty
	 */
	public void sortedCardsArrayGenerator() {
		List<Integer> tempArray = new ArrayList<Integer>();
		for (int i = 0; i < this.size() - 1; i ++) {
			Card tempFirst = this.cards.get(i);
			Card tempSecond = this.cards.get(i+1);
			if (checkCardPair(tempFirst, tempSecond)) {
				if (!tempArray.contains(i)) {
					tempArray.add(i);
				}
				if (!tempArray.contains(i+1)) {
					tempArray.add(i+1);
				}
			} else {
				tempArray.clear();
			}
		}
		sortedArray = tempArray;
	}

		
}

/**
 * A HomeCell class for the game of FreeCell
 * @authors ozarkp17 and olsonm16
 */
public class HomeCell extends AbstractCell {

	/**
	 * Constructor for HomeCell
	 */	
	public HomeCell() {
		
	}

	/**
	 * Checks to see if the last card from a FreeCell or TableauCell can be transferred to the HomeCell
	 * If the HomeCell is empty the card transferred must be an ace
	 * If the HomeCell is not empty the card transferred must be of the same suit and the rank of the last card in the HomeCell + 1
	 * @param cell an AbstractCell from which the card will be transferred to the HomeCell
	 * @return boolean true if the transfer is possible and false otherwise
	 */
	public boolean transferFrom(AbstractCell cell) {
		Card lastFromCell = cell.cards.get(cell.size() - 1);
		if (this.isEmpty()) {
			if (lastFromCell.getRank() == 1) {
				this.add(lastFromCell);
				cell.cards.remove(cell.size() - 1);
				return true;
			} else {
				return false;
			}
		} else {
			Card lastToCell = this.cards.get(this.size() - 1);
			if (homeCellCardsMatch(lastToCell, lastFromCell)) {
				this.add(lastFromCell);
				cell.cards.remove(cell.size() - 1);
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks to see if the rank of one card is that of the other card - 1 and if the suits are the same
	 * @param first Card that will have its rank and suit compared to another card
	 * @param second Card that will have its rank and suit compared to another card
	 * @return boolean true if conditions are met and false otherwise
	 */
	public boolean homeCellCardsMatch(Card first, Card second) {
		return (first.getRank() == second.getRank() - 1) && ( first.getSuit().compareTo(second.getSuit()) == 0 );
	}
		
}

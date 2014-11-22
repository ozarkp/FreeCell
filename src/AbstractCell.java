import java.util.*;
/**
 * Represents an Abstract Cell in the game of FreeCell
 *@authors ozarkp17 and olsonm16
 */


public abstract class AbstractCell extends AbstractCollection<Card> implements TrueCell {

	protected List<Card> cards;

	/**
	 * Constructor for AbstractCell
	 * Every  cell extending this class will have an ArrayList with 
	 * card objects and the specified behavior in the class
	 */
	public AbstractCell() {
		cards = new ArrayList<Card>();
	}

	/**
	 * Adds a card to the cell
	 * @param c a Card object
	 * @return true if add is successful and false otherwise
	 */
	public boolean add(Card c) {
		return cards.add(c);
	}
	
	/**
	 * @param i index of card to return
	 * @return Card object at index i
	 */
	public Card get(int i) {
		return cards.get(i);
	}

	/**
	 * Removes a card from the cell
	 * @param i index of the card in the cell
	 */
	public void remove(int i) {
		cards.remove(i);
	}

	/**
	 * Checks to see if the cell is empty
	 * @return boolean true if the cell is empty and false otherwise
	 */
	public boolean isEmpty() {
		return cards.isEmpty();
	}

	/**
	 * Returns size of the cell
	 * @return size of the cell
	 */
	public int size() {
		return cards.size();
	}

	/**
	 * Returns a string representation of the cell
	 * @return a string representation of the cell
	 */
	public String toString() {
		return cards.toString();
	}
	
	/**
	 * Returns true if second's rank is one less than first, and suits match.
	 * @param first a card object
	 * @param second a card object
	 * @return true if conditions are met and false otherwise
	 */
	public boolean checkCardPair(Card first, Card second) {
		return (first.getRank() == second.getRank() + 1) && ( checkSuit(first.getSuit(), second.getSuit()) );
	}
	
	/**
	 * Returns true for compatible suits, e.g. red then black or black then red
	 * @param firstSuit a suit
	 * @param secondSuit a suit
	 * @return true if the suits are compatible and false otherwise
	 */
	public boolean checkSuit(Suit firstSuit, Suit secondSuit) {
		String first = firstSuit.toString();
		String second = secondSuit.toString();	
		if (   (first.equals("hearts") && second.equals("diamonds")) 
			|| (first.equals("diamonds") && second.equals("hearts")) 
			|| (first.equals("spades") && second.equals("clubs"))
			|| (first.equals("clubs") && second.equals("spades"))
			|| (first.equals(second))) {
					return false;
				}
		return true;
		}
	
	/**
	 * A custom iterator class for Cells that returns a new Cell Iterator based on the cards list
	 * @return a new Cell Iterator
	 */	
	public Iterator<Card> iterator(){
        return new CellIterator<Card>(cards.iterator());
    }
    
    /**
	 * The class definition for a new CellIterator, includes constructor, bools, next/remove methods
	 */
	private class CellIterator<Card> implements Iterator<Card>{
	    
    	private Iterator<Card> iter;
    	
    	private CellIterator(Iterator<Card> iter){
    		this.iter = iter;
    	}
    	
    	public boolean hasNext(){
    		return iter.hasNext();
    	}
    	
    	public Card next(){
    		return iter.next();
    	}
    	
    	public void remove(){
    		iter.remove();
    	}
    	
    }
	
	public boolean transferFrom(TrueCell cell) {
		if ( (cell instanceof TableauCell) ) {
			TableauCell fromCell = (TableauCell)cell;
			return fromCell.transferFrom(this);
		} else {
			return false;
		}
			
	}
	
	
	
	
}

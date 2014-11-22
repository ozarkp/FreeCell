import java.util.*;

/**
 ** Represents an instance of a deck of cards with suits and ranks.
 ** @author olsonm16
 */
public class Deck {

	private List<Card> deck;

	
	public Deck() {
		deck = new ArrayList<Card>();
		initSuit(Suit.club);
		initSuit(Suit.diamond);
		initSuit(Suit.heart);
		initSuit(Suit.spade);
	}
	
	/**
	 * Adds all ranks of a given suit to the deck
	 * @param suit a Card suit type
	 */
	private void initSuit(Suit suit) {
		for (int rank = 1; rank <= 13; rank++) {
			Card currentCard = new Card(suit, rank);
			deck.add(currentCard);
		}
	}
	
	/**
	 * Shuffles the deck
	 */
	public void shuffle() {
		Collections.shuffle(deck);
	}	
	
	/**
	 * Returns a card from the end of the deck
	 * @return the last Card in the deck
	 */
	public Card deal() {
		if (deck.isEmpty())
			throw new IllegalStateException("Out of cards");
		return deck.remove(deck.size() - 1);
	}
	
	/**
	 * Returns a bool telling if the deck is empty
	 * @return true if the deck is empty, false otherwise
	 */
	public boolean isEmpty() {
		return (deck.size() == 0);
	}

	/**
	 * Returns a string representation of the cards in the dock
	 * @return a string
	 */
	public String toString() {
		String deckString = ""; 
		for (Card card: deck)
			deckString += card.toString() + "\n";
		return deckString;	
	}
}

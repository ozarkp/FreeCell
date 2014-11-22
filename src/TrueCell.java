import java.util.*;
/**
 * An interface for a cell in the game FreeCell
 * @authors ozarkp17 and olsonm16
 */

public interface TrueCell extends Collection<Card>{

	public boolean add(Card c);

	public void remove(int i);
	
	public Card get(int i);
	
	public int size();

	public boolean isEmpty();

	public String toString();

	public boolean checkCardPair(Card first, Card second);

	public boolean checkSuit(Suit firstSuit, Suit secondSuit);
	
	public Iterator<Card> iterator();
	
	public boolean transferFrom(TrueCell cell);
}

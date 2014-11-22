/**
 * A tester class for the cells in the game of FreeCell
 * @authors ozarkp17 and olsonm16
 */

public class CellTester {

	public static void main(String[] args) {
		TableauCell toCell;
		TableauCell fromCell;		
		FreeCell fromCellFree;
		FreeCell toCellFree;
		HomeCell toHomeCell;	
		Deck testDeck;
		
		//TableauCell / TableauCell interaction
		toCell = new TableauCell();
		fromCell = new TableauCell();

		Card first = new Card(Suit.heart, 13);
		Card second = new Card(Suit.spade, 12);
		Card third = new Card(Suit.heart, 11);
		Card fourth = new Card(Suit.spade, 10);
		toCell.add(first);
		toCell.add(second);
		toCell.add(third);
		toCell.add(fourth);
		
		Card a = new Card(Suit.diamond, 1);
		Card b = new Card(Suit.diamond, 2);
		Card c = new Card(Suit.club, 6);
		Card d = new Card(Suit.heart, 9);
		Card e = new Card(Suit.club, 8);
		Card f = new Card(Suit.heart, 7);		
		fromCell.add(a);
		fromCell.add(b);
		fromCell.add(c);	
		fromCell.add(d);
		fromCell.add(e);
		fromCell.add(f);
			
		System.out.println("\nTABLEAUCELL / TABLEAUCELL INTERACTION\n");
		
		toCell.sortedCardsArrayGenerator();
		fromCell.sortedCardsArrayGenerator();

		System.out.println("fromTableauCell before multiple transfer: " + fromCell.toString() + "\n\n" + 
		"toTableauCell before mutiple transfer: " + toCell.toString() + "\n\n");

		toCell.transferFrom(fromCell);

		System.out.println("fromTableauCell after multiple transfer: " + fromCell.toString() + "\n\n" + 
		"toTableauCell after mutiple transfer: " + toCell.toString() + "\n\n\n\n");

		fromCell.add(e);

		System.out.println("fromCell before failed transfer: " + fromCell.toString() + "\n\n" + 
		"toCell before failed transfer: " + toCell.toString() + "\n\n");

		toCell.transferFrom(fromCell);
		
		System.out.println("fromCell after failed transfer: " + fromCell.toString() + "\n\n" + 
		"toCell after failed transfer: " + toCell.toString() + "\n\n\n\n");

		// FreeCell / FreeCell interaction
		System.out.println("FREECELL / FREECELL INTERACTION\n");
		
		fromCellFree = new FreeCell();
		toCellFree = new FreeCell();

		fromCellFree.add(a);
		System.out.println("fromCellFree before transfer: " + fromCellFree.toString() + "\n\n" + 
		"toCellFree before transfer: " + toCellFree.toString() + "\n\n");
		
		toCellFree.transferFrom(fromCellFree);

		System.out.println("fromCellFree after transfer: " + fromCellFree.toString() + "\n\n" + 
		"toCellFree after transfer: " + toCellFree.toString() + "\n\n\n\n");

		fromCellFree.add(c);

		System.out.println("fromCellFree before failed transfer: " + fromCellFree.toString() + "\n\n" + 
		"toCellFree before failed transfer: " + toCellFree.toString() + "\n\n");
		
		toCellFree.transferFrom(fromCellFree);

		System.out.println("fromCellFree after failed transfer: " + fromCellFree.toString() + "\n\n" + 
		"toCellFree after failed transfer: " + toCellFree.toString() + "\n\n\n\n");

		// TableauCell / FreeCell interaction
		
		System.out.println("TABLEAUCELL / FREECELL INTERACTION\n");
		
		toCell = new TableauCell();
		fromCellFree = new FreeCell();
		
		toCell.add(first);
		toCell.add(second);
		toCell.add(third);
		toCell.add(fourth);

		fromCellFree.add(d);

		System.out.println("fromCellFree before transfer: " + fromCellFree.toString() + "\n\n" + 
		"toCell before transfer: " + toCell.toString() + "\n\n");

		toCell.transferFrom(fromCellFree);
		
		System.out.println("fromCellFree after transfer: " + fromCellFree.toString() + "\n\n" + 
		"toCell after transfer: " + toCell.toString() + "\n\n\n\n");

		fromCellFree.add(b);

		System.out.println("fromCellFree before failed transfer: " + fromCellFree.toString() + "\n\n" + 
		"toCell before failed transfer: " + toCell.toString() + "\n\n");

		toCell.transferFrom(fromCellFree);

		System.out.println("fromCellFree after failed transfer: " + fromCellFree.toString() + "\n\n" + 
		"toCell after failed transfer: " + toCell.toString() + "\n\n\n\n");

		//Tableau Cell / HomeCell interaction
		
		System.out.println("TABLEAUCELL / HOMECELL INTERACTION\n");

		fromCell = new TableauCell();
		toHomeCell = new HomeCell();

		fromCell.add(c);
		fromCell.add(b);
		fromCell.add(a);

		System.out.println("fromCell before transfer: " + fromCell.toString() + "\n\n" + 
		"toHomeCell before transfer: " + toHomeCell.toString() + "\n\n");	

		toHomeCell.transferFrom(fromCell);
		
		System.out.println("fromCell after transfer: " + fromCell.toString() + "\n\n" + 
		"toHomeCell after transfer: " + toHomeCell.toString() + "\n\n\n\n");	

		fromCell = new TableauCell();
		fromCell.add(b);

		System.out.println("fromCell before transfer: " + fromCell.toString() + "\n\n" + 
		"toHomeCell before transfer: " + toHomeCell.toString() + "\n\n");	

		toHomeCell.transferFrom(fromCell);

		System.out.println("fromCell after transfer: " + fromCell.toString() + "\n\n" + 
		"toHomeCell after transfer: " + toHomeCell.toString() + "\n\n\n\n");

		fromCell.add(b);

		System.out.println("fromCell before failed transfer: " + fromCell.toString() + "\n\n" + 
		"toHomeCell before failed transfer: " + toHomeCell.toString() + "\n\n");	

		toHomeCell.transferFrom(fromCell);

		System.out.println("fromCell after failed transfer: " + fromCell.toString() + "\n\n" + 
		"toHomeCell after failed transfer: " + toHomeCell.toString() + "\n\n\n\n");	

		// FreeCell / HomeCell interaction
		
		System.out.println("FREECELL / HOMECELL INTERACTION\n");
		fromCellFree = new FreeCell();
		toHomeCell = new HomeCell();

		fromCellFree.add(a);

		System.out.println("fromFreeCell before transfer: " + fromCellFree.toString() + "\n\n" + 
		"toHomeCell before transfer: " + toHomeCell.toString() + "\n\n");

		toHomeCell.transferFrom(fromCellFree);

		System.out.println("fromFreeCell after transfer: " + fromCellFree.toString() + "\n\n" + 
		"toHomeCell after transfer: " + toHomeCell.toString() + "\n\n\n\n");
		
		fromCellFree.add(d);
		toHomeCell = new HomeCell();
		
		System.out.println("fromFreeCell before failed transfer: " + fromCellFree.toString() + "\n\n" + 
		"toHomeCell before failed transfer: " + toHomeCell.toString() + "\n\n");

		toHomeCell.transferFrom(fromCellFree);

		System.out.println("fromFreeCell after failed transfer: " + fromCellFree.toString() + "\n\n" + 
		"toHomeCell after failed  transfer: " + toHomeCell.toString() + "\n\n\n\n");

		System.out.println("toFreeCell before failed transfer: " + fromCellFree.toString() + "\n\n" + 
		"fromHomeCell before failed transfer: " + toHomeCell.toString() + "\n\n");
		
		fromCellFree.transferFrom(toHomeCell);

		System.out.println("toFreeCell after failed transfer: " + fromCellFree.toString() + "\n\n" + 
		"fromHomeCell after failed transfer: " + toHomeCell.toString() + "\n\n\n\n");
		

	}


}

package Q10;

import java.util.Arrays;

public class Card {
	String[] cards;

	public Card() {
		this.cards = new String[5];
	}
	
	public int getValue(int index) {
		String numbers = "23456789TJQKA";
		return numbers.indexOf(this.cards[index].charAt(0));
	}
	
	public char getMark(int index) {
		return cards[index].charAt(1);
	}
	
	public void sortCards() {
		Arrays.sort(this.cards, new MyComparator());
	}
	
}

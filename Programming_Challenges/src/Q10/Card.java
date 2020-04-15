package Q10;

import java.util.Arrays;
import java.util.Comparator;

public class Card {
	String[] cards;

	public Card() {
		this.cards = new String[5];
	}
	
	public int getValue(int index) {
		String numbers = "23456789TJQKA";
		return numbers.indexOf(this.cards[index].charAt(0));
	}
	
	public void sortCards() {
		Arrays.sort(this.cards, new MyComparator());
	}
	
}

class MyComparator implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		// TODO Auto-generated method stub
		String numbers = "23456789TJQKA";
		int o1Value = numbers.indexOf(s1.charAt(0));
		int o2Value = numbers.indexOf(s2.charAt(0));
		
		return o2Value - o1Value;
	}
	
}

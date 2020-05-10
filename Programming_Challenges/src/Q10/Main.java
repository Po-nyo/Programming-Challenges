package Q10;

import java.util.Scanner;

/**
 * 
 * @author Ponyo
 * Programming Challenges Q10. Poker Hands (포커 패)
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextLine()) {
			Card bCard = new Card();
			Card wCard = new Card();
			
			for(int i=0; i<bCard.cards.length; i++)
				bCard.cards[i] = sc.next();
			for(int i=0; i<wCard.cards.length; i++)
				wCard.cards[i] = sc.next();
			
			Player b = new Player("Black", bCard);
			Player w = new Player("White", wCard);
			
			PokerGame poker = new PokerGame(b, w);
			poker.call();	
		}

		sc.close();
	}

}

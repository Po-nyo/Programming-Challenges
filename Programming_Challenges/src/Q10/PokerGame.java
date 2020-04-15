package Q10;

public class PokerGame {
	Player p1;
	Player p2;
	
	public PokerGame(Player p1, Player p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public void run() {
		p1.card.sortCards();
		p2.card.sortCards();
		
		rank(p1);
		rank(p2);
		
		winner(p1, p2);
		System.out.println();
	}
	
	public boolean isStraight(Player p) {
		int maxValue = p.card.getValue(0);
			
		for(int i=1; i<p.card.cards.length; i++) {
			int value = p.card.getValue(i);
			if(value != maxValue-i && value != maxValue-8-i)
				return false;
		}	
		return true;
	}
	
	public boolean isAllSameMark(Player p) {
		char mark = p.card.cards[0].charAt(1);
		
		for(int i=0; i<p.card.cards.length; i++) {
			if(mark != p.card.cards[i].charAt(1))
				return false;
		}
		
		return true;
	}
	
	public void rank(Player p) {
		
		/* Straight Flush */
		if(isAllSameMark(p) && isStraight(p)) {
			p.rank = 8;
		}
		/* Four of a kind */
		else if(p.card.getValue(0) == p.card.getValue(3) ||
				p.card.getValue(1) == p.card.getValue(4)) {
			p.rank = 7;
			p.maxValueIndex = 2;
		}
		/* Full House */
		else if((p.card.getValue(0) == p.card.getValue(2) &&
				p.card.getValue(3) == p.card.getValue(4)) ||
				(p.card.getValue(2) == p.card.getValue(4) &&
				p.card.getValue(0) == p.card.getValue(1))) {
			p.rank = 6;
			p.maxValueIndex = 2;
		}
		/* Flush */
		else if(isAllSameMark(p)) {
			p.rank = 5;
		}
		/* Straight */
		else if(isStraight(p)) {
			p.rank = 4;
		}
		/* Three of a kind */
		else if(p.card.getValue(0) == p.card.getValue(2) ||
				p.card.getValue(1) == p.card.getValue(3) ||
				p.card.getValue(2) == p.card.getValue(4)) {
			p.rank = 3;
			p.maxValueIndex = 2;
		}
		/* Two Pairs */
		else if((p.card.getValue(0) == p.card.getValue(1)) &&
			(p.card.getValue(2) == p.card.getValue(3))) {
			p.rank = 2;
			p.maxValueIndex = 1;
			p.temp = 4;
		}
		else if((p.card.getValue(0) == p.card.getValue(1)) &&
			(p.card.getValue(3) == p.card.getValue(4))) {
			p.rank = 2;
			p.maxValueIndex = 1;
			p.temp = 2;
		}
		else if((p.card.getValue(1) == p.card.getValue(2)) &&
				(p.card.getValue(3) == p.card.getValue(4))) {
			p.rank = 2;
			p.maxValueIndex = 1;
			p.temp = 0;
		}
		/* One Pair */
		else if(p.card.getValue(0) == p.card.getValue(1))
			p.rank = 1;
		else if(p.card.getValue(1) == p.card.getValue(2)) {
			p.rank = 1;
			p.maxValueIndex = 1;
		}
		else if(p.card.getValue(2) == p.card.getValue(3)) {
			p.rank = 1;
			p.maxValueIndex = 2;
		}
		else if(p.card.getValue(3) == p.card.getValue(4)) {
			p.rank = 1;
			p.maxValueIndex = 3;
		}
		/* High Card */	
	}
	
	public void winner(Player p1, Player p2) {
		if(p1.rank != p2.rank)
			printWinner(p1, p2);
		else {
			if(p1.rank == 2) {
				if(p1.card.getValue(p1.maxValueIndex) != p2.card.getValue(p2.maxValueIndex))
					printWinner(p1, p2);
				else if(p1.card.getValue(3) != p2.card.getValue(3))
					printWinner(p1, p2);
				else if(p1.card.getValue(p1.temp) != p2.card.getValue(p2.temp))
					printWinner(p1, p2);
				else
					System.out.println("Tie.");
			}
			else if(p1.rank == 5 || p1.rank == 1 || p1.rank == 0) {
				if(p1.card.getValue(p1.maxValueIndex) != p2.card.getValue(p2.maxValueIndex))
					printWinner(p1, p2);
				else if(p1.card.getValue(p1.temp) != p2.card.getValue(p2.temp))
					printWinner(p1, p2);
				else {
					int maxLen = p1.card.cards.length-1;
					p1.maxValueIndex = p2.maxValueIndex = 0;
					while(p1.maxValueIndex < maxLen || p2.maxValueIndex < maxLen) {
						int p1Current = p1.maxValueIndex;
						int p2Current = p2.maxValueIndex;
						while(p1.card.getValue(p1Current) == p1.card.getValue(p1.maxValueIndex)) {
							p1.maxValueIndex++;
							if(p1.maxValueIndex > maxLen)
								p1.maxValueIndex = maxLen;
						}
						while(p2.card.getValue(p2Current) == p2.card.getValue(p2.maxValueIndex)) {
							p2.maxValueIndex++;
							if(p2.maxValueIndex > maxLen)
								p2.maxValueIndex = maxLen;
						}
						if(p1.card.getValue(p1.maxValueIndex) != p2.card.getValue(p2.maxValueIndex)) {
							printWinner(p1, p2);
							return;
						}
					}
					System.out.println("Tie.");
				}
			}
			else {
				printWinner(p1, p2);
			}
		}
	}
	
	public void printWinner(Player p1, Player p2) {
		if(p1.rank > p2.rank)
			System.out.println(p1.name + " wins.");
		else if(p1.rank < p2.rank)
			System.out.println(p2.name + " wins.");
		else {
			if(p1.card.getValue(p1.maxValueIndex) > p2.card.getValue(p2.maxValueIndex))
				System.out.println(p1.name + " wins.");
			else if(p1.card.getValue(p1.maxValueIndex) < p2.card.getValue(p2.maxValueIndex))
				System.out.println(p2.name + " wins.");
			else
				System.out.println("Tie.");
		}
	}



}

package Q13;

public class Card {
	String[] cards;	// 카드
	int[] order;	// 순서 번호
	
	public Card() {
		cards = new String[52];
		order = new int[52];
		
		inIt();
	}
	
	public void inIt() {
		cardInit();
		orderInit();
	}
	
	private void cardInit() {
		
		String[] nums = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
		String[] marks = {"Clubs", "Diamonds", "Hearts", "Spades"};
		int i=0;
		int index = 0;
		
		for(;i<13;i++)
			this.cards[i] = nums[index++] + " of "+marks[0];
		
		index = 0;
		for(;i<26;i++)
			this.cards[i] = nums[index++] + " of "+marks[1];
		
		index = 0;
		for(;i<39;i++)
			this.cards[i] = nums[index++] + " of "+marks[2];

		index = 0;
		for(;i<52;i++)
			this.cards[i] = nums[index++] + " of "+marks[3];
	}
	
	private void orderInit() {
		for(int i=0; i<52; i++) {
			this.order[i] = i;
		}
	}
	
	public void mixCards(int[] pattern) {
		// 주어진 패턴대로 순서번호를 섞음
		int[] newOrder = new int[52];
		
		for(int i=0; i<pattern.length; i++)
			newOrder[i] = this.order[pattern[i]];
		
		this.order = newOrder;
	}

	public void printCards() {
		for(int i=0; i<this.order.length; i++)
			System.out.println(this.cards[this.order[i]]);
		
		System.out.println();
	}
}

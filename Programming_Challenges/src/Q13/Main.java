package Q13;

import java.util.Scanner;

/**
 * 
 * @author Ponyo
 * Programming Challenges Q13. Stack'em Up (쌓아 올리기)
 *
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Card card = new Card();
		int testCaseNum = sc.nextInt();	// test case 개수
		
		sc.nextLine();
		sc.nextLine();
		for(int i=0; i<testCaseNum; i++) {
			int n = sc.nextInt();	// 카드 섞기 패턴 개수
			int[][] patterns = new int[n][52];
			
			for(int j=0; j<n; j++) {
				for(int k=0; k<52; k++)
					patterns[j][k] = sc.nextInt()-1;
			}
			sc.nextLine();
			
			while(true) {
				String line = sc.nextLine();
				
				if(line.equals("")) {
					card.printCards();
					break;
				}
				else {
					int patternNum = Integer.parseInt(line)-1;
					card.mixCards(patterns[patternNum]);
					if(!sc.hasNextLine()) {
						card.printCards();
						break;
					}
				}
			}
			
			card.inIt();
		}

		sc.close();
	}

}

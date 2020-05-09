package Q9;

import java.util.Scanner;

/**
 * 
 * @author Ponyo
 * Programming Challenges Q9. 유쾌한 점퍼(Jolly Jumpers)
 *
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		Solution solution = new Solution();
		
		while(sc.hasNextLine()) {
			int n = sc.nextInt();
			int[] inputSequence = new int[n];
			
			for(int i=0; i<n; i++) 
				inputSequence[i] = sc.nextInt();
			
			solution.call(inputSequence);
		}
		
		sc.close();

	}

}

package Q66;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * @author wkj11
 * Programming Challenges Q66. Playing with Wheels (원판 돌리기)
 *
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		sc.nextLine();
		
		for(int i=0; i<testCase; i++) {
			sc.nextLine();
			int[] initial_state = new int[4];
			int[] final_state = new int[4];
			
			for(int j=0; j<initial_state.length; j++)
				initial_state[j] = sc.nextInt();
			
			for(int j=0; j<initial_state.length; j++)
				final_state[j] = sc.nextInt();
			
			int numOfBan = sc.nextInt();
			int[] ban = new int[4];
			Set<String> banList = new HashSet<>();
			
			for(int j=0; j<numOfBan; j++) {
				for(int k=0; k<ban.length; k++)
					ban[k] = sc.nextInt();
				banList.add(Arrays.toString(ban));
			}
			
			PlayingWithWheels play = new PlayingWithWheels(initial_state, final_state, banList);
			play.run();
		}
		sc.close();

	}

}

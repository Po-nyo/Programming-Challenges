package Q43;

import java.util.Scanner;

/**
 * 
 * @author wkj11
 * Programming Challenges Q43. Counting (셈)
 *
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n;
		
		SpecialCountingService scs = new SpecialCountingService();
		while(sc.hasNextLine()) {
			n = sc.nextInt();
			System.out.println(scs.numOfSequence(n));
		}
		sc.close();
	}

}

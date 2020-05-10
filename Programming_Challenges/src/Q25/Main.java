package Q25;

/**
 * 
 * @author wkj11
 * Programming Challenges Q25. Vito's Family (비토와 친척들)
 * 
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testCaseNum = sc.nextInt();
		
		MoveService ms = new MoveService();
		for(int i=0; i<testCaseNum; i++) {
			int n = sc.nextInt();
			int[] addresses = new int[n];
			
			for(int j=0; j<addresses.length; j++)
				addresses[j] = sc.nextInt();
			
			ms.call(addresses);
		}
		
		sc.close();
	}

}

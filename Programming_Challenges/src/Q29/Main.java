package Q29;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author wkj11
 * Programming Challenges Q29. Shoemaker's Problem (구두 수선공 문제)
 *
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testCaseNum = sc.nextInt();
		sc.nextLine();
		
		for(int i=0; i<testCaseNum; i++) {
			sc.nextLine();
			int n = sc.nextInt();
			Work[] works = new Work[n];
			
			sc.nextLine();
			for(int j=0; j<n; j++) {
				String[] s = sc.nextLine().split(" ");
				works[j] = new Work(Integer.parseInt(s[0]), Integer.parseInt(s[1]), j+1);
			}
			
			Arrays.sort(works);
			
			for(Work w : works) 
				System.out.print(w.getIndex()+" ");
			System.out.println();
		}
		
		sc.close();
	}
}

package Q73;

import java.util.Scanner;

/**
 * 
 * @author wkj11
 * Programming Challenges Q73. Freckles (주근깨)
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
			
			MyPoint[] points = new MyPoint[n];
			for(int j=0; j<n; j++)
				points[j] = new MyPoint(sc.nextDouble(), sc.nextDouble());
			
			Freckles f = new Freckles(points);
			f.call();
		}
		
		sc.close();

	}

}

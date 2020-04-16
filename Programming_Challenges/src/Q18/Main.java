package Q18;

import java.util.Scanner;

/**
 * 
 * @author Ponyo
 * Programming Challenges Q18. Where's Waldorf? (월도르프를 찾아라)
 *
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testCaseNum = sc.nextInt();
		String line;
		sc.nextLine();
		sc.nextLine();
		
		for(int i=0; i<testCaseNum; i++) {
			int rows = sc.nextInt();	// grid 행의 길이
			int cols = sc.nextInt();	// grid 열의 길이
			sc.nextLine();
			
			char[][] grid = new char[rows][cols];
			
			for(int j=0; j<rows; j++) {
				line = sc.nextLine().toLowerCase();
				
				for(int k=0; k<cols; k++)
					grid[j][k] = line.charAt(k);
			}
			
			WaldorfService ws = new WaldorfService(grid);
			
			int n = sc.nextInt();	// 찾을 단어의 갯수
			sc.nextLine();
			
			for(int j=0; j<n; j++) {
				line = sc.nextLine().toLowerCase();
				
				MyPoint p = ws.findLocation(line);
				System.out.println((p.row+1)+" "+(p.col+1));
			}
			System.out.println();
		}
		
		sc.close();
	}

}

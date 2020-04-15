package Q11;

import java.util.Scanner;

/**
 * 
 * @author Ponyo
 * Programming challenges Q11. Hartal (동맹 휴업)
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testCaseNum = sc.nextInt();
		
		for(int i=0; i<testCaseNum; i++) {
			int simulationDays = sc.nextInt();	// 시뮬레이션 날 수
			int n = sc.nextInt();	// 정당의 개수
			int[] h = new int[n];	// 각 정당의 동맹휴업 지수
			
			int count = 0;
			
			for(int j=1; j<=simulationDays; j++) {
				if(!(j%7==6 || j%7==0)) {
					for(int k=0; k<h.length; k++) {
						if(j%h[k] == 0) {
							count++;
							break;
						}
					}
				}
			}
			System.out.println(count);
		}

	}

}

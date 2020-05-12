package Q75;

import java.util.Scanner;

/**
 * 
 * @author wkj11
 * Programming Challenges Q75. Fire Station (소방서)
 *
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		sc.nextLine();
		sc.nextLine();
			
		for(int i=0; i<testCase; i++) {
			int n = sc.nextInt();	// 소방서 갯수
			int v = sc.nextInt();	// 교차로 갯수
				
			int[][] graph = new int[v][v];
			int[] fireStation;	// 소방서의 위치
			// 소방서 위치 입력
			if(n > 0) {	// 소방서 갯수가 0이 아닐 때
				fireStation = new int[n];	
				for(int j=0; j<n; j++) 
					fireStation[j] = sc.nextInt()-1;
			}
			else	// 소방서 갯수가 0 일 때
				fireStation = new int[1];
			// 버퍼제거
			if(sc.hasNextLine())
				sc.nextLine();
			// 도로 입력
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				if(line.equals(""))
					break;
				String[] temp = line.split(" ");
				int v1 = Integer.parseInt(temp[0])-1;
				int v2 = Integer.parseInt(temp[1])-1;
				int weight = Integer.parseInt(temp[2]); 
				graph[v1][v2] = weight;
				graph[v2][v1] = weight;
			}
			
			Solution s = new Solution(graph, fireStation, n);
			s.solution();
		}
		
		sc.close();
	}
}

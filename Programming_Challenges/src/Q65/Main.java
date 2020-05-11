package Q65;

import java.util.Scanner;

/**
 * 
 * @author wkj11
 * Programming Challenges Q65. BiColoring (두 색으로 칠하기)
 *
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int v, e;
		
		BiColoringService bcs = new BiColoringService();
		while(true) {
			v = sc.nextInt();	// 꼭짓점 갯수
			if(v==0)
				break;
			e = sc.nextInt();	// 모서리 갯수
			
			int[][] graph = new int[v][v];
			
			for(int i=0; i<e; i++) {
				int v1 = sc.nextInt();
				int v2 = sc.nextInt();
				graph[v1][v2] = graph[v2][v1] = 1;
			}
			
			bcs.setGraph(graph);
			
			if(bcs.biColoring())
				System.out.println("BICOLORABLE");
			else
				System.out.println("NOT BICOLORABLE");
		}
		
		sc.close();

	}

}

package Q27;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 
 * @author wkj11
 * Programming Challenges Q27. Birdge (다리)
 *
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List<Integer> speeds = new ArrayList<>();
		int testCaseNum = sc.nextInt();
		sc.nextLine();
		
		CrossBridgeService cbs = new CrossBridgeService();
		
		for(int i=0; i<testCaseNum; i++) {
			int n = sc.nextInt();
			
			for(int j=0; j<n; j++)
				speeds.add(sc.nextInt());
			
			cbs.setSpeeds(speeds);
			cbs.solution();
			
			speeds.clear();
		}
		
		sc.close();
	}

}

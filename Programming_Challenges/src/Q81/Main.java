package Q81;
/**
 * @author WOO
 * Programming Challenges Q81. Is Bigger Smarter? (큰 것이 더 똑똑하다?)
 * 
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Elephant> elephants = new ArrayList<>();
			
		int count = 1;
		while(sc.hasNextLine()) {	// elephant 리스트에 파일 끝날 때까지 코끼리 추가
			Elephant e = new Elephant(sc.nextInt(), sc.nextInt(), count++);
			elephants.add(e);
		}
		
		LongestSequenceService lss = new LongestSequenceService(elephants);
		lss.call();

		sc.close();

	}

}

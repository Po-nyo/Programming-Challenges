package Q21;

import java.util.Scanner;

/**
 * 
 * @author Ponyo
 * Programming Challenges Q21. Automated Judge Script (자동 심사 스크립트)
 *
 */
public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AutoJudge autoJudge = new AutoJudge();
		
		while(true) {
			
			int answerN = sc.nextInt();	// 정답 줄 갯수
			if(answerN == 0)
				break;
			
			String[] answer = new String[answerN];
			sc.nextLine();
			
			for(int i=0; i<answer.length; i++)
				answer[i] = sc.nextLine();
			
			int submitN = sc.nextInt();	// 제출 줄 갯수
			String[] submit = new String[submitN];
			sc.nextLine();
			
			for(int i=0; i<submit.length; i++)
				submit[i] = sc.nextLine();
			
			autoJudge.judge(answer, submit);
		}
		
		sc.close();
	}

}

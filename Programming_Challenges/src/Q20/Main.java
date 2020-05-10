package Q20;

import java.util.Scanner;

/**
 * 
 * @author Ponyo
 * Programming Challenges Q20. CryptKickerⅡ (암호 깨기Ⅱ) 
 *
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String line;
		int testCaseNum = sc.nextInt();
		sc.nextLine();
		sc.nextLine();
		
		CryptKicker ck = new CryptKicker();
		
		for(int i=0; i<testCaseNum; i++) {
			String[] sentences;
			String sentence = "";
			
			while(sc.hasNextLine()) {
				line = sc.nextLine();
				if(line.equals(""))
					break;
				sentence += line+"/"; 
			}
			
			sentences = sentence.split("/");
			ck.setCodedStrings(sentences);
			ck.call();
		}
		
		sc.close();
	}

}

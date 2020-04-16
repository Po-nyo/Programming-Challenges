package Q17;

import java.util.Scanner;

/**
 * 
 * @author Ponyo
 * Programming Challenges Q17. WERTYU
 *
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String line;
		
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			System.out.println(restore(line));
		}
		
		sc.close();
	}
	
	public static String restore(String origin) {
		String keyBoard = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";
		String restored = "";
		
		for(int i=0; i<origin.length(); i++) {
			char currentChar = origin.charAt(i);
			
			if(currentChar == ' ')
				restored += ' ';
			else
				restored += keyBoard.charAt(keyBoard.indexOf(currentChar)-1);
		}
		
		return restored;
	}

}

package Q22;

import java.util.Scanner;

/**
 * 
 * @author wkj11
 * Programming Challenges Q22. File Fragmentation (파일 조각)
 *
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testCaseNum = sc.nextInt();
		sc.nextLine();
		sc.nextLine();
		
		FileRestoreService frs = new FileRestoreService();
		
		for(int i=0; i<testCaseNum; i++) {
			String fragments = "";
			
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				
				if(line.equals(""))
					break;
				
				fragments += line+" ";
			}
			
			String original = frs.getOriginal(fragments.split(" "));
			System.out.println(original);
			System.out.println();
		}
		
		sc.close();

	}

}

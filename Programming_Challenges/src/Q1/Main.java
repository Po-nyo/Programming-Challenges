package Q1;
/**
 * 
 * @author Ponyo
 * Programming Challenge Q1. 3n+1 문제
 *
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int first, last;	// 첫번째 숫자, 마지막 숫자
        
        Solution solution = new Solution();	// Solution 객체
        
        while(sc.hasNextLine()) {
        	first = sc.nextInt();
        	last = sc.nextInt();
        	
        	System.out.print(first+" "+last+" ");
        	System.out.println(solution.getCycleLength(first, last));
        }
        
        sc.close();

	}

}

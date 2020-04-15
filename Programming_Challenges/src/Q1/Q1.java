package Q1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * @author Ponyo
 * Programming Challenge Q1. 3n+1 문제
 *
 */

public class Q1 {

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

class Solution {
	
	// 이미 계산한 cycle-length 저장
	Map<Integer, Integer> cycle_length;	
	
	public Solution() {
		cycle_length = new HashMap<>();
	}
	
	public int getCycleLength(int first, int last) {
		int max = 0;	// 최대 cycle-length
		
		for(int i=first; i<=last; i++) {
			int current = 1;	// i에 대한 현재 cycle-length
			
			// cycle-length를 계산한 적이 없는 i의 경우
			if(!cycle_length.containsKey(i)) {
				int num = i;
				
				while(num != 1) {
					if(num%2 == 0)
						num /= 2;
					else
						num = num*3 + 1;
					current++;
				}
				
				cycle_length.put(i, current);
			}
			else	// cycle-length를 계산한 적이 있는 i의 경우
				current = cycle_length.get(i);
			
			//max값 갱신
			if(max < current)
				max = current;
		}
		return max;
	}
}
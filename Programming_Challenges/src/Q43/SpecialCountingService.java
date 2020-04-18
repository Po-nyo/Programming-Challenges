package Q43;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class SpecialCountingService {
	
	private List<BigInteger> list;
	private int[] numbers = {1, 2, 3, 1};
	final int MAX_N = 1000;
	
	private int cnt;
	
	public SpecialCountingService() {
		makeList();
	}
	
	public BigInteger numOfSequence(int n) {
		return list.get(n-1);
	}
	
	private void makeList() {
		list = new ArrayList<BigInteger>();
		/*
		 * 합이 n인 숫자배열의 갯수 = 
		 * 합이 n-1인 숫자배열의 갯수*2 
		 * + 합이 n-2인 숫자배열의 갯수
		 * + 합이 n-3인 숫자배열의 갯수 
		 */
		for(int i=1; i<=3; i++) {
			cnt = 0;
			count(i);
			list.add(new BigInteger(""+cnt));
		}
		
		for(int i=4; i<=MAX_N; i++)
			list.add(list.get(i-2).add(list.get(i-2).add(list.get(i-3)).add(list.get(i-4))));
	}
	
	private void count(int n) {
		for(int i=0; i<numbers.length; i++) {
			int calculated = n - numbers[i];
			
			if(calculated == 0)
				cnt++;
			else if(calculated > 0)
				count(calculated);
		}
	}
	
}

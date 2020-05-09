package Q9;

import java.util.Arrays;

public class Solution {
	
	public void call(int[] inputSequence) {
		// 인접한 수의 차 저장
		int[] differences = new int[inputSequence.length-1];
		
		for(int i=0; i<inputSequence.length-1; i++)
			differences[i] = Math.abs(inputSequence[i] - inputSequence[i+1]);
		
		if(isJollyJumper(differences))
			System.out.println("Jolly");
		else
			System.out.println("Not jolly");
	}
	
	private boolean isJollyJumper(int[] differences) {
		Arrays.sort(differences);
		
		for(int i=0; i<differences.length; i++) {
			if((i+1) != differences[i])
				return false;
		}
		
		return true;
	}

}

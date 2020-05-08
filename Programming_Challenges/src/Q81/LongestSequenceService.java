package Q81;

import java.util.ArrayList;
import java.util.Collections;

public class LongestSequenceService {
	private ArrayList<Elephant> elephants;

	public LongestSequenceService(ArrayList<Elephant> elephants) {
		Collections.sort(elephants);	// 몸무게 오름차순 정렬
		this.elephants = elephants;
	}
	
	public void call() {
		longestSequence();
	}
	
	private void longestSequence() {
		int[] dp = new int[elephants.size()];		// 부분 수열의 길이 저장
		int[] parent = new int[elephants.size()];	// parentIndex 저장
		dp[0] = 1;	// 처음 길이는 1
			
		int maxLength = 0;
		int maxDpIndex = 0;
		for(int i=0; i<dp.length; i++) {
			int max = 0;
			int maxIndex = i;
			for(int j=0; j<i; j++) {	// iq는 내림차순, weight는 오름차순이 되도록
				if(elephants.get(i).iq < elephants.get(j).iq && max<dp[j] && elephants.get(i).weight > elephants.get(j).weight) {
					max = dp[j];	// 가장 긴 길이를 저장
					maxIndex = j;	// 가장 긴 길이를 가지는 index 저장
				}
			}
			
			dp[i] = max+1;			// max+1을 현재 번호에 저장
			parent[i] = maxIndex;	// 해당 index를 parent로 저장
			
			if(maxLength <= dp[i]) {
				maxLength = dp[i];
				maxDpIndex = i;
			}
		}
		
		// 출력
		System.out.println(maxLength);
		printSubsequence(parent, maxDpIndex);
	}

	private void printSubsequence(int[] parent, int maxIndex) {
		int index = maxIndex;
		String sub = ""+elephants.get(index).n;
			
		while(parent[index] != index) {
			sub = elephants.get(parent[index]).n + "\n" + sub;
			index = parent[index];
		}
			
		System.out.println(sub);
	}


}
